package com.example.easynotes.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userauthaccount")
public class UserAuthAccount implements Serializable {
    /**
     * Идентификатор
     */
    private Long id;
    /**
     * Адрес вк
     */
    private String vkmail;
    /**
     * Идентификатор из таблиы пользователей  //????????????????
     */
    private User userId;


    public UserAuthAccount() {
    }

    public UserAuthAccount(Long id, String vkmail, User userId) {
        this.id = id;
        this.vkmail = vkmail;
        this.userId = userId;
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "vkmail", nullable = false)
    public String getVkmail() {
        return vkmail;
    }

    public void setVkmail(String vkmail) {
        this.vkmail = vkmail;
    }

    @Column(name = "user_id", nullable = false)
    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
