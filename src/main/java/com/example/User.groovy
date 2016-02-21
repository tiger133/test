package com.example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by piotr on 17.02.16.
 */
@Entity
class User
{

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }
}
