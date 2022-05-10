package com.example.demo;

import javax.persistence.*;
 
// @Entity
// @Table(name = "users")
public class Food {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String name;
     
    @Column(nullable = false, length = 64)
    private String description;
     
    @Column(nullable = false, unique = true, length = 45)
    private int categoryId;
     
    @Column(nullable = false, unique = true, length = 45)
    private int price;

    @Column(nullable = false, unique = true, length = 45)
    private String image;

    public Object food;


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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


}