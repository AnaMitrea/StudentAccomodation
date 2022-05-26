package database.repository;

import database.entity.StudentiEntity;
import database.managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public List<StudentiEntity> showAll() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("StudentsShowAll", StudentiEntity.class);;
        List<StudentiEntity> studentsList = query.getResultList();

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

    public List<StudentiEntity> ShowStudentsDormitory1() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory1", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    public List<StudentiEntity> ShowStudentsDormitory2() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory2", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    public List<StudentiEntity> ShowStudentsDormitory3() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory3", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    public List<StudentiEntity> ShowStudentsDormitory4() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory4", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }

    public List<StudentiEntity> ShowStudentsDormitory5() {
        javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

        TypedQuery<StudentiEntity> query = entityManager.createNamedQuery("ShowStudentsDormitory5", StudentiEntity.class);
        List<StudentiEntity> orderedStudentsList  = query.getResultList();

        entityManager.close();
        return orderedStudentsList;
    }
}
