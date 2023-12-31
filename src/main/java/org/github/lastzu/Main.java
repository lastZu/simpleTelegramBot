package org.github.lastzu;

import org.github.lastzu.answer.CommandMessageAnswer;
import org.github.lastzu.config.TelegramBotConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Start configuration");

        TelegramBotConfig config = TelegramBotConfig.getInstance();

        TelegramBotsApi botsApi;
        try {

            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new MyBot(
                    config.getName(),
                    config.getToken(),
                    new CommandMessageAnswer()
            ));

        } catch (TelegramApiException e) {
            logger.error("Could not register Bot: {}", e.getStackTrace());
        }

        logger.info("Finish configuration");
    }
}