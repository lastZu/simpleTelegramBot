package org.github.lastzu;

import org.github.lastzu.config.TelegramBotConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Start configuration");

        TelegramBotConfig config;
        try {
            config = TelegramBotConfig.getInstance();
        } catch (FileNotFoundException e) {
            logger.error("Could not get TelegramBotConfig: {}", e.getStackTrace());
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
            logger.error("Could not register Bot: {}", e.getStackTrace());
        }

        logger.info("Finish configuration");
    }
}