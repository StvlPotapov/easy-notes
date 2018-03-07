package com.example.easynotes.model;


import javax.persistence.*;
import java.io.Serializable;

/*
 *(не доработано) Пользователь сервиса.
 * */
@Entity
@Table(name = "users")
public class User implements Serializable {
    /**
     * Идентификатор
     */
    private Long userId;
    /**
     * Имя пользователя
     */
    private String name;
    /**
     * Фамилия пользователя
     */
    private String lastName;
    /**
     * номер телефона пользователя
     */
    private String phoneNumber;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID", nullable = false, updatable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    @Column(nullable = false, updatable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
