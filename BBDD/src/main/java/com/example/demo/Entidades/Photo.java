package com.example.demo.Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String namePhoto;

    public Photo(String namePhoto){
        this.namePhoto=namePhoto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamePhoto() {
        return namePhoto;
    }

    public void setNamePhoto(String namePhoto) {
        this.namePhoto = namePhoto;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", namePhoto='" + namePhoto + '\'' +
                '}';
    }
}
