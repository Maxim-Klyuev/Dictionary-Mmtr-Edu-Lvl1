package mmtr.klyuev.dictionary.repository.dao;

import mmtr.klyuev.dictionary.model.BaseEntry;
import mmtr.klyuev.dictionary.model.LatinEntry;
import mmtr.klyuev.dictionary.repository.daoApi.IGenericDao;

import java.util.List;

public class GenericDaoImpl<T extends BaseEntry, N extends Number> implements IGenericDao<T, N> {

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void add(T entry) {

    }

    @Override
    public void update(T entry) {

    }

    @Override
    public void delete(T entry) {

    }

    @Override
    public LatinEntry getById(N id) {
        return null;
    }
}
