package com.boats.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="boat")

public class BoatModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String year;
    private Integer categoryId;

    private String name;

    private String description;
    public BoatModel() {
    }/*Por si necesito instanciar uno vacio y pasarle los parámetros, recordemos que el constructor es un método que permite instanciar una clase*/

    public BoatModel(String brand, String year, Integer categoryId, String name, String description) {
        this.brand = brand;
        this.year = year;
        this.categoryId = categoryId;
        this.name = name;
        this.description =description;
    }/*Como el Id es autogenerado en la base de datos*/

    public BoatModel(Integer id, String brand, String year, Integer categoryId, String name, String description) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.categoryId = categoryId;
        this.name = name;
        this.description =description;
    }/*Para cuando actualice un boat, esto es "sobrecarga"*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    /*El método ToString, hace que cuando le pida los parámetros de la clase si me imprima los parámetros*/

    @Override
    public String toString() {
        return "BoatModel{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", year='" + year + '\'' +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
