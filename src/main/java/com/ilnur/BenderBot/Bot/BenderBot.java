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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Runli9023
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
        BenderKeyboard(id);
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
                sendText(id, "Поле cnt: " + exampleForecast.getList().stream().toString());
     
        } catch (JsonProcessingException ex) {
            //Logger.getLogger(BenderBot.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        } catch (HttpClientErrorException e) {
            //Logger.getLogger(BenderBot.class.getName()).log(Level.SEVERE, null, e);
                sendText(id,
                        "К сожалению, такой город не найден. "
                                + "Пожалуйста, проверьте корректность ввода и повторите попытку.");
            System.out.println(e);
            }
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
    
    public void BenderKeyboard(Long chatId) {
        SendMessage msg = new SendMessage();
        msg.setChatId(chatId);
        msg.setText("Сообщение");
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        List<KeyboardRow> kbr = new ArrayList<>();
        row1.add("Текущая погода");//1 row
        row1.add("Прогноз погоды на 5 дней");//1 row
        row2.add("Текущий курс $");//2 row
        row2.add("Резерв");//2 row
        row3.add("Резерв");//3 row
        row3.add("Резерв");//3 row
        kbr.add(row1);
        kbr.add(row2);
        kbr.add(row3);
        keyboard.setKeyboard(kbr);
        msg.setReplyMarkup(keyboard);
        try {
            execute(msg);
        }
        
        catch (TelegramApiException e){
           e.printStackTrace();
       }
    }
}
