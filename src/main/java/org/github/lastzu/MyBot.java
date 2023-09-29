package org.github.lastzu;

import org.github.lastzu.answer.CommandMessageAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class MyBot extends TelegramLongPollingBot {
    final Logger logger = LoggerFactory.getLogger(MyBot.class);
    private final String name;

    public MyBot(String name, String token) {
        super(token);
        this.name = name;
    }

    @Override
    public void onUpdateReceived(Update update) {
        logger.debug("Receive update");

        if (!update.hasMessage()) return;
        logger.info("Receive update");

        Message message = update.getMessage();

        CommandMessageAnswer commandAnswer = new CommandMessageAnswer();

        logger.info("Start creating answer");
        SendMessage sendMessage = commandAnswer.create(message);
        logger.info("Finish creating answer");

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.warn("Could not send message: {}", e.getStackTrace());
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}
