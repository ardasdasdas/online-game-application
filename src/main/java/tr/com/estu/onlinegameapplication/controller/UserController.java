package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.UserDTO;
import tr.com.estu.onlinegameapplication.dto.base.RestResponse;
import tr.com.estu.onlinegameapplication.service.UserService;

import java.util.List;

/**
 * UserController is a REST controller that handles HTTP requests related to User entities.
 * It uses UserService to perform operations on User entities.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    // UserService instance for performing operations on User entities
    private final UserService userService;

    /**
     * Handles GET requests to "/users".
     *
     * @return a list of all User entities.
     */
    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllUsers() {
        return ResponseEntity.ok(RestResponse.of(userService.findAll()));
    }

    /**
     * Handles GET requests to "/users/{id}".
     *
     * @param id the ID of the User entity to retrieve.
     * @return the User entity with the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(RestResponse.of(userService.findByIdWithControl(id)));
    }

    /**
     * Handles POST requests to "/users".
     *
     * @param user the User entity to save.
     * @return the saved User entity.
     */
    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok(RestResponse.of(userService.save(user)));
    }

    /**
     * Handles DELETE requests to "/users/{id}".
     *
     * @param id the ID of the User entity to delete.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<UserDTO>> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}

