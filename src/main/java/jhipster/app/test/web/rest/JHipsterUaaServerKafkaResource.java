package jhipster.app.test.web.rest;

import jhipster.app.test.service.JHipsterUaaServerKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/j-hipster-uaa-server-kafka")
public class JHipsterUaaServerKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JHipsterUaaServerKafkaResource.class);

    private JHipsterUaaServerKafkaProducer kafkaProducer;

    public JHipsterUaaServerKafkaResource(JHipsterUaaServerKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
