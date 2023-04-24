package ivan.di.atsdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AtsDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtsDiscoveryApplication.class, args);
    }

}
