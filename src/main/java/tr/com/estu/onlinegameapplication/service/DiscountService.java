package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tr.com.estu.onlinegameapplication.dto.DiscountDTO;
import tr.com.estu.onlinegameapplication.dto.LogDTO;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.model.Discount;
import tr.com.estu.onlinegameapplication.repository.DiscountRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;

import java.util.Date;

import static java.util.Objects.nonNull;

@Slf4j
@Service
public class DiscountService extends BaseService<Discount, DiscountDTO, DiscountRepository> {

    public DiscountService(DiscountRepository dao) {
        super(dao, DiscountDTO.class, Discount.class);
    }

    public double applyDiscount(GameDTO gameDTO, DiscountDTO discountDTO, String discountCode) {
        if (isValidDiscountCode(discountDTO, discountCode)) {
            double discountedPrice = gameDTO.getPrice() - discountDTO.getAmount();
            getLogProducer().sendLog(new LogDTO("Discount applied to game with id: " + gameDTO.getTitle()
                    + " with discount code: " + discountCode));
            return discountedPrice > 0 ? discountedPrice : 0;
        } else {
            getLogProducer().sendLog(new LogDTO("Discount code is not valid for game with id: " + gameDTO.getTitle()
                            + " with discount code: " + discountCode));
            return gameDTO.getPrice();
        }
    }

    private boolean isValidDiscountCode(DiscountDTO discountDTO, String discountCode) {
        return discountDTO.getCode().equals(discountCode) &&
                nonNull(discountDTO.getExpirationDate()) &&
                discountDTO.getExpirationDate().after(new Date());
    }
}
