package tr.com.estu.onlinegameapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.estu.onlinegameapplication.model.base.BaseEntity;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "purchase")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "discount_id")
    private Long purchaseId;

    @Column(name = "amount")
    private double amount;
}
