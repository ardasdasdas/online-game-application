package tr.com.estu.onlinegameapplication.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tr.com.estu.onlinegameapplication.model.Log;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogConsumer {
    @KafkaListener(
            topics = "log-topic",
            groupId = "log-group"
    )
    public void consume(Log consumedLog) {
        log.info("Message received by consumer... " + consumedLog.getMessage());
        saveLogToDb(consumedLog);
    }

    public void saveLogToDb(Log consumedLog) {
        System.out.println("**********************************");

        // TODO: call LogRepository.save(consumedLog)

        System.out.println("end");
    }
}
