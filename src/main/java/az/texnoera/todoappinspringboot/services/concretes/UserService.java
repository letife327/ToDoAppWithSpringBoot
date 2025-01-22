package az.texnoera.todoappinspringboot.services.concretes;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.mapper.UserMapper;
import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import az.texnoera.todoappinspringboot.repository.UserRepository;
import az.texnoera.todoappinspringboot.validations.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserValidation userValidation;
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public ResponseUser addUser(RequestUser requestUser) {
        if(!userValidation.isValidUsername(requestUser.getUsername())
                || !userValidation.isValidEmail(requestUser.getEmail())
                || !userValidation.isValidPassword(requestUser.getPassword())) {
           throw new RuntimeException("Invalid username , email  or password");
        }
        User user = UserMapper.mapToEntity(requestUser);
        User userResponse  =  userRepository.save(user);
        return UserMapper.mapToResponseUser(userResponse);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public void updateUser(int id, RequestUser user) {
        User updateUser = userRepository.findById(id).get();
        if(userValidation.isValidUsername(user.getUsername()) && userValidation.isValidPassword(user.getPassword())) {
            updateUser.setUsername(user.getUsername());
            updateUser.setPassword(user.getPassword());
            userRepository.save(updateUser);
        }else{
            throw new RuntimeException("Invalid username or password");
        }

    }
}
