package mmtr.klyuev.dictionary.repository.dao.latinDictionary;

import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.repository.dao.GenericDaoImpl;
import mmtr.klyuev.dictionary.repository.daoApi.latinDictionary.ILatinDictionaryDao;
import org.springframework.stereotype.Repository;

@Repository
public class LatinDictionaryDaoImpl extends GenericDaoImpl<LatinEntry, Long> implements ILatinDictionaryDao {
}
