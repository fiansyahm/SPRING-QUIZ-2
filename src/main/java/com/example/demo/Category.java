package com.example.demo;

import javax.persistence.*;
 
// @Entity
// @Table(name = "users")
public class Category {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String name;
     
    @Column(nullable = false, length = 64)
    private String image;
     
   

    public Object category;


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

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}