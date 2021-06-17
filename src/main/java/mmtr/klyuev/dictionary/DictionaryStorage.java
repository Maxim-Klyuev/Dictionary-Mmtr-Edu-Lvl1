package mmtr.klyuev.dictionary;


public interface DictionaryStorage {

    String findAllWords();

    String findWord(String word);

    void addWord(String record);

    void deleteWord(String word);
}