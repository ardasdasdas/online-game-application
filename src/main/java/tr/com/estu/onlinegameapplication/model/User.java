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
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

}
