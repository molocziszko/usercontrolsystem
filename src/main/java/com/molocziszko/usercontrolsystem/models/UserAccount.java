package com.molocziszko.usercontrolsystem.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserAccount {
    private int id;
    @NotBlank(message = "Username is mandatory")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contains only english characters")
    private String username;
    // @Pattern(regexp = ".*([a-zA-Z0-9]{4}$)")
    private String password;
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;
    private String lastName;
    private Role role;
    private Status status;
    private Date createdAt;


    public UserAccount(int id, String username, String password, String firstName, String lastName, Role role, Status status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.status = status;
    }

    public UserAccount() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
