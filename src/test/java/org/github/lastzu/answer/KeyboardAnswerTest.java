package org.github.lastzu.answer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardAnswerTest {

    @Test
    void update() {
        Answer empty = new EmptyAnswer();
        KeyboardAnswer answer = new KeyboardAnswer(empty);

        long id = 12345L;

        Message message = new TestAnswerUtils()
                .setChatId(id)
                .createMessage();
        SendMessage sendMessage = new SendMessage();
        answer.update(message, sendMessage);

        assertNotNull(sendMessage);

        ReplyKeyboard keyboardMarkup = sendMessage.getReplyMarkup();
        assertNotNull(keyboardMarkup);

        assertTrue(keyboardMarkup instanceof InlineKeyboardMarkup);
        InlineKeyboardMarkup inlineKeyboardMarkup = (InlineKeyboardMarkup) keyboardMarkup;

        List<List<InlineKeyboardButton>> keyboard = inlineKeyboardMarkup.getKeyboard();
        assertNotNull(keyboard);
    }

    @Disabled
    @DisplayName("")
    @Test
    void buttons() {

    }
}