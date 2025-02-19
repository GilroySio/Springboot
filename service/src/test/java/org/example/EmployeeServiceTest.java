package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    private Employee employee1;
    private Employee employee2;

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("name", 20, "address", "09150890181", "employed");
        employee1.setId(1);
        employee2 = new Employee("name2", 20, "address2", "09150890182", "employed");
        employee2.setId(2);
    }

    @Test
    public void getEmployeeTest() {
        when(employeeRepo.findAll()).thenReturn(List.of(employee1, employee2));
        assertEquals(2, employeeServiceImpl.getEmployees().size());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(employeeRepo.findById(1)).thenReturn(Optional.ofNullable(employee1));
        assertTrue(employeeRepo.findById(1).isPresent());
        assertEquals(employee1, employeeRepo.findById(1).get());

        when(employeeRepo.findById(2)).thenReturn(Optional.ofNullable(employee2));
        assertTrue(employeeRepo.findById(2).isPresent());
        assertEquals(employee2, employeeRepo.findById(2).get());
    }
}
