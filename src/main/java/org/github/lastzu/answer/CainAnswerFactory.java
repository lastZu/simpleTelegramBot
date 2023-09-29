package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

abstract class CainAnswerFactory implements AnswerFactory{
    private Answer answer;

    @Override
    public SendMessage create(Message message) {
        SendMessage sendMessage = new SendMessage();
        answer.update(message, sendMessage);
        return sendMessage;
    }

    protected void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
