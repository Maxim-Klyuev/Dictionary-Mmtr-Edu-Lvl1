package mmtr.klyuev.dictionary.service;

import mmtr.klyuev.dictionary.model.DigitEntry;

import java.util.List;

public interface IDigitDictionaryService {

    List<DigitEntry> findAll();

    DigitEntry findByWord(String word);

    void deleteByWord(String word);

    void add(DigitEntry digitEntry);

    void updateVyWord(String word);
}
