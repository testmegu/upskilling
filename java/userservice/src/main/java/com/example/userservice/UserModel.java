package com.example.userservice;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserModel {

    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String roles;
    private Boolean active;
  
  


    public UserModel() {
    }

   

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

   

    @Override
    public String toString() {
        return "User [active=" + active + ", authority=" + roles + ", email=" + email + ", firstName=" + firstName
                +  ", lastName=" + lastName + ", password=" + password + 
                ", username=" + userName + "]";
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
