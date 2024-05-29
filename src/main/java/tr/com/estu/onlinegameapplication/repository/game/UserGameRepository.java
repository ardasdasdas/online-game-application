package tr.com.estu.onlinegameapplication.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.estu.onlinegameapplication.model.game.UserGame;

public interface UserGameRepository extends JpaRepository<UserGame, Long> {
}
