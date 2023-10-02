package org.github.lastzu;

import org.github.lastzu.answer.EchoMessageAnswer;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMyBot {
    private final static Logger log = LoggerFactory.getLogger(TestMyBot.class);
    private static String name = "Test";

    @DisplayName("Get bot name from String initialize")
    @Test
    void testGetBotUsername() {
        MyBot myBot = new MyBot(name, "", new EchoMessageAnswer());
        assertEquals(
                name,
                myBot.getBotUsername(),
                () -> "name can t be changed"
        );
    }
}