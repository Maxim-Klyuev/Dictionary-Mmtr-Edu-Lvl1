package mmtr.klyuev.dictionary;


public interface DictionaryStorage {

    String showAllWords();

    String translationOneWord(String key);

    void addWord(String userInput);

    void deleteWord(String userInput);
}