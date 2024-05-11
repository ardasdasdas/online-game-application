package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.game.GameDTO;
import tr.com.estu.onlinegameapplication.service.game.GameService;

import java.util.List;

@RestController
@RequestMapping("/games")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    public GameDTO createGame(@RequestBody GameDTO gameDTO) {
        return gameService.save(gameDTO);
    }

    @GetMapping
    public List<GameDTO> getAllGameReviews() {
        return gameService.findAll();
    }

    @GetMapping("/{id}")
    public GameDTO getGameReview(@PathVariable Long id) {
        return gameService.findByIdWithControl(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGameReview(@PathVariable Long id) {
        gameService.deleteById(id);
    }
}

