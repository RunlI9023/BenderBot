
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoordForecast {

    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;

    public CoordForecast(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public CoordForecast() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
