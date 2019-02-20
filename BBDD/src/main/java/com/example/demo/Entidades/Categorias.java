package com.example.demo.Entidades;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
    public class Categorias {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id=-1;
        private String nameCategory;

    /**
     * @ManytoMany(mappedBy="categories")
     * private List<Eventos>event
     */
    public Categorias(){}

    public Categorias(String nameCategory){
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
