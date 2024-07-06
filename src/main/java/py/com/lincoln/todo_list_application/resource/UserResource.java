package py.com.lincoln.todo_list_application.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import py.com.lincoln.todo_list_application.domain.User;
import py.com.lincoln.todo_list_application.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
        public final UserService userService;

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user){
            return ResponseEntity.created(URI.create("/users/userID")).body(userService.createUser(user));
        }

        @GetMapping
        public ResponseEntity<Page<User>> getUser(@RequestParam(value = "page", defaultValue = "0") int page,
                                                         @RequestParam(value = "size", defaultValue = "10") int size){
            return ResponseEntity.ok().body(userService.getAllUsers(page, size));
        }

        @GetMapping("/{id}")
        public ResponseEntity<User> getUser(@PathVariable(value = "id") String id){
            return ResponseEntity.ok().body(userService.getUser(id));
        }

        @PatchMapping("/{id}/email")
        public ResponseEntity<String> updateEmail(@PathVariable("id") String id, @RequestBody String newEmail) {
            return ResponseEntity.ok().body(userService.updateEmail(id, newEmail));
        }
    }
