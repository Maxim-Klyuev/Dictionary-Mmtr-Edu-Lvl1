package mmtr.klyuev.dictionary.dataStorage;


public interface DictionaryStorage {

    String findAllWords();

    String findWord(String word);

    void addWord(String record);

    void deleteWord(String word);
}