package mmtr.klyuev.dictionary;

import org.springframework.stereotype.Component;

@Component
public class DictionaryMatchingCondition {

    public boolean checkOfDictionaryResponse(String template, String userInput) {
        String[] args = userInput.split(" ");
        boolean result = args[0].matches(template);
        return result && args.length == 2;
    }
}