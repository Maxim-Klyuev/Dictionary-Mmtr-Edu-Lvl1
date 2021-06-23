package mmtr.klyuev.dictionary.service;

import mmtr.klyuev.dictionary.model.LatinEntry;

import java.util.List;

public interface ILatinDictionaryService {

    List<LatinEntry> findAll();

    LatinEntry findByWord(String word);

    void deleteByWord(String word);

    void add(LatinEntry latinEntry);

    void updateByWord(String word);
}
