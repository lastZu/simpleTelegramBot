package org.github.lastzu;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyBotTest {
    private final static Logger log = LoggerFactory.getLogger(MyBotTest.class);
    private static String name = "Test";

    @DisplayName("Get bot name from String initialize")
    @Test
    void testGetBotUsername() {
        MyBot myBot = new MyBot(name, "");
        assertEquals(
                name,
                myBot.getBotUsername(),
                () -> "name can t be changed"
        );
    }
}