package com.jimmy.demorest.jpa.data_model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "users")
public class UserDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long uid;

    @NotBlank(message = "Username is mandatory")
    String userName;

    @NotBlank(message = "Email is mandatory")
    String emailAddress;

    @PositiveOrZero(message = "Height cannot be negative value")
    Float height;

    @PositiveOrZero(message = "Weight cannot be negative value")
    Float weight;

    @NotBlank(message = "Password is mandatory")
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
