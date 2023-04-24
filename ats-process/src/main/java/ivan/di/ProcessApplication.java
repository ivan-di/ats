package ivan.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessApplication {

  public static void main(String[] args) {
    System.setProperty("spring.config.name", "process");
    SpringApplication.run(ProcessApplication.class, args);
  }

}