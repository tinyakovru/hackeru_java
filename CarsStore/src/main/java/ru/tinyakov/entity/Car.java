package ru.tinyakov.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "maker")
    private String maker;

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "year")
    private int year;

    @JsonProperty(value = "vin")
    private String vin;

    @JsonProperty(value = "odometer")
    private int odometer;

    public Car() {
    }

    public Car(int id, String maker, String model, int year, String vin, int odometer) {
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.year = year;
        this.vin = vin;
        this.odometer = odometer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (year != car.year) return false;
        if (odometer != car.odometer) return false;
        if (!maker.equals(car.maker)) return false;
        if (!model.equals(car.model)) return false;
        return vin.equals(car.vin);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + maker.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        result = 31 * result + vin.hashCode();
        result = 31 * result + odometer;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", vin='" + vin + '\'' +
                ", odometer=" + odometer +
                '}';
    }
}
