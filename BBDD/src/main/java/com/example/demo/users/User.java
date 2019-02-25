package com.example.demo.users;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /*User fields*/
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> rol;

    public User(){

    }

    public User(String username, String password, String... rol) {
        this.username = username;
        this.password = password;
        this.rol=new ArrayList<>(Arrays.asList(rol));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRol(){
        return rol;
    }

    public void setRol(List<String> rol){
        this.rol=rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
