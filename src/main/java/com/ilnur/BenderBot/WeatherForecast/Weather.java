
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("main")
    public String main;
    @JsonProperty("description")
    public String description;
    @JsonProperty("icon")
    public String icon;

}
