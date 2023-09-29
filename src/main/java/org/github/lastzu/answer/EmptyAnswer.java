package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class EmptyAnswer implements Answer{
    @Override
    public void update(Message message, SendMessage sendMessage) {
        long chatId = message.getChatId();
        sendMessage.setChatId(chatId);
    }
}
