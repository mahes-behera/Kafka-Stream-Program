package com.mbproject.kafkastreamprocessor;

import com.mbproject.kafkastreamprocessor.model.Domain;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.function.Function;

@Configuration
public class DomainKafkaProcessor {

  @Bean
  public Function<KStream<String, Domain>, KStream<String, Domain>> domainProcessor() {
    JsonDeserializer<Domain> deserializer = new JsonDeserializer<>(Domain.class);
    //deserializer.setRemoveTypeHeaders(false);
    deserializer.addTrustedPackages("*");
    //deserializer.setUseTypeMapperForKey(true);

    return kstream -> kstream.filter((key, domain) -> {
      if (domain.isDead()) {
        System.out.println("Inactive Domain: " + domain.getDomain());
      } else {
        System.out.println("Active Domain: " + domain.getDomain());
      }
      return !domain.isDead();
    });

  }
}
