package io.streaming.project.model;

import lombok.Data;

@Data
public class User {
    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private DateOfBirth dob;
    private Registered registered;
    private String phone;
    private String cell;
    private Id id;
    private Picture picture;
    private String nat;

    // Getters and setters
}

