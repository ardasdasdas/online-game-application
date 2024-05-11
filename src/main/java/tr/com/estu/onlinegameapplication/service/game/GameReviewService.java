package tr.com.estu.onlinegameapplication.service.game;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.game.GameReviewDTO;
import tr.com.estu.onlinegameapplication.model.game.GameReview;
import tr.com.estu.onlinegameapplication.repository.game.GameReviewRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

import java.util.List;

import static tr.com.estu.onlinegameapplication.mapper.Mapper.mapList;

@Slf4j
@Service
public class GameReviewService extends BaseService<GameReview, GameReviewDTO, GameReviewRepository> {
    public GameReviewService(GameReviewRepository dao) {
        super(dao, GameReviewDTO.class, GameReview.class);
    }

    @Cacheable(value = "gameReviews", key = "#gameId")
    public List<GameReviewDTO> findByGameId(Long gameId) {
        List<GameReview> reviewList = getDao().findAllByGameId(gameId);
        return mapList(reviewList, GameReviewDTO.class);
    }
}
