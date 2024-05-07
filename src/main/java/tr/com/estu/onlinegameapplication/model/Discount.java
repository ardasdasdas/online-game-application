package tr.com.estu.onlinegameapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import tr.com.estu.onlinegameapplication.model.base.BaseEntity;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "discount")
public class Discount extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "amount")
    private double amount;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

}
