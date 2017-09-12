package me.javaroad.blog.core.repository;

import me.javaroad.blog.core.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
