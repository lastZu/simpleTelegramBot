package org.github.lastzu;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    private String name;

    public MyBot(String name) {
        this.name = name;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage()) return;

        Message message = update.getMessage();
        if (!message.hasText()) return;

        String text = message.getText();
        long chatId = message.getChatId();

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return name;
    }
}
