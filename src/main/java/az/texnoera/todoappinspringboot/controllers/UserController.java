package az.texnoera.todoappinspringboot.controllers;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.services.concretes.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;
    @GetMapping
    public List<ResponseUser> getUsers() {
        return userService.getUsers();
    }
    @GetMapping("{id}")
    public ResponseUser getUserById (@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public ResponseUser addUser(@RequestBody RequestUser user) {
       return  userService.addUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public ResponseUser updateUser(@PathVariable int id, @RequestBody UpdateUserRequest user) {
        return userService.updateUser(id,user);
    }

}
