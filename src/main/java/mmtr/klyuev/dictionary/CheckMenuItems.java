package mmtr.klyuev.dictionary;

import org.springframework.stereotype.Component;

@Component
public class CheckMenuItems {

    public boolean checkOfMenuItemSelection(String template, String userInput) {
        boolean result = userInput.matches(template);
        return result;
    }
}