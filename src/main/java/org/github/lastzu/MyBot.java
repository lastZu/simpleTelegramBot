package org.github.lastzu;

import org.github.lastzu.answer.Answer;

import org.github.lastzu.answer.KeyboardAnswer;
import org.github.lastzu.answer.TextAnswer;
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

        Message message = update.getMessage();

        long chatId = message.getChatId();
        logger.debug("Get message from chatID - {}", chatId);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        Answer textAnswer = new TextAnswer(message);
        textAnswer.set(sendMessage);

        Answer buttonAnswer = new KeyboardAnswer(message);
        buttonAnswer.set(sendMessage);

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
