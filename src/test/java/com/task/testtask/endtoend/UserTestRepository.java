package com.task.testtask.endtoend;

import com.task.testtask.models.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTestRepository extends JpaRepository<User, UUID> {

  Optional<User> findById(UUID id);
}