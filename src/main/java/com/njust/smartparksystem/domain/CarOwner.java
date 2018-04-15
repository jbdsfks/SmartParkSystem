package com.njust.smartparksystem.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car_owner", schema = "park", catalog = "")
public class CarOwner {
    private int id;
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
        CarOwner carOwner = (CarOwner) o;
        return id == carOwner.id &&
                status == carOwner.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status);
    }
}
