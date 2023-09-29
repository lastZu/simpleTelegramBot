package org.github.lastzu.answer;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TestAnswerUtils {
    Message message;
    Chat chat;

    public TestAnswerUtils() {
        this.message = new Message();
        this.chat = new Chat();
    }

    public Message createMessage() {
        message.setChat(this.chat);
        return message;
    }

    public TestAnswerUtils setChatId(long id) {
        this.chat.setId(id);
        return this;
    }

    public TestAnswerUtils setText(String text) {
        this.message.setText(text);
        return this;
    }
}
