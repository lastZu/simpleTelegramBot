package org.github.lastzu.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TelegramBotConfigTest {

    @Test
    void testForAbsentFileGetInstance() {
        assertThrows(
                RuntimeException.class,
                () -> TelegramBotConfig.getInstance("NotFound.yml")
        );
    }

    @DisplayName("Get name and token from config")
    @Test
    void testGetInstance() {
        TelegramBotConfig config = TelegramBotConfig.getInstance(
                "src/test/resources/test-telegram-bot.config.yml"
        );
        assertEquals("TestBot", config.getName());
        assertEquals("test", config.getToken());
    }
}