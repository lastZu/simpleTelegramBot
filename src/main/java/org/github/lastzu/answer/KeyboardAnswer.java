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
    private Answer nextAnswer;

    @Override
    public SendMessage get(Message message, SendMessage sendMessage) {
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

        if (nextAnswer != null) {
            return nextAnswer.get(message, sendMessage);
        }
        return sendMessage;
    }

    public void setNextAnswer(Answer nextAnswer) {
        this.nextAnswer = nextAnswer;
    }
}
