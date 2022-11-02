package peaksoft.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Util {
    public static EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("peaksoft").createEntityManager();
    }
}
