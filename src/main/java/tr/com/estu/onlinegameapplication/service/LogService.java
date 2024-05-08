package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.model.Log;
import tr.com.estu.onlinegameapplication.repository.LogRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class LogService extends BaseService<Log, LogRepository> {
    public LogService(LogRepository dao) {
        super(dao);
    }
}
