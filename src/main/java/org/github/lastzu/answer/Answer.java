package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Answer {

    /**
     *
     * @param  SendMessage - Message to send to Telegram User
     */
    void update(Message message, SendMessage sendMessage);
}
