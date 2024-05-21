
package com.ilnur.BenderBot.WeatherForecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExampleForecast {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private int message;
    @JsonProperty("cnt")
    private int cnt;
    @JsonProperty("list")
    private List<ListForecast> list;
    @JsonProperty("city")
    private CityForecast city;

    public ExampleForecast(String cod, Integer message, Integer cnt, List<ListForecast> list, CityForecast city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public ExampleForecast() {
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<ListForecast> getList() {
        return list;
    }

    public void setList(List<ListForecast> list) {
        this.list = list;
    }

    public CityForecast getCity() {
        return city;
    }

    public void setCity(CityForecast city) {
        this.city = city;
    }
    
    public List<String> getListForecastDt() {
        List<String> listForecastDt = new ArrayList<>();
        for (int i = 0; i < getList().size(); i++) {
            listForecastDt.add(getList().get(i).getDtTxt());
            }
        return listForecastDt;
    }
    
    public List<Double> getListForecastMainTemp() {
        List<Double> listForecastMainTemp = new ArrayList<>();
        for (int i = 0; i < getList().size(); i++) {
            listForecastMainTemp.add(getList().get(i).getMain().getTemp());
            }
        return listForecastMainTemp;
    }
    
//    public List<String> getListWeatherDescription() {
//        List<String> listWeatherDescription = new ArrayList<>();
//        for (int i = 0; i < getList().size(); i++) {
//            listWeatherDescription.add(getList().get(i).getForecastWeatherDescription());
//        }
//        return listWeatherDescription;
//    }
       

}
