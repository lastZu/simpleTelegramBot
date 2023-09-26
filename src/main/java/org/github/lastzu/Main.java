package org.github.lastzu;

import org.github.lastzu.config.TelegramBotConfig;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotConfig config = TelegramBotConfig.getInstance();
            System.out.println(config.getName());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}