package mmtr.klyuev.dictionary.service.serviceImpl;

import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.repository.daoApi.latinDictionary.ILatinDictionaryDao;
import mmtr.klyuev.dictionary.service.serviceApi.ILatinDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LatinDictionaryServiceImpl implements ILatinDictionaryService {

    private ILatinDictionaryDao latinDictionaryDao;

    @Autowired
    public LatinDictionaryServiceImpl(ILatinDictionaryDao latinDictionaryDao) {
        this.latinDictionaryDao = latinDictionaryDao;
    }

    @Override
    public List<LatinEntry> getAllLatinEntries() {
        return latinDictionaryDao.findAll();
    }

    @Override
    public LatinEntry getLatinEntryById(Long id) {
        return latinDictionaryDao.findById(id);
    }

    @Override
    public void addLatinEntry(LatinEntry latinEntry) {
        latinDictionaryDao.add(latinEntry);
    }

    @Override
    public void deleteLatinEntryById(Long id) {
        latinDictionaryDao.deleteById(id);
    }

    @Override
    public void updateLatinEntry(LatinEntry latinEntry) {
        latinDictionaryDao.update(latinEntry);
    }
}
