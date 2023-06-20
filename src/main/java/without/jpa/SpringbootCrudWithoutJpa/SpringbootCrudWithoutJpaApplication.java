package without.jpa.SpringbootCrudWithoutJpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("without.jpa.SpringbootCrudWithoutJpa")
public class SpringbootCrudWithoutJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudWithoutJpaApplication.class, args);
    }
}
