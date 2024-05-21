/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilnur.BenderBot.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Runli9023
 */

@Component
public class BenderBotRestClient {
    
    private final RestTemplate restTemplate;
    
    @Value("${weather.apitoken}")
    private String weatherApiToken;
    
    @Value("${weather.city_name}")
    private String cityName;

    public BenderBotRestClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public String getWeather(String cityName) {
        setCityName(cityName);//меняем город
        return restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/weather?q=" + getCityName() + 
                "&appid=" + getWeatherApiToken() + 
                "&lang=ru&units=metric", String.class);
    }
    
    public String getWeatherForecast(String cityName) {
        setCityName(cityName);//меняем город
        return restTemplate.getForObject(
                "https://api.openweathermap.org/data/2.5/forecast?q=" + getCityName() + 
                "&appid=" + getWeatherApiToken() + 
                "&lang=ru&units=metric", String.class);
    }
    
    public String getWeatherApiToken() {
        return weatherApiToken;
    }

    public void setWeatherApiToken(String weatherApiToken) {
        this.weatherApiToken = weatherApiToken;
    }
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}