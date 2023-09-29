package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class KeyboardAnswer implements Answer{
    final Logger logger = LoggerFactory.getLogger(KeyboardAnswer.class);
    private final Answer origin;

    public KeyboardAnswer(Answer origin) {
        this.origin = origin;
    }

    @Override
    public void update(Message message, SendMessage sendMessage) {
        origin.update(message, sendMessage);

        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton("Test");
        button.setCallbackData("Pest");
        row.add(button);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(keyboardMarkup);

        logger.info("Set keyboard to sendMessage");
    }
}
