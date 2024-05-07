package tr.com.estu.onlinegameapplication.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tr.com.estu.onlinegameapplication.model.Log;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LogProducer {

    private final KafkaTemplate<String, Log> kafkaTemplate;

    private static final String TOPIC = "log-topic";

    public void sendLog(Log log) {
        String id = UUID.randomUUID().toString();

        kafkaTemplate.send(TOPIC, id, log);
    }
}
