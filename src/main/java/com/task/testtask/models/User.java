package com.task.testtask.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

/**
 * User model.
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    public User(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    @Column(name = "birth_date")
    private LocalDate birthDate;

}