
package com.ilnur.BenderBot.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherNow {

    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("snow")
    private Snow snow;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("base")
    private String base;
    @JsonProperty("name")
    private String name;
    @JsonProperty("dt")
    private int dt;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private int timezone;
    @JsonProperty("id")
    private int id;
    @JsonProperty("cod")
    private int cod;
    @JsonProperty("weather")
    private List<Weather> weather;

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Snow getSnow() {
        return snow;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }


    public WeatherNow(Coord coord, int visibility, Wind wind, Rain rain, Clouds clouds, Snow snow, Main main, String base, String name, int dt, Sys sys, int timezone, int id, int cod, List<Weather> weather) {
        this.coord = coord;
        this.visibility = visibility;
        this.wind = wind;
        this.rain = rain;
        this.clouds = clouds;
        this.snow = snow;
        this.main = main;
        this.base = base;
        this.name = name;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.cod = cod;
        this.weather = weather;
    }

    public WeatherNow() {}

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        String description = null;
        for (int i = 0; i < getWeather().size(); i++) {
            description = getWeather().get(i).getDescription();
            }
        return description;
        }
    
    }



