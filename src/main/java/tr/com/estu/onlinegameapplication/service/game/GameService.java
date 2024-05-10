package tr.com.estu.onlinegameapplication.service.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.model.game.Game;
import tr.com.estu.onlinegameapplication.repository.game.GameRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class GameService extends BaseService<Game, GameDTO, GameRepository> {
    public GameService(GameRepository dao) {
        super(dao, GameDTO.class, Game.class);
    }
}
