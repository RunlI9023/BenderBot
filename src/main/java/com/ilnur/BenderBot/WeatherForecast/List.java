
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class List {

    @JsonProperty("dt")
    public Integer dt;
    @JsonProperty("main")
    public Main main;
    @JsonProperty("weather")
    public java.util.List<Weather> weather;
    @JsonProperty("clouds")
    public Clouds clouds;
    @JsonProperty("wind")
    public Wind wind;
    @JsonProperty("visibility")
    public Integer visibility;
    @JsonProperty("pop")
    public Integer pop;
    @JsonProperty("rain")
    public Rain rain;
    @JsonProperty("sys")
    public Sys sys;
    @JsonProperty("dt_txt")
    public String dtTxt;

}
