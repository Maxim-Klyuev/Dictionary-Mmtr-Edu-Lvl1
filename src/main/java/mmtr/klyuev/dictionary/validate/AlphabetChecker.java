package mmtr.klyuev.dictionary.validate;

import mmtr.klyuev.dictionary.config.ApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlphabetChecker {

    @Autowired
    ApplicationConfig config = new ApplicationConfig();


    public boolean checkOfDictionaryResponse(String userInput, String template) {

        String[] args = userInput.split(" ");
        boolean result = args[0].matches(template) && args.length == 2;
        return result;
    }
}