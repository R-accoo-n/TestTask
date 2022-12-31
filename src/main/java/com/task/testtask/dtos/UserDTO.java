package com.task.testtask.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class for user requests by INTERVIEWER or COORDINATOR role.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @JsonIgnore
    private UUID id;
    private String name;
    private String surname;
    private int age;
}