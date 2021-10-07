package com.mbproject.domainservice;

import model.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.function.Consumer;

@Configuration
public class DomainKafkaConsumer {

  @Bean
  public Consumer<KStream<String, Domain>> domainService() {
    JsonDeserializer<Domain> deserializer = new JsonDeserializer<>(Domain.class);
    deserializer.addTrustedPackages("*");
    return kstream -> kstream.foreach((key, value) -> System.out.println("Mahes output=>"+kstream.groupByKey().count().toString()));
           /*
    return kstream -> kstream.foreach((key, domain) -> {
      if(domain.isDead()) {
        //System.out.println(String.format("Domain consumed[%s] Status[%s]", domain.getDomain(), domain.isDead()));
        System.out.println(domain);
      }
    }
    */
  }
  }

