package org.github.lastzu.answer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

abstract class CainAnswerFactory implements AnswerFactory{
    private Answer firstAnswer;

    @Override
    public SendMessage create(Message message) {
        SendMessage sendMessage = new SendMessage();
        return firstAnswer.get(message, sendMessage);
    }

    public void setFirstAnswer(Answer firstAnswer) {
        this.firstAnswer = firstAnswer;
    }
}
