package fr.diginamic.jpa;

import fr.diginamic.entities.Product;
import fr.diginamic.persistence.ProductDao;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDaoJpa extends ABaseEntityDaoJpa<Product> implements ProductDao {
    private static final Logger LOG = LoggerFactory.getLogger( ProductDaoJpa.class );
    private static ProductDaoJpa instance;
    public static ProductDaoJpa getInstance() {
        if (null == instance) {
            instance = new ProductDaoJpa();
        }
        return instance;
    }

    private final EntityManager em = EntityManagerProvider.getEntityManager("petstore");

    private ProductDaoJpa() {}

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected Class<Product> getEntityType() {
        return Product.class;
    }

    @Override
    protected Logger getLogger() {
        return LOG;
    }
}
