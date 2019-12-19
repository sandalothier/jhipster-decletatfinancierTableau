package com.fisc.decletatfinanciertableau.web.rest;

import com.fisc.decletatfinanciertableau.service.DecletatfinancierTableauKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decletatfinancier-tableau-kafka")
public class DecletatfinancierTableauKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecletatfinancierTableauKafkaResource.class);

    private DecletatfinancierTableauKafkaProducer kafkaProducer;

    public DecletatfinancierTableauKafkaResource(DecletatfinancierTableauKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
