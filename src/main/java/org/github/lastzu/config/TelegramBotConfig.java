package org.github.lastzu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

final public class TelegramBotConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(TelegramBotConfig.class);
    private static final String DEFAULT_TELEGRAM_BOT_CONFIG = "telegram-bot.config.yml";
    private static final String CONFIG_PATH = "./";
    private String name;
    private String token;

    private TelegramBotConfig() { }

    public static TelegramBotConfig getInstance() {
        return getInstance(DEFAULT_TELEGRAM_BOT_CONFIG);
    }

    public static TelegramBotConfig getInstance(final String configName) {
        TelegramBotConfig config;
        try (InputStream inputStream = new FileInputStream(CONFIG_PATH + configName)) {

            Yaml yaml = new Yaml(new Constructor(TelegramBotConfig.class));
            config = yaml.load(inputStream);

        } catch (FileNotFoundException e) {
            String errMsg = "Telegram config file not found";
            LOGGER.error("{}: {}", errMsg, e.getStackTrace());
            throw new RuntimeException(errMsg, e.getCause());
        } catch (IOException e) {
            LOGGER.error("Telegram config file not load: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        return config;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }
}
