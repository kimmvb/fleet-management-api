package com.fleetmanagement.fleetmanagementapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "trajectories")
public class Trajectory {
    @Schema(
            description = "Trajectory unique ID",
            name = "ID",
            type = "Integer",
            example = "1")
    @Id
    @Column(name = "id")
    private Integer id;

    @Schema(
            description = "ID from taxi",
            name = "taxi_id",
            type = "Integer",
            example = "6418")
    @ManyToOne
    @JoinColumn(name = "taxi_id")
    private Taxi taxi;

    @Schema(
            description = "Trajectory's date",
            name = "date",
            type = "Timestamp",
            example = "2008-02-02 14:22:40+00")
    @Column(name = "date")
    private Timestamp date;

    @Schema(
            description = "Trajectory's latitude",
            name = "latitude",
            type = "double",
            example = "116.30508")
    @Column(name = "latitude")
    private double latitude;

    @Schema(
            description = "Trajectory's longitude",
            name = "longitude",
            type = "double",
            example = "39.96525")
    @Column(name = "longitude")
    private double longitude;

    public Trajectory() {
    }

    @SuppressWarnings("unused")
    public Trajectory(Integer id, Taxi taxi, Timestamp date, double latitude, double longitude) {
        this.id = id;
        this.taxi = taxi;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @SuppressWarnings("unused")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @SuppressWarnings("unused")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @SuppressWarnings("unused")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Trajectory{" +
                "id=" + id +
                ", taxi=" + taxi +
                ", date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
