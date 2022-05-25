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

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("StudentsShowAll", StudentiEntity.class);;
        studentsList = query.getResultList();

        entityManager.close();
        return studentsList;
    }

    public List<StudentiEntity> showAllOrderByGender() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("StudentOrderByGender", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }
}
