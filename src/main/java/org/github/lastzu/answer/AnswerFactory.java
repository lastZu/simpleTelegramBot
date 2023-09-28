package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface AnswerFactory {
    Answer create(Message message);
}
