package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class EchoAnswer implements Answer{
    final Logger logger = LoggerFactory.getLogger(EchoAnswer.class);
    private Answer origin;

    public EchoAnswer(Answer origin) {
        this.origin = origin;
    }

    @Override
    public void update(Message message, SendMessage sendMessage) {
        origin.update(message, sendMessage);

        String text = getTextAnswer(message);
        sendMessage.setText(text);

        logger.info("Set text to SendMessage: {}", text);
    }

    private String getTextAnswer(Message message) {
        String text = "Unknown command";
        if (message.hasText()) {
            text = message.getText();
        }

        return text;
    }
}
