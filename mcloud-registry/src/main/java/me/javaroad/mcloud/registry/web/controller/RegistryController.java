package me.javaroad.mcloud.registry.web.controller;

import com.netflix.eureka.EurekaServerContext;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import java.util.List;
import java.util.stream.Collectors;
import me.javaroad.mcloud.registry.model.App;
import me.javaroad.mcloud.registry.model.App.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
public class RegistryController {

    @GetMapping("applications")
    public List<App> applications() {
        return getRegistry().getSortedApplications().stream().map(app -> {
            return App.builder()
                .name(app.getName())
                .instances(app.getInstances().stream().map(instanceInfo -> {
                    return Instance.builder()
                        .healthCheckUrl(instanceInfo.getHealthCheckUrl())
                        .homePageUrl(instanceInfo.getHomePageUrl())
                        .hostName(instanceInfo.getHostName())
                        .instanceId(instanceInfo.getInstanceId())
                        .ipAddr(instanceInfo.getIPAddr())
                        .lastUpdatedTimestamp(instanceInfo.getLastUpdatedTimestamp())
                        .lastDirtyTimestamp(instanceInfo.getLastDirtyTimestamp())
                        .metadata(instanceInfo.getMetadata())
                        .status(instanceInfo.getStatus())
                        .statusPageUrl(instanceInfo.getStatusPageUrl())
                        .build();
                }).collect(Collectors.toList()))
                .build();
        }).collect(Collectors.toList());
    }

    private PeerAwareInstanceRegistry getRegistry() {
        return getServerContext().getRegistry();
    }

    private EurekaServerContext getServerContext() {
        return EurekaServerContextHolder.getInstance().getServerContext();
    }
}
