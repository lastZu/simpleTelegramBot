package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Answer {

    /**
     *
     * @return SendMessage - Message to send to Telegram User
     */
    SendMessage get(Message message, SendMessage sendMessage);

    void setNextAnswer(Answer answer);
}
