import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService; // Assume UserService is implemented

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.saveUser(user)) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Boolean> authenticate(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticate(username, password);
        return new ResponseEntity<>(isAuthenticated, HttpStatus.OK);
    }
}