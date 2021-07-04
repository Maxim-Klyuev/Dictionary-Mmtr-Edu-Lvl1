package mmtr.klyuev.dictionary.repository.dao;

import mmtr.klyuev.dictionary.model.BaseEntry;
import mmtr.klyuev.dictionary.repository.daoApi.IGenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericDaoImpl<T extends BaseEntry, N extends Number> implements IGenericDao<T, N> {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }

    @Override
    public void add(T entry) {

    }
    @Override
    public void update(T entry) {

    }

    @Override
    public void deleteById(N id) {

    }

    @Override
    public T findById(N id) {
        return null;
    }
}
