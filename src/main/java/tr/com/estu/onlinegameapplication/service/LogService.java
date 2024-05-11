package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.LogDTO;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.Log;
import tr.com.estu.onlinegameapplication.repository.LogRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class LogService extends BaseService<Log, LogDTO, LogRepository> {

    public LogService(LogRepository dao) {
        super(dao, LogDTO.class, Log.class);
    }

    @Override
    public LogDTO save(LogDTO dto) {
        log.info("Saving log to db...");
        return Mapper.map(getDao().save(Mapper.map(dto, Log.class)), LogDTO.class);
    }

}
