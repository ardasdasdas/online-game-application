package tr.com.estu.onlinegameapplication.kafka;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tr.com.estu.onlinegameapplication.dto.LogDTO;
import tr.com.estu.onlinegameapplication.service.LogService;

@Slf4j
@Component
@RequiredArgsConstructor
public class LogConsumer {

    private final LogService logService;

    @KafkaListener(
            topics = "log-topic",
            groupId = "log-group"
    )
    @Transactional
    public void consume(LogDTO consumedLog) {
        log.info("Message received by consumer... " + consumedLog.getMessage());
        saveLogToDb(consumedLog);
    }

    public void saveLogToDb(LogDTO consumedLog) {
        log.info("**********************************");
        log.info("start");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        logService.save(consumedLog);
        log.info("end");
    }
}
