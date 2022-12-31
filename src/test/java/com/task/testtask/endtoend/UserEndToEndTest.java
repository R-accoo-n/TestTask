package com.task.testtask.endtoend;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.task.testtask.dtos.UserDTO;
import com.task.testtask.models.User;
import com.task.testtask.repositories.UserRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserEndToEndTest {

    @LocalServerPort
    private int port;

    private String baseUrl = "http://localhost:";

    private static RestTemplate restTemplate;

    @Autowired
    private UserRepository userTestRepository;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(port + "");
    }

    @Test
    void testGetUserByUserIdSuccess() {
        User user = new User("Stepan", "Hrushka", LocalDate.of(2002, 4,7));
        userTestRepository.save(user);

        User userFromRepo = userTestRepository.findById(user.getId()).get();

        HttpEntity<User> entity = new HttpEntity<>(userFromRepo);

        ResponseEntity<UserDTO> response = restTemplate.exchange(
            baseUrl + "/users/" + userFromRepo.getId(), HttpMethod.GET, entity, UserDTO.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        userTestRepository.delete(user);
    }

}
