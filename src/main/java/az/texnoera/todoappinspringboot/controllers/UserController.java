package az.texnoera.todoappinspringboot.controllers;

import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.services.concretes.UserService;
import az.texnoera.todoappinspringboot.util.Result;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;
    @GetMapping
    public Result<ResponseUser> getUsers(@RequestParam(defaultValue = "0") Integer page,
                                 @RequestParam(defaultValue = "10") Integer size ) {
        return userService.getUsers(page,size);
    }
    @GetMapping("{id}")
    public ResponseUser getUserById (@PathVariable int id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public ResponseUser addUser(@RequestBody @Valid RequestUser user) {
       return  userService.addUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public ResponseUser updateUser(@PathVariable int id, @RequestBody @Valid UpdateUserRequest user) {
        return userService.updateUser(id,user);
    }
    @GetMapping("/findByIdGreaterThan")
    public Result<ResponseUser> findByIdGreaterThan(@RequestParam Integer requestId,
                                                    @RequestParam(defaultValue = "0") Integer page,
                                                    @RequestParam(defaultValue = "10") Integer size) {
        return userService.findByIdGreaterThan(requestId,page,size);
    }

}
