package com.fleetmanagement.fleetmanagementapi.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private Integer id;

    @Schema(
            description = "ID from taxi",
            name = "taxi_id",
            type = "Integer",
            example = "6418")
    private Integer taxi_id;

    @Schema(
            description = "Trajectory's date",
            name = "date",
            type = "Timestamp",
            example = "2008-02-02 14:22:40+00")
    private Timestamp date;

    @Schema(
            description = "Trajectory's latitude",
            name = "latitude",
            type = "double",
            example = "116.30508")
    private double latitude;

    @Schema(
            description = "Trajectory's longitude",
            name = "longitude",
            type = "double",
            example = "39.96525")
    private double longitude;

    public Trajectory() {
    }

    public Trajectory(Integer id, Integer taxi_id, Timestamp date, double latitude, double longitude) {
        this.id = id;
        this.taxi_id = taxi_id;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(Integer taxi_id) {
        this.taxi_id = taxi_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

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
                ", taxi_id=" + taxi_id +
                ", date=" + date +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
