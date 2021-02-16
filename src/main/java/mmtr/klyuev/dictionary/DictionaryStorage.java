package mmtr.klyuev.dictionary;

import java.io.File;

public interface DictionaryStorage {

    String showAllWords();

    String translationOneWord(String key);

    void addWord(String userInput);

    void deleteWord(String userInput);
}