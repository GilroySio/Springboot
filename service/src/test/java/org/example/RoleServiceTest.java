package org.example;

import org.example.impl.RoleServiceImpl;
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
public class RoleServiceTest {

    private Role role1;
    private Role role2;

    @Mock
    private RoleRepo roleRepo;

    @InjectMocks
    private RoleServiceImpl roleServiceImpl;

    @BeforeEach
    public void setUp() {
        role1 = new Role("title1", "description");
        role1.setId(1);
        role2 = new Role("title2", "description");
        role2.setId(2);
    }

    @Test
    public void getEmployeeTest() {
        when(roleRepo.findAll()).thenReturn(List.of(role1, role2));
        assertEquals(2, roleServiceImpl.getRoles().size());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(roleRepo.findById(1)).thenReturn(Optional.ofNullable(role1));
        assertTrue(roleRepo.findById(1).isPresent());
        assertEquals(role1, roleRepo.findById(1).get());

        when(roleRepo.findById(2)).thenReturn(Optional.ofNullable(role2));
        assertTrue(roleRepo.findById(2).isPresent());
        assertEquals(role2, roleRepo.findById(2).get());
    }
}
