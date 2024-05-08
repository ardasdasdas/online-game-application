package tr.com.estu.onlinegameapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.estu.onlinegameapplication.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
