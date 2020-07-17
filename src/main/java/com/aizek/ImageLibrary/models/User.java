package com.aizek.ImageLibrary.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String username;

    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="comment_id")
    private Comment user;

    private String password;


    private String getUsername() {
        return this.username;
    }

    private void setUsername(final String username) {
        this.username = username;
    }

    private String getPassword() {
        return this.password;
    }

    private void setPassword(final String password) {
        this.password = password;
    }
}
