package com.NoteOrganizer;

import javax.persistence.*;

/**
 * Created by Justins PC on 5/23/2016.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String password;

    public User() {}

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }
}
