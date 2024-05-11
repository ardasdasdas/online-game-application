package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.service.game.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity<RestResponse<GameDTO>> createGame(@RequestBody GameDTO gameDTO) {
        return ResponseEntity.ok(RestResponse.of(gameService.save(gameDTO)));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<GameDTO>>> getAllGameReviews() {
        return ResponseEntity.ok(RestResponse.of(gameService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<GameDTO>> getGameReview(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(gameService.findByIdWithControl(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<GameDTO>> deleteGameReview(@PathVariable Long id) {
        gameService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}

