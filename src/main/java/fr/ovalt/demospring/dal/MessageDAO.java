package fr.ovalt.demospring.dal;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageDAO {
    private List<String> messages = List.of(
            "hello world",
            "salut thomas",
            "coucou etienne"
    );

    public String get(int id) {
        return messages.get(id);
    }

    public List<String> getAll() {
        return messages;
    }
}
