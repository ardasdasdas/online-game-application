package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.model.Discount;
import tr.com.estu.onlinegameapplication.repository.DiscountRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class DiscountService extends BaseService<Discount, DiscountRepository> {
    public DiscountService(DiscountRepository dao) {
        super(dao);
    }
}
