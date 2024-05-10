package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.LogDTO;
import tr.com.estu.onlinegameapplication.model.Log;
import tr.com.estu.onlinegameapplication.repository.LogRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

import java.util.UUID;

@Slf4j
@Service
public class LogService extends BaseService<Log, LogDTO, LogRepository> {

    private static final String TOPIC = "log-topic";

    @Autowired
    private KafkaTemplate<String, LogDTO> kafkaTemplate;

    public LogService(LogRepository dao) {
        super(dao, LogDTO.class, Log.class);
    }

    public void log(LogDTO logDTO) {
        String id = UUID.randomUUID().toString();

        kafkaTemplate.send(TOPIC, id, logDTO);
    }
}
