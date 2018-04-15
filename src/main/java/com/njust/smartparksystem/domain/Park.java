package com.njust.smartparksystem.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Park {
    private int id;
    private String name;
    private String address;
    private double x;
    private double y;
    private BigDecimal price;
    private String phone;
    private int carnum;
    private int status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "x")
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Basic
    @Column(name = "y")
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "carnum")
    public int getCarnum() {
        return carnum;
    }

    public void setCarnum(int carnum) {
        this.carnum = carnum;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Park park = (Park) o;
        return id == park.id &&
                Double.compare(park.x, x) == 0 &&
                Double.compare(park.y, y) == 0 &&
                carnum == park.carnum &&
                status == park.status &&
                Objects.equals(name, park.name) &&
                Objects.equals(address, park.address) &&
                Objects.equals(price, park.price) &&
                Objects.equals(phone, park.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, address, x, y, price, phone, carnum, status);
    }
}
