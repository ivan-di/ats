package ivan.di.atsapplicant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AtsApplicantApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "applicant");
        SpringApplication.run(AtsApplicantApplication.class, args);
    }

}
