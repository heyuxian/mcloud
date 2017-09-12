package me.javaroad.oauth.security.repository;

import me.javaroad.oauth.security.entity.OAuthClient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface OAuthClientRepository extends JpaRepository<OAuthClient, Long> {

    @EntityGraph(value = OAuthClient.FETCH_ALL_GRAPH)
    OAuthClient findByClientId(String clientId);
}
