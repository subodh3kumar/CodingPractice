package workshop.util;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public final class PersistenceUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        log.info("getEntityManagerFactory() method called");
        Properties props = new Properties();
        if (entityManagerFactory == null) {
            try {
                String fileName = System.getenv("persistence_property_file_path");
                log.info("file name: {}", fileName);
                props.load(new FileInputStream("/Development/Workspace/IDEA/CodingPractice/FileLoadProcessCucumber/src/main/resources/persistence.properties"));
                //props.load(new FileInputStream(fileName));
                entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit", props);
            } catch (IOException e) {
                log.error("ERROR", e);
            }
        }
        return entityManagerFactory;
    }
}
