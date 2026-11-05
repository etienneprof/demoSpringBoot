package fr.ovalt.demospring.services;

import fr.ovalt.demospring.dal.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageDAO messageDAO;

    @Autowired
    public MessageService(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    public String get(int id) {
        return messageDAO.get(id);
    }

    public List<String> getAll() {
        return messageDAO.getAll();
    }
}
