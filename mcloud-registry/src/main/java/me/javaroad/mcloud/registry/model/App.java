package me.javaroad.mcloud.registry.model;

import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author heyx
 */
@Getter
@Setter
public class App {
    private String name;
    private List<Instance> instances;

    @Builder
    public App(String name, List<Instance> instances) {
        this.name = name;
        this.instances = instances;
    }

    @Getter
    @Setter
    public static class Instance {
        private String instanceId;
        private String ipAddr;
        private String homePageUrl;
        private String statusPageUrl;
        private String healthCheckUrl;
        private String hostName;
        private InstanceStatus status;
        private Map<String, String> metadata;
        private Long lastUpdatedTimestamp;
        private Long lastDirtyTimestamp;

        @Builder
        public Instance(String instanceId, String ipAddr, String homePageUrl, String statusPageUrl,
            String healthCheckUrl, String hostName, InstanceStatus status,
            Map<String, String> metadata, Long lastUpdatedTimestamp, Long lastDirtyTimestamp) {
            this.instanceId = instanceId;
            this.ipAddr = ipAddr;
            this.homePageUrl = homePageUrl;
            this.statusPageUrl = statusPageUrl;
            this.healthCheckUrl = healthCheckUrl;
            this.hostName = hostName;
            this.status = status;
            this.metadata = metadata;
            this.lastUpdatedTimestamp = lastUpdatedTimestamp;
            this.lastDirtyTimestamp = lastDirtyTimestamp;
        }
    }
}
