package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.dto.game.GameReviewDTO;
import tr.com.estu.onlinegameapplication.service.game.GameReviewService;

import java.util.List;

@RestController
@RequestMapping("/game-reviews")
@RequiredArgsConstructor
public class GameReviewController {

    private final GameReviewService gameReviewService;

    @PostMapping
    public ResponseEntity<RestResponse<GameReviewDTO>> createGameReview(@RequestBody GameReviewDTO gameReviewDTO) {
        return ResponseEntity.ok(RestResponse.of(gameReviewService.save(gameReviewDTO)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<GameReviewDTO>>> getAllGameReviews() {
        return ResponseEntity.ok(RestResponse.of(gameReviewService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<GameReviewDTO>> getGameReview(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(gameReviewService.findByIdWithControl(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<GameReviewDTO>> deleteGameReview(@PathVariable Long id) {
        gameReviewService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<RestResponse<List<GameReviewDTO>>> getGameReviewsByGameId(@PathVariable Long gameId) {
        return ResponseEntity.ok(RestResponse.of(gameReviewService.findByGameId(gameId)));
    }
}

