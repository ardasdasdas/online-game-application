package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.model.Log;
import tr.com.estu.onlinegameapplication.repository.LogRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

import java.util.UUID;

@Slf4j
@Service
public class LogService extends BaseService<Log, LogRepository> {

    private static final String TOPIC = "log-topic";

    @Autowired
    private KafkaTemplate<String, Log> kafkaTemplate;

    public LogService(LogRepository dao) {
        super(dao);
    }

    public void log(Log log) {
        String id = UUID.randomUUID().toString();

        kafkaTemplate.send(TOPIC, id, log);
    }
}
