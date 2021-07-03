package mmtr.klyuev.dictionary.service.serviceApi;

import mmtr.klyuev.dictionary.model.LatinEntry;

import java.util.List;

public interface ILatinDictionaryService {

    List<LatinEntry> getAllLatinEntries();

    LatinEntry getLatinEntryById(Long id);

    void addLatinEntry(LatinEntry latinEntry);

    void updateLatinEntryById(Long id);

    void deleteLatinEntryById(Long id);
}
