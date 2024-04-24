/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ilnur.BenderBot.Bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilnur.BenderBot.Rest.BenderBotRestClient;
import com.ilnur.BenderBot.Weather.WeatherNow;
import com.ilnur.BenderBot.WeatherForecast.ExampleForecast;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author ЭмирНурияКарим
 */
@Component
public class BenderBot extends TelegramLongPollingBot {
    
    @Autowired
    private BenderBotRestClient benderBotRestClient;
    @Autowired
    private WeatherNow weatherNow;
    @Autowired
    private ExampleForecast exampleForecast;
    @Autowired
    public ObjectMapper objectMapper;
    
    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        var user = message.getFrom();
        var id = user.getId();
        if (message.getText().equals("/start")) {
            sendText(id,
                        "Слава роботам! Введите название города, чтобы узнать погоду");
        }
        else {
            try {
            weatherNow = objectMapper.readValue(
                    benderBotRestClient.getWeather(message.getText()), 
                    WeatherNow.class);
            
            exampleForecast = objectMapper.readValue(
                    benderBotRestClient.getWeatherForecast(message.getText()), 
                    ExampleForecast.class);
                //Первое сообщение
                sendText(id, "Погода на данный момент в г. " + benderBotRestClient.getCityName() + ": " +
                weatherNow.getDescription() + "." +
                "\nТемпература воздуха: " + weatherNow.getMain().getTemp().toString() + " \u2103;" + 
                "\nЧувствуется как: " + weatherNow.getMain().getFeelsLike().toString() + " \u2103;" +
                "\nВлажность: " + weatherNow.getMain().getHumidity() + "%;" +
                "\nОблачность: " + weatherNow.getClouds().getAll() + "%;" +
                "\nCкорость ветра: " + weatherNow.getWind().getSpeed() + " м/сек.;" + 
                "\nДавление: " + String.format(
                        "%.2f", (weatherNow.getMain().getPressure()/1.33)) + " мм.рт.ст.");
                //Второе сообщение
                sendText(id, "Поле cnt: " + exampleForecast.getForecastDescription());
//        
        } catch (JsonProcessingException ex) {
            //Logger.getLogger(BenderBot.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (HttpClientErrorException e) {
            //Logger.getLogger(BenderBot.class.getName()).log(Level.SEVERE, null, e);
//            if (message.getText() = "/start") {
//                sendText(id,
//                        "Слава роботам! Введите название города, чтобы узнать погоду");
//            }
//            else {
                sendText(id,
                        "К сожалению, такой город не найден. "
                                + "Пожалуйста, проверьте корректность ввода и повторите попытку.");
            //}
            System.out.println(e);
        }
         var next = InlineKeyboardButton.builder()
            .text("Next").callbackData("next")           
            .build();
        }
    }

    @Override
    //@Value("${bot.apitoken}")
    public String getBotToken() {
        return "7030876343:AAE0s4pLgyoTcqXikVAPf6jlIZeBDiPwvlM";
    }
    
    @Override
    public String getBotUsername() {
        return "Bender_helperBot";
    }
    
    public void sendText(Long who, String what) {
        SendMessage message = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(message);
        }
        
       catch (TelegramApiException e){
           throw new RuntimeException(e);
       }
    }
}
