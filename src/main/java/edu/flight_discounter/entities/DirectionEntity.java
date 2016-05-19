package edu.flight_discounter.entities;

import java.util.Date;

public class DirectionEntity extends AbstractEntity {
    private String departure;
    private Date depDate;
    private String destination;
    private Date destDate;
    private Double basicPrice;
    private Double dateMultiplier;
    private Double fillMultiplier;
    private Integer capacity;
    private Integer leftPlaces;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Date getDepDate() {
        return depDate;
    }

    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDestDate() {
        return destDate;
    }

    public void setDestDate(Date destDate) {
        this.destDate = destDate;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public void setBasicPrice(Double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Double getDateMultiplier() {
        return dateMultiplier;
    }

    public void setDateMultiplier(Double dateMultiplier) {
        this.dateMultiplier = dateMultiplier;
    }

    public Double getFillMultiplier() {
        return fillMultiplier;
    }

    public void setFillMultiplier(Double fillMultiplier) {
        this.fillMultiplier = fillMultiplier;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getLeftPlaces() {
        return leftPlaces;
    }

    public void setLeftPlaces(Integer leftPlaces) {
        this.leftPlaces = leftPlaces;
    }

    @Override
    public String toString() {
        return "DirectionEntity{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", depDate=" + depDate +
                ", destination='" + destination + '\'' +
                ", destDate=" + destDate +
                ", basicPrice=" + basicPrice +
                ", dateMultiplier=" + dateMultiplier +
                ", fillMultiplier=" + fillMultiplier +
                ", capacity=" + capacity +
                ", leftPlaces=" + leftPlaces +
                '}';
    }
}
