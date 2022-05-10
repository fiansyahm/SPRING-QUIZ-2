package com.example.demo;

import javax.persistence.*;
 
// @Entity
// @Table(name = "users")
public class Crud {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
     
    @Column(nullable = false, unique = true, length = 45)
    private String updateCategory;

    @Column(nullable = false, length = 64)
    private String deleteCategory;
     
     
    @Column(nullable = false, unique = true, length = 45)
    private String updateFood;
     
    @Column(nullable = false, length = 64)
    private String deleteFood;
     
    

    public Object crud;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateCategory() {
        return this.updateCategory;
    }

    public void setUpdateCategory(String updateCategory) {
        this.updateCategory = updateCategory;
    }

    public String getDeleteCategory() {
        return this.deleteCategory;
    }

    public void setDeleteCategory(String deleteCategory) {
        this.deleteCategory = deleteCategory;
    }

    public String getUpdateFood() {
        return this.updateFood;
    }

    public void setUpdateFood(String updateFood) {
        this.updateFood = updateFood;
    }

    public String getDeleteFood() {
        return this.deleteFood;
    }

    public void setDeleteFood(String deleteFood) {
        this.deleteFood = deleteFood;
    }


}