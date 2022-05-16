package database.repository;

import database.entity.StudentiEntity;
import database.managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<StudentiEntity> showAll() {
        List<StudentiEntity> studentsList = new ArrayList<>();
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("Students_ShowAll", StudentiEntity.class);
        transaction.commit();
        studentsList = query.getResultList();

        entityManager.close();
        return studentsList;
    }
}
