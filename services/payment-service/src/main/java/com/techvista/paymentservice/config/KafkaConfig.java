package com.techvista.paymentservice.config;

import com.techvista.paymentservice.kafka.InventoryUpdatedEvent;
import com.techvista.paymentservice.kafka.PaymentCompletedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, PaymentCompletedEvent> producerFactory() {


        Map<String,Object> config =
                new HashMap<>();


        config.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );


        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class
        );


        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class
        );


        config.put(
                JsonSerializer.ADD_TYPE_INFO_HEADERS,
                false
        );


        return new DefaultKafkaProducerFactory<>(
                config
        );
    }


    @Bean
    public KafkaTemplate<String, PaymentCompletedEvent>
    inventoryKafkaTemplate() {
        return new KafkaTemplate<>(
                producerFactory()
        );
    }


    @Bean
    public ConsumerFactory<String, InventoryUpdatedEvent> consumerFactory(){


        Map<String,Object> config = new HashMap<>();


        config.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );


        config.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "payment-group"
        );


        config.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class
        );


        config.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                JsonDeserializer.class
        );

        JsonDeserializer<InventoryUpdatedEvent> deserializer =
                new JsonDeserializer<>(
                        InventoryUpdatedEvent.class
                );
        deserializer.addTrustedPackages("*");


        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                deserializer
        );

    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,InventoryUpdatedEvent>
    kafkaListenerContainerFactory(){


        var factory =
                new ConcurrentKafkaListenerContainerFactory





                        <String,InventoryUpdatedEvent>();


        factory.setConsumerFactory(
                consumerFactory()
        );


        return factory;

    }

}
