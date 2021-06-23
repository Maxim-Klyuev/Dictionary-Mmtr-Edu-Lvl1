package mmtr.klyuev.dictionary.service;

import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.repository.LatinDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatinDictionaryServiceImpl implements ILatinDictionaryService {

    private LatinDictionaryRepository latinDictionaryRepository;

    @Autowired
    public LatinDictionaryServiceImpl(LatinDictionaryRepository latinDictionaryRepository) {
        this.latinDictionaryRepository = latinDictionaryRepository;
    }

    @Override
    public List<LatinEntry> findAll() {
        return latinDictionaryRepository.findAll();
    }

    @Override
    public LatinEntry findByWord(String word) {
        return latinDictionaryRepository.getById(word);
    }

    @Override
    public void deleteByWord(String word) {
        latinDictionaryRepository.deleteById(word);
    }

    @Override
    public void add(LatinEntry latinEntry) {
        latinDictionaryRepository.save(latinEntry);
    }

    @Override
    public void updateByWord(String word) {

    }
}
