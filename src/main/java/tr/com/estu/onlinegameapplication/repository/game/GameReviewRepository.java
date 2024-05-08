package tr.com.estu.onlinegameapplication.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.estu.onlinegameapplication.model.game.GameReview;

public interface GameReviewRepository extends JpaRepository<GameReview, Long> {
}
