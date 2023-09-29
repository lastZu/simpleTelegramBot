package org.github.lastzu.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class EmptyAnswerTest {

    @DisplayName("Chat id mast be set from Message ch")
    @Test
    void testSendMessage() {
        EmptyAnswer emptyAnswer = new EmptyAnswer();

        long id = 12345L;
        Chat chat = new Chat(id, "type");
        Message message = new Message();
        message.setChat(chat);

        SendMessage sendMessage = new SendMessage();
        emptyAnswer.update(message, sendMessage);
        assertNotNull(sendMessage);

        String sendId = sendMessage.getChatId();
        assertNotNull(sendId);
        assertEquals(id, Long.parseLong(sendId));
    }

}