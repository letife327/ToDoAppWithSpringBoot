package az.texnoera.todoappinspringboot.services.abstracts;

import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.util.Result;

public interface IUserService {
    Result<ResponseUser> getUsers(Integer page, Integer pageSize);
    ResponseUser getUserById(int id);
    ResponseUser addUser(RequestUser requestUser);
    void deleteUser(int id);
    ResponseUser updateUser(int id, UpdateUserRequest user);
}
