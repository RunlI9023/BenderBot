
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListForecast {

    @JsonProperty("dt")
    private int dt;
    @JsonProperty("main")
    private MainForecast main;
    @JsonProperty("weather")
    private List<WeatherForecast> weather;
    @JsonProperty("clouds")
    private CloudsForecast clouds;
    @JsonProperty("wind")
    private WindForecast wind;
    @JsonProperty("visibility")
    private int visibility;
    @JsonProperty("pop")
    private int pop;
    @JsonProperty("rain")
    private RainForecast rain;
    @JsonProperty("sys")
    private SysForecast sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    
    private List<String> listForecastWeatherDescription;

    public ListForecast(int dt, MainForecast main, List<WeatherForecast> weather, CloudsForecast clouds, WindForecast wind, int visibility, int pop, RainForecast rain, SysForecast sys, String dtTxt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.rain = rain;
        this.sys = sys;
        this.dtTxt = dtTxt;
    }

    public ListForecast() {
    }
    
    public List<String> getForecastWeatherDescription() {
        return listForecastWeatherDescription;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainForecast getMain() {
        return main;
    }

    public void setMain(MainForecast main) {
        this.main = main;
    }

    public List<WeatherForecast> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<WeatherForecast> weather) {
        this.weather = weather;
    }
    
    public List<String> getListForecastWeatherDescription() {
        listForecastWeatherDescription = new ArrayList<>();
        for (int i = 0; i < getWeather().size(); i++) {
            listForecastWeatherDescription.add(getWeather().get(i).getDescription());
            }
        return listForecastWeatherDescription;
    }

    public CloudsForecast getClouds() {
        return clouds;
    }

    public void setClouds(CloudsForecast clouds) {
        this.clouds = clouds;
    }

    public WindForecast getWind() {
        return wind;
    }

    public void setWind(WindForecast wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(Integer pop) {
        this.pop = pop;
    }

    public RainForecast getRain() {
        return rain;
    }

    public void setRain(RainForecast rain) {
        this.rain = rain;
    }

    public SysForecast getSys() {
        return sys;
    }

    public void setSys(SysForecast sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
