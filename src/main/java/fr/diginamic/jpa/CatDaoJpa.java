package fr.diginamic.jpa;

import fr.diginamic.entities.Cat;
import fr.diginamic.persistence.CatDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatDaoJpa extends ABaseEntityDaoJpa<Cat> implements CatDao {
    private static final Logger LOG = LoggerFactory.getLogger( CatDaoJpa.class );
    private static CatDaoJpa instance;

    public static CatDaoJpa getInstance() {
        if (null == instance) {
            instance = new CatDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private CatDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Cat> getEntityType() {
        return Cat.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
