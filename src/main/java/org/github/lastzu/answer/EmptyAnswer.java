package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class EmptyAnswer implements Answer{
    private Answer nextAnswer;

    @Override
    public SendMessage get(Message message, SendMessage sendMessage) {
        long chatId = message.getChatId();
        sendMessage.setChatId(chatId);

        if (nextAnswer != null) {
            return nextAnswer.get(message, sendMessage);
        }
        return sendMessage;
    }

    public void setNextAnswer(Answer nextAnswer) {
        this.nextAnswer = nextAnswer;
    }
}
