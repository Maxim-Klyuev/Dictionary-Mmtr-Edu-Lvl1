package mmtr.klyuev.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMenu {

    private List<DictionaryStorage> dictionariesList;
    private AlphabetChecker alphabetChecker;

    @Value("${checkMenuItems.checkDictionaryActionSelection}")
    private String menuTemplate;
    @Value("${checkMenuItems.checkDictionarySelection}")
    private String dictionaryChoiceTemplate;
    @Value("${checkDictionaryResponse.latinDict}")
    private String checkLatinDictionaryResponse;
    @Value("${checkDictionaryResponse.digitDict}")
    private String checkDigitDictionaryResponse;

    @Autowired
    public ConsoleMenu(List<DictionaryStorage> dictionariesList, AlphabetChecker alphabetChecker) {
        this.dictionariesList = dictionariesList;
        this.alphabetChecker = alphabetChecker;
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
    private final String TRANSLATE = "Translation by key <%s> : ";
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
    private final String NFE = " You must enter a number from the menu.";

    public void runConsole() {

        greeting();
        int dictionaryNumber = showDictionaryFiles();
        if (dictionaryNumber == 2) return;

        int menuItem = showMenu();
        if (menuItem == 6) return;

        if (menuItem == 1) {
            showAllWords(dictionariesList.get(dictionaryNumber));
        } else if (menuItem == 2) {
            showTranslationOneWord(dictionariesList.get(dictionaryNumber));
        } else if (menuItem == 3) {
            addWord(dictionariesList.get(dictionaryNumber));
        } else if (menuItem == 4) {
            deleteWord(dictionariesList.get(dictionaryNumber));
        } else if (menuItem == 5) {
            return;
        } else if (menuItem == 6) return;
    }

    private void greeting() {
        showTemplate(GREETING);
    }

    private int showDictionaryFiles() {
        int i = templateMenu(DICTIONARIES, dictionaryChoiceTemplate);
        return i - 1;
    }

    private int showMenu() {
        int i = templateMenu(SELECT_ACT, menuTemplate);
        return i;
    }

    private void showAllWords(DictionaryStorage dictionary) {
        showTemplate(CONTENTS_DICT + "\n" + BACK + "\n" + EXIT);
        System.out.println(dictionary.findAllWords());
    }

    private void showTranslationOneWord(DictionaryStorage dictionary) {
        if (dictionary.equals(dictionariesList.get(0))) {
            showTemplate(ENTER_WORD_TRANSLATE + "\n" + LATIN_ALPHABET + "\n" + BACK + "\n" + EXIT);
        } else {
            showTemplate(ENTER_WORD_TRANSLATE + "\n" + DIGIT_ALPHABET + "\n" + BACK + "\n" + EXIT);
        }
        in = new Scanner(System.in);
        String userInput = in.nextLine().trim().toLowerCase();
        useFormatter(userInput, TRANSLATE);
        System.out.println(dictionary.findWord(userInput));
    }

    private void addWord(DictionaryStorage dictionary) {
        showTemplate(ENTER_WORD_ADD + "\n" + BACK + "\n" + EXIT);
        in = new Scanner(System.in);
        String userInput = in.nextLine().trim().toLowerCase();
        if(dictionary.equals(dictionariesList.get(0))) {
            if (alphabetChecker.checkOfDictionaryResponse(userInput, checkLatinDictionaryResponse)) {
                dictionary.addWord(userInput);
                useFormatter(userInput, ADD);
            } else System.out.println(LATIN_ALPHABET_INC);
        } else if (dictionary.equals(dictionariesList.get(1))) {
            if (alphabetChecker.checkOfDictionaryResponse(userInput, checkDigitDictionaryResponse)) {
                dictionary.addWord(userInput);
                useFormatter(userInput, ADD);
            } else System.out.println(DIGIT_ALPHABET_INC);
        }
    }

    private void deleteWord(DictionaryStorage dictionary) {
        showTemplate(ENTER_WORD_DEL + "\n" + BACK + "\n" + EXIT);
        in = new Scanner(System.in);
        String userInput = in.nextLine().trim().toLowerCase();
        dictionary.deleteWord(userInput);
        useFormatter(userInput, DELETE);
    }

    private void showTemplate(String str) {
        System.out.println(DELIMITER);
        System.out.println(str);
        System.out.println(DELIMITER);
    }

    private int templateMenu(String content, String template) {
        showTemplate(content);
        in = new Scanner(System.in);
        String userInput = in.nextLine();
        int userInputToInt = 0;
        try {
            userInputToInt = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage() + NFE);
        }
        if (!userInput.matches(template)) {
            System.out.println(REPEAT);
        }
        return userInputToInt;
    }

    private void useFormatter(String userInput, String form) {
        formatter = new Formatter();
        formatter.format(form, userInput);
        System.out.println(formatter);
        formatter.close();
    }
}

