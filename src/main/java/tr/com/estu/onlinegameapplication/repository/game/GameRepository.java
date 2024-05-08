package tr.com.estu.onlinegameapplication.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.estu.onlinegameapplication.model.game.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
