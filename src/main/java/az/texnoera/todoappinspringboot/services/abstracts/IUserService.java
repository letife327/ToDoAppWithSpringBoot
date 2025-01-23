package az.texnoera.todoappinspringboot.services.abstracts;

import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;

import java.util.List;

public interface IUserService {
    List<ResponseUser> getUsers();
    ResponseUser getUserById(int id);
    ResponseUser addUser(RequestUser requestUser);
    void deleteUser(int id);
    ResponseUser updateUser(int id, UpdateUserRequest user);
}
