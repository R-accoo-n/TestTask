package com.task.testtask.repositories;

import com.task.testtask.models.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Data access layer for User entity.
 */

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findById(UUID id);
}