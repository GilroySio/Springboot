package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
        return args -> {
            Employee employee1 = new Employee("name", 20, "address", "09150890181", "employed");
            Employee employee2 = new Employee("name2", 21, "address2", "09150890182", "employed");
            employeeRepo.saveAll(List.of(employee1, employee2));
        };
    }
}
