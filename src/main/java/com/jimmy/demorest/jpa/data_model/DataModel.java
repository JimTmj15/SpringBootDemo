package com.jimmy.demorest.jpa.data_model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "weather")
public class DataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "City Name is mandatory")
    private String cityName;

    @PositiveOrZero(message = "Temperature value must be positive or zero")
    private int weatherTemp;

    public DataModel() {}

    public DataModel(String _cityName, int temp) {
        this.cityName = _cityName;
        this.weatherTemp = temp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getWeatherTemp() {
        return weatherTemp;
    }

    public void setWeatherTemp(int weatherTemp) {
        this.weatherTemp = weatherTemp;
    }
}
