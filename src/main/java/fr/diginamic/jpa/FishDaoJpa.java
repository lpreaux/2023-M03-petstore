package fr.diginamic.jpa;

import fr.diginamic.entities.Fish;
import fr.diginamic.persistence.FishDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FishDaoJpa extends ABaseEntityDaoJpa<Fish> implements FishDao {
    private static final Logger LOG = LoggerFactory.getLogger( FishDaoJpa.class );
    private static FishDaoJpa instance;

    public static FishDaoJpa getInstance() {
        if (null == instance) {
            instance = new FishDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private FishDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Fish> getEntityType() {
        return Fish.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
