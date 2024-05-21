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
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * @author Runli9023
 */
@Component
public class BenderBot extends TelegramLongPollingBot {

    public BenderBot() {
    }

    public BenderBot(ReplyKeyboardMarkup keyboard) {
        this.keyboard = keyboard;
    }
    
    @Autowired
    private BenderBotRestClient benderBotRestClient;
    @Autowired
    private WeatherNow weatherNow;
    @Autowired
    private ExampleForecast exampleForecast;
    @Autowired
    public ObjectMapper objectMapper;
    
    public ReplyKeyboardMarkup keyboard;
    
    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        var getCityNameMessage = update.getMessage();
        var user = message.getFrom();
        var id = user.getId();
        if (message.getText().equals("/start")) {
            sendText(id,
                    "Слава роботам! Теперь я ваш личный ассистент, могу помочь вам "
                            + "быть в курсе текущих событий");
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
        
        keyboard = new ReplyKeyboardMarkup();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();
        List<KeyboardRow> kbr = new ArrayList<>();
        row1.add("Текущая погода");//1 row
        row1.add("Прогноз погоды на 5 дней");//1 row
        row1.add("Прогноз погоды по геопозиции");//1 row
        row2.add("Текущий курс $");//2 row
        row2.add("Текущий курс Euro");//2 row
        row2.add("Текущий курс юань");//2 row
        row3.add("Список дел");//3 row
        row3.add("Запись к мастеру");//3 row
        row3.add("Инфо");//3 row
        kbr.add(row1);
        kbr.add(row2);
        kbr.add(row3);
        keyboard.setKeyboard(kbr);
        message.setReplyMarkup(keyboard);
        try {
            execute(message);
        }
        
       catch (TelegramApiException e){
           throw new RuntimeException(e);
       }
    }
}

