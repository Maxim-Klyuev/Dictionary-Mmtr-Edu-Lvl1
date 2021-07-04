package mmtr.klyuev.dictionary.repository.dao.digitDictionary;

import mmtr.klyuev.dictionary.model.DigitEntry;
import mmtr.klyuev.dictionary.repository.dao.GenericDaoImpl;
import mmtr.klyuev.dictionary.repository.daoApi.digitDictionary.IDigitDictionaryDao;
import org.springframework.stereotype.Repository;

@Repository
public class DigitDictionaryDaoImpl extends GenericDaoImpl<DigitEntry, Long> implements IDigitDictionaryDao {

}
