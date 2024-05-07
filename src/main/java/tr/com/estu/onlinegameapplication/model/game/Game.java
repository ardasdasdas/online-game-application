package tr.com.estu.onlinegameapplication.model.game;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.estu.onlinegameapplication.model.base.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "game")
public class Game extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title", unique = true)
    private String title;

    @Column(name ="description")
    private String description;

    @Column(name ="price")
    private double price;

    @Column(name ="category_id")
    private Long categoryId;
}
