package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.model.User;
import tr.com.estu.onlinegameapplication.repository.UserRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class UserService extends BaseService<User, UserRepository> {
    public UserService(UserRepository dao) {
        super(dao);
    }
}
