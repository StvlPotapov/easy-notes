package com.example.easynotes.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    /**
     *
     * Дата рождения
     */
    @Column(nullable = false)
    private Date dateOfBirth;

    /**
     * from UserAuthAccount
     */
    @Column
    @OneToMany
    private List<UserAuthAccount> userAuthId;


    public List<UserAuthAccount> getUserAuthId() {
        return userAuthId;
    }

    public void setUserAuthId(List<UserAuthAccount> userAuthId) {
        this.userAuthId = userAuthId;
    }

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getName(), getLastName(), getPhoneNumber());
    }
}
