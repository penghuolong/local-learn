package compont;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
