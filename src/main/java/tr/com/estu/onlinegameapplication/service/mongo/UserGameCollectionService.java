package tr.com.estu.onlinegameapplication.service.mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.mongo.UserGameCollectionDTO;
import tr.com.estu.onlinegameapplication.mapper.Mapper;
import tr.com.estu.onlinegameapplication.model.game.UserGame;
import tr.com.estu.onlinegameapplication.model.mongo.UserGameCollection;
import tr.com.estu.onlinegameapplication.repository.game.UserGameRepository;
import tr.com.estu.onlinegameapplication.repository.mongo.UserGameCollectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class UserGameCollectionService {

    private final UserGameCollectionRepository userGameCollectionRepository;
    private final UserGameRepository userGameRepository;

    public UserGameCollectionDTO save(UserGameCollectionDTO userGameCollectionDTO) {
        return Mapper.map(userGameCollectionRepository.save(
                Mapper.map(userGameCollectionDTO, UserGameCollection.class)), UserGameCollectionDTO.class);
    }

    public UserGameCollectionDTO save(Long userId, Long gameId) {
        UserGameCollection userGameCollection = userGameCollectionRepository.findByUserId(userId.toString());

        if(isNull(userGameCollection))
        {
            userGameCollection = new UserGameCollection();
            userGameCollection.setUserId(userId.toString());
        }
        userGameCollection.getGameIds().add((gameId));
        return Mapper.map(userGameCollectionRepository.save(userGameCollection), UserGameCollectionDTO.class);
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

    public void evictMongo() {
        userGameCollectionRepository.deleteAll();
        List<UserGame> userGameList = userGameRepository.findAll();
        Map<Long, List<Long>> userGameMap = userGameList.stream()
                .collect(Collectors.groupingBy(UserGame::getUserId,
                        Collectors.mapping(UserGame::getGameId, Collectors.toList())));
        List<UserGameCollection> userGameCollectionList = new ArrayList<>();
        userGameMap.forEach((key, value) -> {
            UserGameCollection userGameCollection = new UserGameCollection();
            userGameCollection.setUserId(key.toString());
            userGameCollection.setGameIds(value);
            userGameCollectionList.add(userGameCollection);
        });
        saveAll(userGameCollectionList);
    }

    private void saveAll(List<UserGameCollection> userGameCollectionList) {
        userGameCollectionRepository.saveAll(userGameCollectionList);
    }
}

