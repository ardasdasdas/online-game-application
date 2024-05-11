package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.DiscountDTO;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping
    public DiscountDTO createDiscount(@RequestBody DiscountDTO discountDTO) {
        return discountService.save(discountDTO);
    }

    @GetMapping
    public List<DiscountDTO> getAllDiscounts() {
        return discountService.findAll();
    }

    @GetMapping("/{id}")
    public DiscountDTO getDiscount(@PathVariable Long id) {
        return discountService.findByIdWithControl(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDiscount(@PathVariable Long id) {
        discountService.deleteById(id);
    }

    @PostMapping("/{discountCode}/apply")
    public double applyDiscount(@PathVariable String discountCode, @RequestBody GameDTO gameDTO, @RequestBody DiscountDTO discountDTO) {
        return discountService.applyDiscount(gameDTO, discountDTO, discountCode);
    }
}

