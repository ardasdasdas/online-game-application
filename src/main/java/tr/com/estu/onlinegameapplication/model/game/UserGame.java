package tr.com.estu.onlinegameapplication.model.game;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.estu.onlinegameapplication.model.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_game")
public class UserGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "game_id")
    private Long gameId;
}
