package tr.com.estu.onlinegameapplication.service.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.mongo.UserGameCollectionDTO;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.mongo.UserGameCollection;
import tr.com.estu.onlinegameapplication.repository.mongo.UserGameCollectionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGameCollectionService {

    private final UserGameCollectionRepository userGameCollectionRepository;

    public UserGameCollectionDTO save(UserGameCollectionDTO userGameCollectionDTO) {
        return Mapper.map(userGameCollectionRepository.save(
                Mapper.map(userGameCollectionDTO, UserGameCollection.class)), UserGameCollectionDTO.class);
    }

    public UserGameCollectionDTO findById(String id) {
        return Mapper.map(userGameCollectionRepository.findById(id), UserGameCollectionDTO.class);
    }

    public List<UserGameCollectionDTO> findAll() {
        return Mapper.mapList(userGameCollectionRepository.findAll(), UserGameCollectionDTO.class);
    }

    public void deleteById(String id) {
        userGameCollectionRepository.deleteById(id);
    }

}

