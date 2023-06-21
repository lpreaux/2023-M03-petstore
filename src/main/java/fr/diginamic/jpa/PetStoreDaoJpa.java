package fr.diginamic.jpa;

import fr.diginamic.entities.PetStore;
import fr.diginamic.persistence.PetStoreDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PetStoreDaoJpa extends ABaseEntityDaoJpa<PetStore> implements PetStoreDao {
    private static final Logger LOG = LoggerFactory.getLogger( PetStoreDaoJpa.class );
    private static PetStoreDaoJpa instance;

    public static PetStoreDaoJpa getInstance() {
        if (null == instance) {
            instance = new PetStoreDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private PetStoreDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<PetStore> getEntityType() {
        return PetStore.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
