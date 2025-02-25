package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
@Profile("test")
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            Employee employee1 = new Employee("name", 20, "address", "09150890181", "employed");
            employee1.setPassword(encoder.encode("pass"));
            Employee employee2 = new Employee("name2", 21, "address2", "09150890182", "employed");
            employee2.setPassword(encoder.encode("pass"));
            employeeRepo.saveAll(List.of(employee1, employee2));
        };
    }
}
