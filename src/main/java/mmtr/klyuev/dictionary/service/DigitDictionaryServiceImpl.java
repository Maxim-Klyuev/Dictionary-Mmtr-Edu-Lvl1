package mmtr.klyuev.dictionary.service;

import mmtr.klyuev.dictionary.model.DigitEntry;
import mmtr.klyuev.dictionary.repository.DigitDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitDictionaryServiceImpl implements IDigitDictionaryService {

    private DigitDictionaryRepository digitDictionaryRepository;

    @Autowired
    public DigitDictionaryServiceImpl(DigitDictionaryRepository digitDictionaryRepository) {
        this.digitDictionaryRepository = digitDictionaryRepository;
    }

    @Autowired
    public List<DigitEntry> findAll() {
        return digitDictionaryRepository.findAll();
    }

    @Override
    public DigitEntry findByWord(String word) {
        return digitDictionaryRepository.getById(word);
    }

    @Override
    public void deleteByWord(String word) {
        digitDictionaryRepository.deleteById(word);
    }

    @Override
    public void add(DigitEntry digitEntry) {
        digitDictionaryRepository.save(digitEntry);
    }

    @Override
    public void updateVyWord(String word) {

    }
}
