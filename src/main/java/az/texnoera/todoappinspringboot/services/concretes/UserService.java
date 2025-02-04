package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.mapper.UserMapper;
import az.texnoera.todoappinspringboot.model.enums.StatusCode;
import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.repository.UserRepository;
import az.texnoera.todoappinspringboot.services.abstracts.IUserService;
import az.texnoera.todoappinspringboot.util.Result;
import az.texnoera.todoappinspringboot.validations.UserValidation;
import az.texnoera.todoappinspringboot.exceptions.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public Result<ResponseUser> getUsers(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> users = userRepository.findAll(pageable);
        List<ResponseUser> responseUsers = users
                .stream().map(UserMapper::mapToResponseUser).toList();
        return new Result<>(responseUsers, page, size, users.getTotalPages());
    }

    public ResponseUser getUserById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new BaseException( StatusCode.USER_NOT_FOUND,HttpStatus.NOT_FOUND));
        return UserMapper.mapToResponseUser(user);
    }

    public ResponseUser addUser(RequestUser requestUser) {
        User user = UserMapper.mapToEntity(requestUser);
        User userResponse = userRepository.save(user);
        return UserMapper.mapToResponseUser(userResponse);
    }


    public void deleteUser(int id) {
        ResponseUser userResponse = getUserById(id);
        userRepository.deleteById(userResponse.getId());
    }

    public ResponseUser updateUser(int id, UpdateUserRequest user) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(()-> new BaseException( StatusCode.USER_NOT_FOUND,HttpStatus.NOT_FOUND));
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        User userResponse = userRepository.save(updateUser);

        return UserMapper.mapToResponseUser(userResponse);
    }

    public Result<ResponseUser> findByIdGreaterThan(Integer requestId,Integer page, Integer size) {
          if(requestId!=null) {
              Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
             Page<User> usersPage =  userRepository.findByIdGreaterThan(requestId,pageable);
             List<ResponseUser> users = usersPage.stream().map(user->{
                 return UserMapper.mapToResponseUser(user);
             }).toList();
             return new Result<>(users,page,size, usersPage.getTotalPages());
          }
        return new Result<>(new ArrayList<>(),page,size,0);
    }
}
