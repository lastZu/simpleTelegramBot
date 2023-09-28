package org.github.lastzu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class TelegramBotConfig {
    final static Logger logger = LoggerFactory.getLogger(TelegramBotConfig.class);
    private static final String DEFAULT_TELEGRAM_BOT_CONFIG = "telegram-bot.config.yml";
    private static final String CONFIG_PATH = "./";
    private String name;
    private String token;

    private TelegramBotConfig() {}

    public static TelegramBotConfig getInstance() {
        return getInstance(DEFAULT_TELEGRAM_BOT_CONFIG);
    }

    public static TelegramBotConfig getInstance(String configName) {
        TelegramBotConfig config;
        try (InputStream inputStream = new FileInputStream(CONFIG_PATH + configName)) {

            Yaml yaml = new Yaml(new Constructor(TelegramBotConfig.class));
            config = yaml.load(inputStream);

        } catch (FileNotFoundException e) {
            String errMsg = "Telegram config file not found";
            logger.error("{}: {}", errMsg, e.getStackTrace());
            throw new RuntimeException(errMsg, e.getCause());
        } catch (IOException e) {
            logger.error("Telegram config file not load: {}", e.getMessage());
            throw new RuntimeException(e);
        }

        return config;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
