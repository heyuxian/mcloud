package me.javaroad.blog.repository;

import me.javaroad.blog.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author heyx
 */
@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
