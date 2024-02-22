package com.fleetmanagement.fleetmanagementapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="taxis")
public class Taxi {
    @Id
    private Integer id;

    private String plate;

    public Taxi() {

    }

    public Taxi(Integer id, String plate) {
        this.id = id;
        this.plate = plate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                '}';
    }
}
