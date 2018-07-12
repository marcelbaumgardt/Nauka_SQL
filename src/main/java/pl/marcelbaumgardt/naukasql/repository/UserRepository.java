package pl.marcelbaumgardt.naukasql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marcelbaumgardt.naukasql.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByUsername(String username);
}
