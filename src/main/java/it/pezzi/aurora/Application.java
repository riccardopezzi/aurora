package it.pezzi.aurora;

import it.pezzi.aurora.entities.Contacts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableConfigurationProperties
@SpringBootApplication(scanBasePackages = { "it.pezzi.aurora"})
@EntityScan(basePackageClasses = Contacts.class)
@EnableJpaRepositories("it.pezzi.aurora.dao.repository")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}