package securitytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import securitytest.model.Role;
import securitytest.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select r from Role r " +
            "join UserRole ur on ur.role = r " +
            "join User u on ur.user = u " +
            "where u = ?1")
    List<Role> getRoles(User user);
}
