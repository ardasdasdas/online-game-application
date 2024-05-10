package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.PurchaseDTO;
import tr.com.estu.onlinegameapplication.model.Purchase;
import tr.com.estu.onlinegameapplication.repository.PurchaseRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

@Slf4j
@Service
public class PurchaseService extends BaseService<Purchase, PurchaseDTO, PurchaseRepository> {
    public PurchaseService(PurchaseRepository dao) {
        super(dao, PurchaseDTO.class, Purchase.class);
    }
}
