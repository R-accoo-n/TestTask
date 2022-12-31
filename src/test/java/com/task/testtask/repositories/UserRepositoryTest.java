package com.task.testtask.repositories;


import static org.assertj.core.api.Assertions.assertThat;

import com.task.testtask.models.User;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindNoUsersIfRepositoryIsEmpty() {
        Iterable<User> users = userRepository.findAll();
        assertThat(users).isEmpty();
    }

    @Test
    public void shouldFindUserById() {
        User user1 = new User("Stepan", "Hrushka", LocalDate.of(2002, 4,7));
        entityManager.persist(user1);

        User user2 = new User("Nazar", "Sluva", LocalDate.of(2001, 6,3));
        entityManager.persist(user2);

        User foundUser = userRepository.findById(user2.getId()).get();

        assertThat(foundUser).isEqualTo(user2);
    }

}
