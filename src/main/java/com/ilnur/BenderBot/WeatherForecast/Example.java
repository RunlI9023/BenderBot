
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Example {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public Integer message;
    @JsonProperty("cnt")
    public Integer cnt;
    @JsonProperty("list")
    public java.util.List<List> list;
    @JsonProperty("city")
    public City city;

}
