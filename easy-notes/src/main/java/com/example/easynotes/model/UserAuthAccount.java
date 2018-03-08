package com.example.easynotes.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "userauthaccount")
public class UserAuthAccount implements Serializable {
    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * Адрес вк
     */
    @Column(name = "vkmail", nullable = false)
    private String vkmail;
    /**
     * Идентификатор из таблиы пользователей  //????????????????
     */
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;


    public UserAuthAccount() {
    }

    public UserAuthAccount(Long id, String vkmail, User userId) {
        this.id = id;
        this.vkmail = vkmail;
        this.userId = userId;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getVkmail() {
        return vkmail;
    }

    public void setVkmail(String vkmail) {
        this.vkmail = vkmail;
    }


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAuthAccount)) return false;
        UserAuthAccount that = (UserAuthAccount) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getVkmail(), that.getVkmail()) &&
                Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getVkmail(), getUserId());
    }
}
