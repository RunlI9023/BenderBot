
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain {

    @JsonProperty("3h")
    public Double _3h;

}
