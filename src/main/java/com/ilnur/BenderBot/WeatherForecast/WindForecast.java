
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class WindForecast {

    @JsonProperty("speed")
    private Double speed;
    @JsonProperty("deg")
    private int deg;
    @JsonProperty("gust")
    private Double gust;

    public WindForecast(Double speed, int deg, Double gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }

    public WindForecast() {
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }
}
