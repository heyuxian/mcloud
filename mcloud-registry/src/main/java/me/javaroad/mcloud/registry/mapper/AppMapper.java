package me.javaroad.mcloud.registry.mapper;

import com.netflix.discovery.shared.Application;
import me.javaroad.mcloud.registry.model.App;
import org.mapstruct.Mapper;

/**
 * @author heyx
 */
@Mapper(componentModel = "spring")
public interface AppMapper {

    App application(Application application);
}
