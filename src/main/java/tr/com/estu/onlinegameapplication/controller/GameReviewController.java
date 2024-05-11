package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.game.GameReviewDTO;
import tr.com.estu.onlinegameapplication.service.game.GameReviewService;

import java.util.List;

@RestController
@RequestMapping("/game-reviews")
@RequiredArgsConstructor
public class GameReviewController {

    private final GameReviewService gameReviewService;

    @PostMapping
    public GameReviewDTO createGameReview(@RequestBody GameReviewDTO gameReviewDTO) {
        return gameReviewService.save(gameReviewDTO);
    }

    @GetMapping
    public List<GameReviewDTO> getAllGameReviews() {
        return gameReviewService.findAll();
    }

    @GetMapping("/{id}")
    public GameReviewDTO getGameReview(@PathVariable Long id) {
        return gameReviewService.findByIdWithControl(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameReview(@PathVariable Long id) {
        gameReviewService.deleteById(id);
    }

    @GetMapping("/game/{gameId}")
    public List<GameReviewDTO> getGameReviewsByGameId(@PathVariable Long gameId) {
        return gameReviewService.findByGameId(gameId);
    }
}

