package az.texnoera.todoappinspringboot.mapper;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.requests.RequestUser;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;

public interface UserMapper {

    static User mapToEntity(RequestUser requestUser) {
       return  User.builder().email(requestUser.getEmail())
                .username(requestUser.getUsername())
                .password(requestUser.getPassword()).build();
    }
    static ResponseUser mapToResponseUser(User userResponse) {
        return ResponseUser.builder()
                .id(userResponse.getId())
                .username(userResponse.getUsername())
                .email(userResponse.getEmail())
                .build();
    }
}
