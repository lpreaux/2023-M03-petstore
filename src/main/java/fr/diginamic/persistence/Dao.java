package fr.diginamic.persistence;

import fr.diginamic.entities.ABaseEntity;

import java.util.List;

public interface Dao<T extends ABaseEntity> {
    List<T> findAll();
    T findById(long id);
    T findReferenceById(long id);
    void create(T entity);
    void update(T entity);
    void delete(T entity);
}
