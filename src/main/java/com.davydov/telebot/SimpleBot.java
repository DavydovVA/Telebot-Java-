package com.davydov.telebot;

import com.davydov.database.Peripheral;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;



public class SimpleBot extends TelegramLongPollingBot {

	private Peripheral periphery;

	public SimpleBot(Peripheral peripheral) {
		this.periphery = peripheral;
	}

	public void onUpdateReceived(Update update) {
		try {
			String message = update.getMessage().getText();

			if (message.charAt(0) != '/') {
				String info;
				try {
					info = periphery.get(message).getDescription(); // throws NPtrExc, when nothing found in db
				} catch(NullPointerException e){
					info = "No info about " + message + ".";
				}

				execute(new SendMessage(update.getMessage().getChatId(), info));
			} else if (message.charAt(0) == '/') {
				// if Command
				Command command = Command.parse(message);

				if (command != null) {
					switch (command) {
						// to be update
						case HELP:
							sendMessage(update, command.getDescription());
							break;
						case START:
							sendMessage(update, command.getDescription());
							break;
						case CITIES:
							sendMessage(update, command.getDescription());
							break;
					}
				} else {
					execute(new SendMessage(update.getMessage().getChatId(), message.concat(" not found.")));
				}
			}

		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Update update, String description) throws TelegramApiException {
		execute(new SendMessage(update.getMessage().getChatId(), description));
	}

	@Override
	public String getBotUsername() {
		return "test_dva_pvsm_bot";
	}

	@Override
	public String getBotToken() {
		return "1115004291:AAGlnBaydiN6BAQshXphYXqb_W1R8lIIehM";
	}
}
