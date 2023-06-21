package fr.diginamic.jpa;

import fr.diginamic.entities.Address;
import fr.diginamic.persistence.AddressDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressDaoJpa extends ABaseEntityDaoJpa<Address> implements AddressDao {
    private static final Logger LOG = LoggerFactory.getLogger( AddressDaoJpa.class );
    private static AddressDaoJpa instance;

    public static AddressDaoJpa getInstance() {
        if (null == instance) {
            instance = new AddressDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private AddressDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Address> getEntityType() {
        return Address.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
