
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    @JsonProperty("temp")
    public Double temp;
    @JsonProperty("feels_like")
    public Double feelsLike;
    @JsonProperty("temp_min")
    public Double tempMin;
    @JsonProperty("temp_max")
    public Double tempMax;
    @JsonProperty("pressure")
    public Integer pressure;
    @JsonProperty("sea_level")
    public Integer seaLevel;
    @JsonProperty("grnd_level")
    public Integer grndLevel;
    @JsonProperty("humidity")
    public Integer humidity;
    @JsonProperty("temp_kf")
    public Integer tempKf;

}
