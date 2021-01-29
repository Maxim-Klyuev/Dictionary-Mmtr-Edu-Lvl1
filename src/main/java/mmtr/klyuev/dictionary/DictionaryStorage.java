package mmtr.klyuev.dictionary;

public interface DictionaryStorage {

    String showAllWords();

    String translationOneWord(String key);

    void addWord(String userInput);

    boolean deleteWord(String userInput);
}