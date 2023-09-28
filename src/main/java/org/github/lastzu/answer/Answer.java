package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Answer {
    void set(SendMessage sendMessage);
}
