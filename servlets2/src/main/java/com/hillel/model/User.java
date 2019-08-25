package com.hillel.model;

import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String status;
    private String role;

    public User(String firstName, String lastName, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }
}