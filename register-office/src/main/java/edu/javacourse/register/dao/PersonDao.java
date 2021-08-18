package edu.javacourse.register.dao;

import edu.javacourse.register.domain.*;

import javax.persistence.*;
import java.util.List;

public class PersonDao {

    @PersistenceContext //auto init em across EMF springContext.xml
    private EntityManager entityManager;

//    public PersonDao() {
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
//        entityManager = factory.createEntityManager();
//    }

    public List<Person> findPerson(){
        Query query = entityManager.createNamedQuery("Person.findPersons");
//        query.setParameter("personId", 1L);
        return query.getResultList();
    }

    public Long addPerson(Person person){
//        EntityTransaction tr = entityManager.getTransaction();
//        tr.begin();
//        try {

        /**
         * configured the Transaction Manager configuration and we no longer need gray
         */
            entityManager.persist(person);
            entityManager.flush();//flush synchronized DataBase
//            entityManager.getTransaction().commit();
//        } catch (Exception ex){
//            tr.rollback();
//            throw new RuntimeException(ex);
//        }
        return person.getPersonId();
    }
}



























