package database.managerfactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class provides EntityManager that is an API that manages the lifecycle of entity instances.
 * An EntityManager object manages a set of entities that are defined by a persistence unit.
 * Each EntityManager instance is associated with a persistence context. A persistence context
 * defines the scope under which particular entity instances are created, persisted, and removed
 * through the APIs made available by EntityManager. In some ways, a persistence context is
 * conceptually similar to a transaction context.
 *  @author Mitrea Ana-Maria
 *  @author Ungureanu Diana-Cristina
 *  @version 1.32
 *  @since 2022-05-30
 */
public class EntityManager {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

    private EntityManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static void close() {
        entityManagerFactory.close();
    }
}