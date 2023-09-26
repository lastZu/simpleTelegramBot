package org.github.lastzu;

import org.github.lastzu.config.TelegramBotConfig;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        TelegramBotConfig config;
        try {
            config = TelegramBotConfig.getInstance();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        TelegramBotsApi botsApi;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyBot(
                    config.getName(),
                    config.getToken()
            ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}