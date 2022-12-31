package com.task.testtask.services;

import com.task.testtask.dtos.UserDTO;
import com.task.testtask.exceptions.NotFoundException;
import com.task.testtask.models.User;
import com.task.testtask.repositories.UserRepository;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User service.
 */

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Get user by id.
     *
     * @param id id
     * @return user dto object
     */
    public UserDTO getById(UUID id) {
        if (userRepository.findById(id).isEmpty()){
            throw new NotFoundException(NotFoundException.USER_ID_NOT_FOUND);
        }
        User user = userRepository.findById(id).orElseGet(() -> User.builder()
            .id(id)
            .build()
        );
        return new UserDTO(user.getId(), user.getName(), user.getSurname(), Period.between(user.getBirthDate(),
            LocalDate.now()).getYears());
    }

//    /**
//     * Get user dto from user object.
//     *
//     * @param user user
//     * @return user dto from user object
//     */
//    public UserDTO mapToDto(User user) {
//        return modelMapper.map(user, UserDTO.class);
//    }
}
