package tr.com.estu.onlinegameapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.estu.onlinegameapplication.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
