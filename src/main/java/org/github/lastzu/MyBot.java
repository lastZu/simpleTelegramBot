package org.github.lastzu;

import org.github.lastzu.answer.CommandMessageAnswer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * MyBot is telegram long polling bot. For create it needs
 * - Name registered in BotFather
 * - token received in BotFather
 */
final class MyBot extends TelegramLongPollingBot {
    private final Logger logger = LoggerFactory.getLogger(MyBot.class);
    private final String name;

    public MyBot(final String name, final String token) {
        super(token);
        this.name = name;
    }

    @Override
    public void onUpdateReceived(final Update update) {
        logger.debug("Receive update");

        if (!update.hasMessage()) {
            return;
        }
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
