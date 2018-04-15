package com.njust.smartparksystem.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Car {
    private String id;
    private String type;
    private int model;
    private String color;
    private String brand;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "model")
    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return model == car.model &&
                Objects.equals(id, car.id) &&
                Objects.equals(type, car.type) &&
                Objects.equals(color, car.color) &&
                Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, model, color, brand);
    }
}
