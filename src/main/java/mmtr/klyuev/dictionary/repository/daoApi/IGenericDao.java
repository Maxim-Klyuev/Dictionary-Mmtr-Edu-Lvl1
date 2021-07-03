package mmtr.klyuev.dictionary.repository.daoApi;

import mmtr.klyuev.dictionary.model.BaseEntry;
import mmtr.klyuev.dictionary.model.LatinEntry;

import java.util.List;

public interface IGenericDao<T extends BaseEntry, N extends Number> {
    List<T> findAll();
    void add(T entry);
    void update(T entry);
    void delete(T entry);
    LatinEntry getById(N id);
}
