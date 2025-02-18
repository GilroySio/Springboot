package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void getEmployeeTest() {
        when(employeeRepo.findAll()).thenReturn(List.of(new Employee("name", 20, "address", "09150890181", "employed")));
        assertEquals(1, employeeService.getEmployees().size());
    }
}
