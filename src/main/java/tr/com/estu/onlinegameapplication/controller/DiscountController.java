package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.DiscountDTO;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping
    public ResponseEntity<RestResponse<DiscountDTO>> createDiscount(@RequestBody DiscountDTO discountDTO) {
        return ResponseEntity.ok(RestResponse.of(discountService.save(discountDTO)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<DiscountDTO>>> getAllDiscounts() {
        return ResponseEntity.ok(RestResponse.of(discountService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<DiscountDTO>> getDiscount(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(discountService.findByIdWithControl(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<DiscountDTO>> deleteDiscount(@PathVariable Long id) {
        discountService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @PostMapping("/{discountCode}/apply")
    public ResponseEntity<RestResponse<Double>> applyDiscount(@PathVariable String discountCode,
                                                              @RequestBody GameDTO gameDTO,
                                                              @RequestBody DiscountDTO discountDTO) {
        return ResponseEntity.ok(RestResponse.of(discountService.applyDiscount(gameDTO, discountDTO, discountCode)));
    }
}

