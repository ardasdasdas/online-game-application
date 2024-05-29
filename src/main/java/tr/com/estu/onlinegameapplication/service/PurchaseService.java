package tr.com.estu.onlinegameapplication.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.estu.onlinegameapplication.dto.PurchaseDTO;
import tr.com.estu.onlinegameapplication.dto.mongo.UserGameCollectionDTO;
import tr.com.estu.onlinegameapplication.model.Purchase;
import tr.com.estu.onlinegameapplication.model.game.UserGame;
import tr.com.estu.onlinegameapplication.repository.PurchaseRepository;
import tr.com.estu.onlinegameapplication.repository.game.UserGameRepository;
import tr.com.estu.onlinegameapplication.service.base.BaseService;
import tr.com.estu.onlinegameapplication.service.game.GameService;
import tr.com.estu.onlinegameapplication.service.mongo.UserGameCollectionService;

@Slf4j
@Service
public class PurchaseService extends BaseService<Purchase, PurchaseDTO, PurchaseRepository> {

    private final GameService gameService;
    private final UserService userService;
    private final UserGameCollectionService userGameCollectionService;
    private final UserGameRepository userGameRepository;


    public PurchaseService(PurchaseRepository dao, GameService gameService, UserService userService,
                           UserGameCollectionService userGameCollectionService, UserGameRepository userGameRepository) {
        super(dao, PurchaseDTO.class, Purchase.class);
        this.gameService = gameService;
        this.userService = userService;
        this.userGameCollectionService = userGameCollectionService;
        this.userGameRepository = userGameRepository;
    }

    @Transactional
    public void purchaseGame(PurchaseDTO purchaseDTO)
    {
        Long userId = purchaseDTO.getUserId();
        Long gameId = purchaseDTO.getGameId();

        gameService.findByIdWithControl(gameId);
        userService.findByIdWithControl(userId);

        UserGame userGame = new UserGame();
        userGame.setGameId(gameId);
        userGame.setUserId(userId);

        save(purchaseDTO);
        userGameRepository.save(userGame);
        userGameCollectionService.save(userId, gameId);
    }
}
