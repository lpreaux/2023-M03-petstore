package fr.diginamic;

import fr.diginamic.jpa.EntityManagerProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

public class PetStoreApp {
    private static final Logger LOG = LoggerFactory.getLogger( PetStoreApp.class );

    public static void main(String[] args) {
        LOG.info("Starting PetStore App");

        ResourceBundle application = ResourceBundle.getBundle("application");

        String defaultPersistenceUnitName = application.getString("persistence-unit.default");

        EntityManagerProvider.getEntityManager(defaultPersistenceUnitName);
    }
}
