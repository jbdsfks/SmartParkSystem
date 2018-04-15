package com.njust.smartparksystem.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "parkking_record", schema = "park", catalog = "")
public class ParkkingRecord {
    private int id;
    private Timestamp carIn;
    private Timestamp carOut;
    private BigDecimal pay;
    private String status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "car_in")
    public Timestamp getCarIn() {
        return carIn;
    }

    public void setCarIn(Timestamp carIn) {
        this.carIn = carIn;
    }

    @Basic
    @Column(name = "car_out")
    public Timestamp getCarOut() {
        return carOut;
    }

    public void setCarOut(Timestamp carOut) {
        this.carOut = carOut;
    }

    @Basic
    @Column(name = "pay")
    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkkingRecord that = (ParkkingRecord) o;
        return id == that.id &&
                Objects.equals(carIn, that.carIn) &&
                Objects.equals(carOut, that.carOut) &&
                Objects.equals(pay, that.pay) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, carIn, carOut, pay, status);
    }
}
