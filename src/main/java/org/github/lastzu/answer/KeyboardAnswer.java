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
    private final Message message;

    public KeyboardAnswer(Message message) {
        this.message = message;
    }

    /**
     *  TODO - Не нравится, что sendMessage изменяется
     * @param sendMessage - Message to send to Telegram User
     */
    @Override
    public void set(SendMessage sendMessage) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList();
        InlineKeyboardButton button = new InlineKeyboardButton("Test");
        button.setCallbackData("Pest");
        row.add(button);
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);
        sendMessage.setReplyMarkup(keyboardMarkup);

        logger.info("Set keyboard to sendMessage");
    }
}
