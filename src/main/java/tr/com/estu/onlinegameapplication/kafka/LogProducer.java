package tr.com.estu.onlinegameapplication.kafka;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import tr.com.estu.onlinegameapplication.dto.LogDTO;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LogProducer {

    private final KafkaTemplate<String, LogDTO> kafkaTemplate;

    private static final String TOPIC = "log-topic";

    public void sendLog(LogDTO log) {
        String id = UUID.randomUUID().toString();

        kafkaTemplate.send(TOPIC, id, log);
    }
}
