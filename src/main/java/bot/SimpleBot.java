package bot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;

/**
 *
 * @author asp
 */
public class SimpleBot extends TelegramLongPollingBot{
    
    private ArrayList<String> arrayList = new ArrayList<>();
    
    public static LongPollingBot getBot() {
        return new SimpleBot();
    }
    
    @Override
    public String getBotUsername() {
        return "SimpleTelegramJavaAksunovBot";
    }
    
    @Override
    public String getBotToken() {
        return "614270378:AAHOKDjUPqfZJZC-1LPWDhdDpMQ4a6IDRvs";
    }

    @Override
    public void onUpdateReceived(Update update) {
        
        arrayList.add("/stone");
        arrayList.add("/scissors");
        arrayList.add("/paper");
        Collections.shuffle(arrayList);
        String arrValue = arrayList.get(0);
        
        if (update.hasMessage() && update.getMessage().hasText()) {
        //
            
          // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            
            GameMenu(message_text, chat_id, update);
            GameLogic(message_text, arrValue, chat_id);
        }
        //
        else
        {
            
        }
    }

    private void GameMenu(String message_text, long chat_id, Update update) {
        
        if (message_text.equals("Привет"))
        {
            //
            String messageSend = "Привет, сыграем в игру: камень-ножницы-бумага?\n";
            
            SendMessage message = new SendMessage().setChatId(chat_id).setText(messageSend);
            setButtons(message);
            try {
                sendMessage(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else if(message_text.equals("Помощь")){
            String messageSend = "Я телеграм бот для игры в"
                    + "камень-ножницы-бумага";
            SendMessage message = new SendMessage().setChatId(chat_id).setText(messageSend);
            setButtons(message);
            try {
                sendMessage(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String message = update.getMessage().getText();
            sendMsg(update.getMessage().getChatId().toString(), message);
        }
        
        
        if(message_text.equals("Да")){
            String messageSend2 = "Отлично! \n"
                    + "/stone - твой камень\n"
                    + "/scissors - твои ножныци\n"
                    + "/paper - твоя бумага\n";
            SendMessage message2 = new SendMessage().setChatId(chat_id).setText(messageSend2);
            setButtons(message2);
            try {
                sendMessage(message2); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        else if(message_text.equals("Нет")){
            String messageSend3 = "Ну и ладно(";
            SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
            setButtons(message3);
            try {
                sendMessage(message3); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private void GameLogic(String message_text, String arrValue, long chat_id) {
        if(message_text.equals("/stone")){
            if(arrValue.equals("/paper")){
                String messageSend3 = "У меня бумага - я победил! УхахаахАХх!\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/scissors")){
                String messageSend3 = "У меня ножницы - я проиграл!:(\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/stone")){
                String messageSend3 = "У нас ничья О_о\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if(message_text.equals("/paper")){
            if(arrValue.equals("/scissors")){
                String messageSend3 = "У меня ножницы - я победил! УхахаахАХх!\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/stone")){
                String messageSend3 = "У меня камень - я проиграл!:(\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/paper")){
                String messageSend3 = "У нас ничья О_о\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
        
        if(message_text.equals("/scissors")){
            if(arrValue.equals("/stone")){
                String messageSend3 = "У меня камень - я победил! УхахаахАХх!\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/paper")){
                String messageSend3 = "У меня бумага - я проиграл!:(\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            else if(arrValue.equals("/scissors")){
                String messageSend3 = "У нас ничья О_о\n"
                        + "/stone - твой камень\n"
                        + "/scissors - твои ножныци\n"
                        + "/paper - твоя бумага\n";
                SendMessage message3 = new SendMessage().setChatId(chat_id).setText(messageSend3);
                setButtons(message3);
                try {
                    sendMessage(message3); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        //sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
            e.printStackTrace();
        }
    }
    
    private void setButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Привет"));
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Помощь"));
        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
       
    private void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        buttons1.add(new InlineKeyboardButton().setText("Кнопка").setCallbackData("17"));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }
    
    
}
