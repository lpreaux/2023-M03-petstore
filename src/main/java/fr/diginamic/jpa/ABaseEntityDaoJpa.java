package fr.diginamic.jpa;

import fr.diginamic.entities.ABaseEntity;
import fr.diginamic.exceptions.DataException;
import fr.diginamic.persistence.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Function;

public abstract class ABaseEntityDaoJpa<T extends ABaseEntity> implements Dao<T> {
    private static final String FIND_ALL = "SELECT e FROM %s e";
    private static final String FIND_ONE = "SELECT e FROM %s e WHERE ID=:id";

    protected abstract EntityManager getEntityManager();
    protected abstract Class<T> getEntityType();
    protected abstract Logger getLogger();

    protected <R> R doWithEm(Function<EntityManager, R> fn) {
        return fn.apply(getEntityManager());
    }

    protected <R> R doWithTransaction(Function<EntityManager, R> fn) {
        return doWithEm(em -> {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            R result = fn.apply(em);
            tx.commit();
            return result;
        });
    }

    private void persist(T entity) {
        doWithTransaction(em -> {
            em.persist(entity);
            return entity;
        });
    }

    @Override
    public List<T> findAll() {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ALL, entityType.getSimpleName());
        return doWithEm(em -> em.createQuery(qlString, entityType).getResultList());
    }

    @Override
    public T findById(long id) {
        Class<T> entityType = getEntityType();
        String qlString = String.format(FIND_ONE, entityType.getSimpleName());
        return doWithEm(em -> {
            TypedQuery<T> query = em.createQuery(qlString, entityType);
            query.setParameter("id", id);
            return query.getSingleResult();
        });
    }

    @Override
    public T findReferenceById(long id) {
        return doWithEm(em -> em.getReference(getEntityType(), id));
    }

    @Override
    public void create(T entity) throws DataException {
        if (!entity.isNew()) {
            throw new DataException("Entity of type " + getEntityType().getSimpleName() +
                    " with id " + entity.getId() +
                    " already exist.");
        }
        persist(entity);
        getLogger().info("New {} added with id: {}", getEntityType().getSimpleName(), entity.getId());
    }

    @Override
    public void update(T entity) throws DataException {
        if (entity.isNew()) {
            throw new DataException("Entity of type " + getEntityType().getSimpleName() +
                    " with id " + entity.getId() +
                    " is new and can't be updated. It must be created first with create(...)");
        }
        persist(entity);
        getLogger().info("Entity of type {} with id {} updated", getEntityType().getSimpleName(), entity.getId());
    }

    @Override
    public void delete(T entity) {
        doWithTransaction(em -> {
            em.remove(entity);
            return entity;
        });
        getLogger().info("Entity of type {} with id {} deleted", getEntityType().getSimpleName(), entity.getId());
    }
}
