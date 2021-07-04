package mmtr.klyuev.dictionary.service.serviceApi;

import mmtr.klyuev.dictionary.model.DigitEntry;

import java.util.List;

public interface IDigitDictionaryService {

    List<DigitEntry> getAllDigitEntries();

    DigitEntry getDigitEntryById(Long id);

    void addDigitEntry(DigitEntry digitEntry);

    void updateDigitEntry(DigitEntry digitEntry);

    void deleteDigitEntryById(Long id);
}
