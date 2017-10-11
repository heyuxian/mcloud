package me.javaroad.oauth.repository;

import me.javaroad.oauth.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "all")
    User findByUsername(String username);
}
