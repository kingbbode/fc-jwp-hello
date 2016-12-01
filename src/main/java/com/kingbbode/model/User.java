package com.kingbbode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long idx;

    @Column(unique = true, length = 20, nullable = false)
    private String userId;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 30)
    private String email;

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getIdx() {
        return idx;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isCorrectPassword(String password){
        return this.password.equals(password);
    }

    public void changeUser(User user){
        if(matchId(user.idx) && isCorrectPassword(user.password)){
            this.name = user.name;
            this.email = user.email;
        }
    }

    public boolean matchId(Long idx) {
        return this.idx.equals(idx);
    }
}
