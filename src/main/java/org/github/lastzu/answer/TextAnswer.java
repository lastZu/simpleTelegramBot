package org.github.lastzu.answer;

import org.github.lastzu.MyBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TextAnswer implements Answer{
    final Logger logger = LoggerFactory.getLogger(TextAnswer.class);
    private final Message message;

    public TextAnswer(Message message) {
        this.message = message;
    }

    /**
     *  TODO - Не нравится, что sendMessage изменяется
     * @param sendMessage - Message to send to Telegram User
     */
    @Override
    public void set(SendMessage sendMessage) {
        if (!message.hasText()) return;

        String text = message.getText();
        sendMessage.setText(text);

        logger.info("Set text to SendMessage: {}", text);
    }
}
