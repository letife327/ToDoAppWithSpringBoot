package az.texnoera.todoappinspringboot.repository;

import az.texnoera.todoappinspringboot.entity.User;
import az.texnoera.todoappinspringboot.model.response.ResponseUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Integer> {
//     List<User> findByIdGreaterThan(Integer requestId);
     @Query(value = "select * from users u where u.id>?1",nativeQuery = true )
     Page<User> findByIdGreaterThan(@Param("id") Integer requestId, Pageable pageable);
}
