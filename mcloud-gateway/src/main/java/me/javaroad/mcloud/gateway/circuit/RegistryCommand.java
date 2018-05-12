package me.javaroad.mcloud.gateway.circuit;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author heyx
 */
@Component
public class RegistryCommand {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public Object myCommandName(Map<String, Object> parameters) {
        //do stuff that might fail
        return null;
    }
}
