package Service;

import java.util.List;

import DAO.MessageDAO;
import Model.Message;

public class MessageService {
    
    private MessageDAO messageDAO;

    public MessageService() {
        this.messageDAO = new MessageDAO();
    }

    public Message newMessage(Message message, AccountService accountService) {
        if (message.getMessage_text().isBlank() || message.getMessage_text().length() > 255) {
            return null;
        }
        if (accountService.getAccountByID(message.getPosted_by()) == null) {
            return null;
        }
        return this.messageDAO.insertMessage(message);
    }

    public List<Message> getAllMessages() {
        return this.messageDAO.getAllMessages();
    }

    public Message getMessageByID(int messageID) {
        return this.messageDAO.getMessageByID(messageID);
    }

    public Message deleteMessage(int messageID) {
        return this.messageDAO.deleteMessage(messageID);
    }

    public Message updateMessage(int messageID, String messageText) {
        if (messageText.isBlank() || messageText.length() > 255) {
            return null;
        }
        return this.messageDAO.updateMessage(messageID, messageText);
    }

    public List<Message> getAllUserMessage(int posted_by) {
        return this.messageDAO.getAllUserMessages(posted_by);
    }

}
