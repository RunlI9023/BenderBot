/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilnur.BenderBot.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.databind.*;
import com.ilnur.BenderBot.Rest.BenderBotRestClient;
import com.ilnur.BenderBot.Weather.WeatherNow;

/**
 * @author Runli9023
 */

@Controller
@RequestMapping("/weather")
public class BenderBotWeatherController {
    
    private final BenderBotRestClient benderBotRestClient;
    private WeatherNow weatherNow;
    public ObjectMapper objectMapper = new ObjectMapper();
    
    public BenderBotWeatherController(BenderBotRestClient benderBotRestClient, 
            WeatherNow weatherNow) {
        this.benderBotRestClient = benderBotRestClient;
        this.weatherNow = weatherNow;
    }
    
    public Float getWeatherTemp() {
        return weatherNow.getMain().getTemp();
    }
    
    @GetMapping
    public String getWeather(Model model) throws JsonProcessingException {
        weatherNow = objectMapper.readValue(benderBotRestClient.getWeather(
                benderBotRestClient.getCityName()), WeatherNow.class);
        model.addAttribute("name", weatherNow.getName());
        model.addAttribute("temp", weatherNow.getMain().getTemp());
        model.addAttribute("feels_like", weatherNow.getMain().getFeelsLike());
        model.addAttribute("temp_min", weatherNow.getMain().getTempMin());
        model.addAttribute("temp_max", weatherNow.getMain().getTempMax());
        model.addAttribute("pressure", weatherNow.getMain().getPressure());
        model.addAttribute("humidity", weatherNow.getMain().getHumidity());
        model.addAttribute("wind", weatherNow.getWind().getSpeed());
        model.addAttribute("clouds", weatherNow.getClouds().getAll());
        model.addAttribute("allweather", weatherNow.getWeather());//описание
        model.addAttribute("visibility", weatherNow.getVisibility());//видимость
        //model.addAttribute("weather", benderBotRestClient.getWeather());
        return "getweather";
    }
    
        //стартовая страница, ввод  
//    @PostMapping("/weather")
//    public String getCityWeather(@ModelAttribute("getCityWeather") BenderBotRestClient benderBotRestClient) {
//        benderBotRestClient.setCityName("getCityWeather");
//        System.out.println(benderBotRestClient.getCityName());
//               return "redirect:/weather";
//    }
}
