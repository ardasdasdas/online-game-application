package tr.com.estu.onlinegameapplication.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.estu.onlinegameapplication.dto.UserDTO;
import tr.com.estu.onlinegameapplication.exception.ItemNotFoundException;
import tr.com.estu.onlinegameapplication.exception.error.GenericErrorMessage;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.User;
import tr.com.estu.onlinegameapplication.model.base.BaseAdditionalFields;
import tr.com.estu.onlinegameapplication.repository.UserRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Slf4j
@Service
public class UserService extends BaseService<User, UserDTO, UserRepository> {
    public UserService(UserRepository dao) {
        super(dao, UserDTO.class, User.class);
    }
}
