package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.Formatter;

@Component
@Scope("prototype")
public class ConsoleMenu {

    @Autowired
    private DictionaryStorage dictionaryStorageOnFileSystem;

    @Autowired
    private DictionaryMatchingCondition dictionaryMatchingCondition;

    @Autowired
    private CheckMenuItems checkMenuItems;

    private Formatter formatter;
    private Scanner in = new Scanner(System.in);

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
    private final String DIGIT_ALPHABET = "Words can only be 5 characters long and these characters are digits only.";
    private final String EXIT = "2. Exit.";
    private final String BACK = "1. Back.";
    private final String ONE_BACK = "1";
    private final String TWO_EXIT = "2";
    private final String ERROR_DELETE = "This word is not in the dictionary.";
    private final String REPEAT = "Incorrect input. There is no such item in the menu. Repeat please.";
    private final String LATIN_ALPHABET_INC = "Incorrect input. Does not meet alphabet requirements.\nWords can only be 4 characters long and these characters are Latin only.";
    private final String DIGIT_ALPHABET_INC = "Incorrect input. Does not meet alphabet requirements.\nWords can only be 5 characters long and these characters are digits only.";

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

    private void correctSelection(String menuItemBar) {
        String userInput = in.nextLine().trim();
        while (!checkMenuItems.checkOfMenuItemSelection(checkMenuItems.template, userInput)) {
            System.out.println(REPEAT);
            System.out.println(menuItemBar);
            userInput = in.nextLine().trim();
        }
    }


    public void consoleGreeting() {
        showTemplate(GREETING);
    }

    @Value("%{checkMenuItems.checkDictionarySelection}")
    public void consoleShowDictionaryFiles() {
        showTemplate(DICTIONARIES);
        correctSelection(DICTIONARIES + "\n" + DELIMITER );
    }

//    public void consoleShowMenu() {
//        showTemplate(SELECT_ACT);
//        correctSelection(new CheckMenuItems("^[1-6]{1}"), SELECT_ACT + "\n" + DELIMITER);
//    }
//
//    public void consoleShowAllWords() {
//        showTemplate(CONTENTS_DICT);
//        System.out.println(dictionaryStorageOnFileSystem.showAllWords());
//        showTemplate(BACK + "\n" + EXIT);
//        correctSelection(new CheckMenuItems("^[1-2]{1}"), BACK + "\n" + EXIT + "\n" + DELIMITER);
//    }
//
//    public void consoleShowTranslationOneWord() {
//        showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
//        String userInput = in.nextLine().trim().toLowerCase();
//        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
//            useFormatter(userInput, TRANSLATE);
//            System.out.println(dictionaryStorageOnFileSystem.translationOneWord(userInput));
//            showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
//            userInput = in.nextLine().trim().toLowerCase();
//        }
//    }
//
//    public void consoleAddWord() {
//        showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
//        String userInput = in.nextLine().trim().toLowerCase();
//        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
//            if (dictionaryMatchingCondition.checkOfDictionaryResponse(userInput)) {
//                dictionaryStorageOnFileSystem.addWord(userInput);
//                useFormatter(userInput, ADD);
//            } else System.out.println(LATIN_ALPHABET_INC);
//            showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
//            userInput = in.nextLine().trim().toLowerCase();
//        }
//    }

    public void consoleDeleteWord() {
        showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
        String userInput = in.nextLine().trim().toLowerCase();
        while (!userInput.equals(ONE_BACK) && !userInput.equals(TWO_EXIT)) {
            if (dictionaryStorageOnFileSystem.deleteWord(userInput)) {
                dictionaryStorageOnFileSystem.deleteWord(userInput);
                useFormatter(userInput, DELETE);
            } else System.out.println(ERROR_DELETE);
            showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
            userInput = in.nextLine().trim().toLowerCase();
        }
    }

    public void runConsole() {
        consoleGreeting();
    }
}

