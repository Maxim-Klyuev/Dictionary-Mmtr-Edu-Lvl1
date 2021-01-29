package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckMenuItems {

    String template;

    @Autowired
    public void setTemplate(String template) {
        this.template = template;
    }

    @Autowired
    public boolean checkOfMenuItemSelection(String template, String userInput) {
        boolean result = userInput.matches(template);
        return result;
    }
}