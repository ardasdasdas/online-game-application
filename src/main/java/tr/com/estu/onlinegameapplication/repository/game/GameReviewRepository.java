package tr.com.estu.onlinegameapplication.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.estu.onlinegameapplication.model.game.GameReview;

import java.util.List;

@Repository
public interface GameReviewRepository extends JpaRepository<GameReview, Long> {
    List<GameReview> findAllByGameId(Long gameId);
}
