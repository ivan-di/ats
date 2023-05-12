package ivan.di.atsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AtsGatewayApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "gateway");
        SpringApplication.run(AtsGatewayApplication.class, args);
    }

}
