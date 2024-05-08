package tr.com.estu.onlinegameapplication.service.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.model.game.GameReview;
import tr.com.estu.onlinegameapplication.repository.game.GameReviewRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class GameReviewService extends BaseService<GameReview, GameReviewRepository> {
    public GameReviewService(GameReviewRepository dao) {
        super(dao);
    }
}
