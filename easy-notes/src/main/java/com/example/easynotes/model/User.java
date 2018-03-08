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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID", nullable = false, updatable = false)
    private Long userId;
    /**
     * Имя пользователя
     */
    @Column(nullable = false, updatable = false)
    private String name;
    /**
     * Фамилия пользователя
     */
    @Column
    private String lastName;
    /**
     * номер телефона пользователя
     */
    @Column(nullable = false)
    private String phoneNumber;



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
