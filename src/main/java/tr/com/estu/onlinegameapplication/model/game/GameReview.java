package tr.com.estu.onlinegameapplication.model.game;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.estu.onlinegameapplication.enums.ReviewRate;
import tr.com.estu.onlinegameapplication.model.base.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "game_review")
public class GameReview extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="game_id")
    private int gameId;

    @Column(name ="user_id")
    private int userId;

    @Column(name ="review")
    private String review;

    @Column(name ="review_rate", length = 5)
    @Enumerated(EnumType.STRING)
    private ReviewRate reviewRate;
}
