package ivan.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProcessApplication {

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "process");
    SpringApplication.run(ProcessApplication.class, args);
  }

}