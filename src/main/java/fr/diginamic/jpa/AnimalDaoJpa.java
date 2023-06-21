package fr.diginamic.jpa;

import fr.diginamic.entities.Animal;
import fr.diginamic.persistence.AnimalDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnimalDaoJpa extends ABaseEntityDaoJpa<Animal> implements AnimalDao<Animal> {
    private static final Logger LOG = LoggerFactory.getLogger( AnimalDaoJpa.class );
    private static AnimalDaoJpa instance;

    public static AnimalDaoJpa getInstance() {
        if (null == instance) {
            instance = new AnimalDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private AnimalDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Animal> getEntityType() {
        return Animal.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
