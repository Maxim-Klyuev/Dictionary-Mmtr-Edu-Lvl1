//package mmtr.klyuev.dictionary;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class DigitDict implements DictionaryMatchingCondition {
//
//    private final String DIGIT_ALPHABET = "Incorrect input. Does not meet alphabet requirements.\nWords can only be 5 characters long and these characters are digits only.";
//
//
//    public boolean checkOfDictionaryResponse(String userInput) {
//        String[] args = userInput.split(" ");
//        boolean result = args[0].matches("\\d{5}");
//        if (!result) {
//            System.out.println(DIGIT_ALPHABET);
//        }
//        return result && args.length == 2;
//    }
//}