
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    @JsonProperty("speed")
    public Double speed;
    @JsonProperty("deg")
    public Integer deg;
    @JsonProperty("gust")
    public Double gust;

}
