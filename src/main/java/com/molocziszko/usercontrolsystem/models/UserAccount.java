package com.molocziszko.usercontrolsystem.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "useraccounts", schema = "accounts")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Only letter characters allowed")
    @Size(min = 3, max = 16, message = "Minimum length 3, maximum 16")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contains only english characters")
    private String username;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{3,16}",
            message = "Must contains at least one english character and one digit")
    @Size(min = 3, max = 16, message = "Minimum length 3, maximum 16")
    private String password;

    @NotBlank(message = "Only letter characters allowed")
    @Size(min = 1, max = 16, message = "Minimum length 1, maximum 16")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contains only english characters")
    @Column(name = "firstname")
    private String firstName;

    @NotBlank(message = "Only letter characters allowed")
    @Size(min = 1, max = 16, message = "Minimum length 1, maximum 16")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contains only english characters")
    @Column(name = "lastname")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "createdat", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    public UserAccount(Long id, String username, String password, String firstName, String lastName, Role role, Status status) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
