package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.mapper.UserMapper;
import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.requests.UpdateUserRequest;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.repository.UserRepository;
import az.texnoera.todoappinspringboot.services.abstracts.IUserService;
import az.texnoera.todoappinspringboot.validations.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public List<ResponseUser> getUsers() {
        return userRepository.findAll().stream().map(user -> {
            return UserMapper.mapToResponseUser(user);
        }).toList();
    }

    public ResponseUser getUserById(int id) {
        User user = userRepository.findById(id).get();
        return UserMapper.mapToResponseUser(user);
    }

    public ResponseUser addUser(RequestUser requestUser) {
        if (!userValidation.isValidUsername(requestUser.getUsername())
                || !userValidation.isValidEmail(requestUser.getEmail())
                || !userValidation.isValidPassword(requestUser.getPassword())) {
            throw new RuntimeException("Invalid username , email  or password");
        }
        User user = UserMapper.mapToEntity(requestUser);
        User userResponse = userRepository.save(user);
        return UserMapper.mapToResponseUser(userResponse);
    }


    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public ResponseUser updateUser(int id, UpdateUserRequest user) {
        User updateUser = userRepository.findById(id).get();
        if (!userValidation.isValidUsername(user.getUsername())
                || !userValidation.isValidPassword(user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }
        updateUser.setUsername(user.getUsername());
        updateUser.setPassword(user.getPassword());
        User userResponse = userRepository.save(updateUser);

        return UserMapper.mapToResponseUser(userResponse);
    }
}
