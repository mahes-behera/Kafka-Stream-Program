package com.mbproject.domainproducer;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DomainCrawlerService {

  private KafkaTemplate<String, Domain> kafkaTemplate;
  private final String KAFKA_TOPIC = "mytopic10";

  public DomainCrawlerService(KafkaTemplate<String, Domain> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void crawl() {

    Mono<DomainList> domainListMono = WebClient.create()
        .get()
        .uri("http://localhost:8181/domain/list")
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(DomainList.class);

    domainListMono.subscribe(domainList -> {
      domainList.domains
          .forEach(domain -> {
            kafkaTemplate.send(KAFKA_TOPIC, domain);
            System.out.println("Domain message" + domain.getDomain());
          });
    });

  }
}
