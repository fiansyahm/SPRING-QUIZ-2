package com.example.demo;

import javax.persistence.*;
 
// @Entity
// @Table(name = "users")
public class User {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String name;
     
    @Column(nullable = false, length = 64)
    private String email;
     
    @Column(nullable = false, length = 20)
    private String password;
     
    @Column(nullable = true, length = 20)
    private int isAdmin;

    public Object user;

    public User(int int1, String string, String string2, String string3) {
    }

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(int i) {
        this.isAdmin = i;
    }
     
    // getters and setters are not shown   
}