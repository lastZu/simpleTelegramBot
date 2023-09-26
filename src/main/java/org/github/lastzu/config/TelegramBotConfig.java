package org.github.lastzu.config;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TelegramBotConfig {
    public static final String DEFAULT_TELEGRAM_BOT_CONFIG = "telegram-bot.config.yml";
    public static final String CONFIG_PATH = "./src/main/resources/";
    private String name;
    private String token;

    private TelegramBotConfig() {}

    public static TelegramBotConfig getInstance() throws FileNotFoundException {
        return getInstance(DEFAULT_TELEGRAM_BOT_CONFIG);
    }
    public static TelegramBotConfig getInstance(String configName) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(
                new File(CONFIG_PATH + DEFAULT_TELEGRAM_BOT_CONFIG)
        );

        Yaml yaml = new Yaml(new Constructor(TelegramBotConfig.class));
        return yaml.load(inputStream);
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
