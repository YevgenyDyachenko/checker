package com.ua.checker;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            //message.setText(update.getMessage().getText());
            message.setText(reverseStringByWords(update.getMessage().getText()).toUpperCase());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

    public static String reverseStringByWords (String string) {
        StringBuilder stringBuilder = new StringBuilder ();
        String [] words = string.split (" ");
        for (int j = words.length-1; j >= 0; j--) {
            stringBuilder.append (words [j]).append (' ');
        }

        return stringBuilder.toString();

    }


    @Override
    public String getBotUsername() {
        // TODO
        return "myamazingbot";
    }

    @Override
    public String getBotToken() {
        // TODO
        return "6189146571:AAGZPDZm3b0lO3dycC87iLfl7agmkTXlhlM";
    }
}
