package org.github.lastzu.answer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.junit.jupiter.api.Assertions.*;

class EchoAnswerTest {

    @DisplayName("Answer text should not change")
    @Test
    void update() {
        Answer empty = new EmptyAnswer();
        EchoAnswer answer = new EchoAnswer(empty);

        long id = 12345L;
        String text = "test text";

        Message message = new TestAnswerUtils()
                .setChatId(id)
                .setText(text)
                .createMessage();
        SendMessage sendMessage = new SendMessage();
        answer.update(message, sendMessage);

        assertNotNull(sendMessage);

        String newText = sendMessage.getText();
        assertNotNull(newText);
        assertEquals(text, newText);
    }
}