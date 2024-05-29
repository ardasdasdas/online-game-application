package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.dto.mongo.UserGameCollectionDTO;
import tr.com.estu.onlinegameapplication.model.mongo.UserGameCollection;
import tr.com.estu.onlinegameapplication.service.mongo.UserGameCollectionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-game-collections")
@RequiredArgsConstructor
public class UserGameCollectionController {

    private final UserGameCollectionService userGameCollectionService;

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserGameCollectionDTO>> getUserGameCollectionById(@PathVariable String id) {
        UserGameCollectionDTO userGameCollectionDTO = userGameCollectionService.findById(id);
        return ResponseEntity.ok(RestResponse.of(userGameCollectionDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserGameCollectionDTO>> getAllUserGameCollections() {
        List<UserGameCollectionDTO> userGameCollectionDTOs = userGameCollectionService.findAll();
        return ResponseEntity.ok(userGameCollectionDTOs);
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserGameCollectionDTO>> createUserGameCollection(
            @RequestBody UserGameCollectionDTO userGameCollectionDTO) {
        UserGameCollectionDTO savedUserGameCollectionDTO = userGameCollectionService.save(userGameCollectionDTO);
        return ResponseEntity.ok(RestResponse.of(savedUserGameCollectionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<UserGameCollectionDTO>> deleteUserGameCollectionById(@PathVariable String id) {
        userGameCollectionService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

    @GetMapping("/evict-mongo")
    public ResponseEntity<RestResponse<UserGameCollectionDTO>> evictMongo() {
        userGameCollectionService.evictMongo();
        return ResponseEntity.ok(RestResponse.empty());
    }
}

