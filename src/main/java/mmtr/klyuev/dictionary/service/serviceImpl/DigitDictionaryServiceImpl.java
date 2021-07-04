package mmtr.klyuev.dictionary.service.serviceImpl;

import mmtr.klyuev.dictionary.model.DigitEntry;
import mmtr.klyuev.dictionary.repository.daoApi.digitDictionary.IDigitDictionaryDao;
import mmtr.klyuev.dictionary.service.serviceApi.IDigitDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DigitDictionaryServiceImpl implements IDigitDictionaryService {

    private IDigitDictionaryDao digitDictionaryDao;

    @Autowired
    public DigitDictionaryServiceImpl(IDigitDictionaryDao digitDictionaryDao) {
        this.digitDictionaryDao = digitDictionaryDao;
    }

    @Override
    public List<DigitEntry> getAllDigitEntries() {
        return digitDictionaryDao.findAll();
    }

    @Override
    public DigitEntry getDigitEntryById(Long id) {
        return digitDictionaryDao.findById(id);
    }

    @Override
    public void addDigitEntry(DigitEntry digitEntry) {
        digitDictionaryDao.add(digitEntry);
    }

    @Override
    public void updateDigitEntry(DigitEntry digitEntry) {
        digitDictionaryDao.update(digitEntry);
    }

    @Override
    public void deleteDigitEntryById(Long id) {
        digitDictionaryDao.deleteById(id);
    }
}
