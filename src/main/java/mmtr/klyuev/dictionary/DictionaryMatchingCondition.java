package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;

public class DictionaryMatchingCondition {

    String template;

    @Autowired
    public void setTemplate(String template) {
        this.template = template;
    }

    public boolean checkOfDictionaryResponse(String template, String userInput) {
        String[] args = userInput.split(" ");
        boolean result = args[0].matches(template);
        return result && args.length == 2;
    }
}