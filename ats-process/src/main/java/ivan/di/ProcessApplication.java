package ivan.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableAsync
public class ProcessApplication {

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "process");
    SpringApplication.run(ProcessApplication.class, args);
  }

}