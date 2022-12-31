package com.task.testtask.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import com.task.testtask.dtos.UserDTO;
import com.task.testtask.exceptions.NotFoundException;
import com.task.testtask.models.User;
import com.task.testtask.repositories.UserRepository;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void givenUserId_whenGetUserById_thenReturnUserDto() {

        User user = User.builder()
            .id(UUID.fromString("123e4567-e89b-42d3-a456-556642440000"))
            .birthDate(LocalDate.of(2003, 3,14))
            .name("Andriy")
            .surname("Prokopiv")
            .build();

        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));

        UserDTO userDTO = userService.getById(user.getId());

        assertThat(userDTO).isNotNull();
        assertThat(userDTO.getAge()).isEqualTo(19);
    }

    @Test
    void givenNotExistingUserId_whenGetUserById_thenThrowsException() {
        assertThrows(NotFoundException.class,
            () -> userService.getById(UUID.randomUUID()));
    }
}