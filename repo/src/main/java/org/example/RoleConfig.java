package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class RoleConfig {

    @Bean
    CommandLineRunner roleCommandLineRunner(RoleRepo roleRepo) {
        return args -> {
            Role role1 = new Role("title", "description");
            Role role2 = new Role("title2", "description2");
            roleRepo.saveAll(List.of(role1, role2));
        };
    }
}
