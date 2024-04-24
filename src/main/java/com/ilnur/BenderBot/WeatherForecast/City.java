
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("coord")
    public Coord coord;
    @JsonProperty("country")
    public String country;
    @JsonProperty("population")
    public Integer population;
    @JsonProperty("timezone")
    public Integer timezone;
    @JsonProperty("sunrise")
    public Integer sunrise;
    @JsonProperty("sunset")
    public Integer sunset;

}
