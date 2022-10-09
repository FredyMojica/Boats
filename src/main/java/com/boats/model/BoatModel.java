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
    private String model;
    private Integer categoryId;

    public BoatModel() {
    }/*Por si necesito instanciar uno vacio y pasarle los parámetros, recordemos que el constructor es un método que permite instanciar una clase*/

    public BoatModel(String brand, String model, Integer categoryId) {
        this.brand = brand;
        this.model = model;
        this.categoryId = categoryId;
    }/*Como el Id es autogenerado en la base de datos*/

    public BoatModel(Integer id, String brand, String model, Integer categoryId) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.categoryId = categoryId;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCategoryId() {
        return categoryId;
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
                ", model='" + model + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
