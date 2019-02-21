package com.example.demo.Entidades;



import javax.persistence.*;
import java.util.List;

@Entity
    public class Categorias {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id=-1;
        private String nameCategory;


      @ManyToMany(mappedBy="categorias")
      private List<Eventos> event;

    public Categorias(){}

    public Categorias(String nameCategory){
        super();
        this.nameCategory=nameCategory;
    }

    public List<Eventos> getEvent() {
        return event;
    }

    public void setEvent(List<Eventos> event) {
        this.event = event;
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
