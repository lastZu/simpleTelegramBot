package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TextAnswer implements Answer{
    final Logger logger = LoggerFactory.getLogger(TextAnswer.class);
    private Answer nextAnswer;
    @Override
    public SendMessage get(Message message, SendMessage sendMessage) {
        String text = getTextAnswer(message);
        sendMessage.setText(text);

        logger.info("Set text to SendMessage: {}", text);

        if (nextAnswer != null) {
            return nextAnswer.get(message, sendMessage);
        }
        return sendMessage;
    }

    private String getTextAnswer(Message message) {
        String text = "Unknown command";
        if (message.hasText()) {
            text = message.getText();
        }

        return text;
    }

    public void setNextAnswer(Answer nextAnswer) {
        this.nextAnswer = nextAnswer;
    }
}
