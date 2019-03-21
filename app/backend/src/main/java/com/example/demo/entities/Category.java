package com.example.demo.entities;



import javax.persistence.*;
import java.util.List;


@Entity
    public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String nameCategory;




    public Category(){}

    public Category(String nameCategory){
        super();
        this.nameCategory=nameCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }

}
