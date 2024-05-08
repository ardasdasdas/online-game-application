package tr.com.estu.onlinegameapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.estu.onlinegameapplication.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
