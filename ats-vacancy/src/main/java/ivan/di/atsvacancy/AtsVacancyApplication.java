package ivan.di.atsvacancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtsVacancyApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "vacancy");
        SpringApplication.run(AtsVacancyApplication.class, args);
    }

}
