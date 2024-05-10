package tr.com.estu.onlinegameapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tr.com.estu.onlinegameapplication.dto.UserDTO;
import tr.com.estu.onlinegameapplication.model.User;
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
     * @return a list of all User entities.
     */
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    /**
     * Handles GET requests to "/users/{id}".
     * @param id the ID of the User entity to retrieve.
     * @return the User entity with the given ID.
     */
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findByIdWithControl(id);
    }

    /**
     * Handles POST requests to "/users".
     * @param user the User entity to save.
     * @return the saved User entity.
     */
    @PostMapping
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    /**
     * Handles DELETE requests to "/users/{id}".
     * @param id the ID of the User entity to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}

