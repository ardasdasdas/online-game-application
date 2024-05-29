package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.PurchaseDTO;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.service.PurchaseService;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<RestResponse<PurchaseDTO>> purchaseGame(@RequestBody PurchaseDTO purchaseDTO) {
        purchaseService.purchaseGame(purchaseDTO);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<PurchaseDTO>>> getAllPurchases() {
        return ResponseEntity.ok(RestResponse.of(purchaseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<PurchaseDTO>> getPurchase(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(purchaseService.findByIdWithControl(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<PurchaseDTO>> deletePurchase(@PathVariable Long id) {
        purchaseService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}

