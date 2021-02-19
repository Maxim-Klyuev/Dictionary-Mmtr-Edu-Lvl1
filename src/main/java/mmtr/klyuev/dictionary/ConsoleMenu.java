package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenu {

    private List<DictionaryStorage> dictionariesList;

    private DictionaryMatchingCondition dictionaryMatchingCondition;

    private CheckMenuItems checkMenuItems;

    public ConsoleMenu(List<DictionaryStorage> dictionariesList, DictionaryMatchingCondition dictionaryMatchingCondition, CheckMenuItems checkMenuItems) {
        this.dictionariesList = dictionariesList;
        this.dictionaryMatchingCondition = dictionaryMatchingCondition;
        this.checkMenuItems = checkMenuItems;
    }

    private Formatter formatter;
    private Scanner in;

    private final String DELIMITER = "=========================================================================";
    private final String GREETING = "You are welcome by the translator.";
    private final String DICTIONARIES = "Select a dictionary.\n" + "1. Latin Dictionary.\n2. Digit Dictionary.\n3. Exit.";
    private final String LIST_OF_ACTIONS = "1. Show dictionary contents.\n2. Translate one word." +
            "\n3. Add word to dictionary.\n4. Delete word from dictionary." +
            "\n5. Back to dictionary selection.\n6. Exit.";
    private final String SELECT_ACT = "Select an action.\n" + LIST_OF_ACTIONS;
    private final String CONTENTS_DICT = "Contents of the dictionary:";
    private final String ENTER_WORD_TRANSLATE = "Enter a word to translate.";
    private final String ENTER_WORD_ADD = "Enter a key-value pair after SPACE to add to the dictionary.";
    private final String ENTER_WORD_DEL = "Enter a key to remove an entry from the dictionary.";
    private final String TRANSLATE = "Translation by key <%s> :";
    private final String ADD = "Entry <%s> added.";
    private final String DELETE = "Key entry <%s> deleted.";
    private final String LATIN_ALPHABET = "Words can only be 4 characters long and these characters are Latin only.";
    private final String DIGIT_ALPHABET = "Words can only be 5 characters long and these characters are Digits only.";
    private final String EXIT = "2. Exit.";
    private final String BACK = "1. Back.";
    private final String REPEAT = "Incorrect input. There is no such item in the menu. Repeat please.";
    private final String LATIN_ALPHABET_INC = "Incorrect input. Does not meet alphabet requirements." +
            "\nWords can only be 4 characters long and these characters are Latin only.";
    private final String DIGIT_ALPHABET_INC = "Incorrect input. Does not meet alphabet requirements." +
            "\nWords can only be 5 characters long and these characters are digits only.";

    private void showTemplate(String str) {
        System.out.println(DELIMITER);
        System.out.println(str);
        System.out.println(DELIMITER);
    }

    private void useFormatter(String userInput, String s) {
        formatter = new Formatter();
        formatter.format(s, userInput);
        System.out.println(formatter);
        formatter.close();
    }


//    private String correctSelection(String menuItemBar, String template) {
//        in = new Scanner(System.in);
//        String userInput = in.nextLine().trim();
////        while (!checkMenuItems.checkOfMenuItemSelection(template, userInput)) {
////            System.out.println(REPEAT);
////            System.out.println(menuItemBar);
////            userInput = in.nextLine().trim();
////        }
//        return userInput;
//    }


    private void consoleGreeting() {
        showTemplate(GREETING);
    }


    private int consoleShowDictionaryFiles() {
        showTemplate(DICTIONARIES);
        in = new Scanner(System.in);
        String userInput = in.nextLine();
        int i = Integer.parseInt(userInput) - 1;
        return i;
//        correctSelection(DICTIONARIES + "\n" + DELIMITER, "^[1-3]{1}");
    }

//    private void consoleShowMenu() {
//        showTemplate(SELECT_ACT);
////        correctSelection(SELECT_ACT + "\n" + DELIMITER, "^[1-6]{1}");
//    }

    private void consoleShowAllWords() {
        showTemplate(CONTENTS_DICT);
        int i = consoleShowDictionaryFiles();
        System.out.println(dictionariesList.get(i).showAllWords());

     //   showTemplate(BACK + "\n" + EXIT);
//        correctSelection(BACK + "\n" + EXIT + "\n" + DELIMITER, "^[1-2]{1}");
    }

//    private void consoleShowTranslationOneWord() {
//        showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);   // latin/digit
//        String userInput = in.nextLine().trim().toLowerCase();
//        while (!userInput.equals("1") && !userInput.equals("2")) {
//            useFormatter(userInput, TRANSLATE);
//            System.out.println(dictionaryStorageOnFileSystem.translationOneWord(userInput));
//            showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
//            userInput = in.nextLine().trim().toLowerCase();
//        }
//    }
//
//    private void consoleAddWord() {
//        String template = "^[a-z]{4}";
//        showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
//        String userInput = in.nextLine().trim().toLowerCase();
//        while (!userInput.equals("1") && !userInput.equals("2")) {
//            if (dictionaryMatchingCondition.checkOfDictionaryResponse(template, userInput)) {
//                dictionaryStorageOnFileSystem.addWord(userInput);
//                useFormatter(userInput, ADD);
//            } else System.out.println(LATIN_ALPHABET_INC);          // latin/digit
//            showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
//            userInput = in.nextLine().trim().toLowerCase();
//        }
//    }
//
//    private void consoleDeleteWord() {
//        showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
//        String userInput = in.nextLine().trim().toLowerCase();
//        while (!userInput.equals("1") && !userInput.equals("2")) {
//            dictionaryStorageOnFileSystem.deleteWord(userInput);
//            useFormatter(userInput, DELETE);
//            showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
//            userInput = in.nextLine().trim().toLowerCase();
//        }
//    }

    public void runConsole() {
    //    consoleGreeting();
    //    consoleShowDictionaryFiles();

//        consoleShowMenu();
        consoleShowAllWords();
//        consoleShowTranslationOneWord();
//        consoleAddWord();
//        consoleDeleteWord();
    }
}

