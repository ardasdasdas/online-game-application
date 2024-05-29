package tr.com.estu.onlinegameapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tr.com.estu.onlinegameapplication.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
