package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class DaoEntityTest {

//    private EntityManagerFactory entityManagerFactory;
//    private EntityManagerFactory entityManagerFactory2;
//
//    @Before
//    public void setUp(){
//    entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
//    entityManagerFactory2  = Persistence.createEntityManagerFactory("persistence");
//    }
////    @Test
//    public void createEntity(){
//        DaoEntity daoEntity = new DaoEntity(
//                true, true, "ABC88", LocalDate.of(2019, 1, 19), "Marriage certificate",LocalDate.of(2018, 3, 22),
//                true, LocalDate.of(2025, 3, 3), "Юлия", "Якушкина", "Юрьевна", LocalDate.of(1998, 9, 19),
//                "5555", "666666", LocalDate.of(2018, 10, 1), "UFMS Republic Mariy - El", "Семён", "Жуков", "Юрьевич", LocalDate.of(1997, 3, 1),
//                "4017", "746733", LocalDate.of(2017, 11, 17), "UFMC Saint-Petersburg Frunzensky rayon", "Марсель", "Жуков", "Семёнович",
//                LocalDate.of(2019, 1, 1)
//                );
//        var entity = daoEntity.createEntity(4l,5l,6l);
//        EntityManager entityManager = entityManagerFactory2.createEntityManager();
//        entityManager.getTransaction().begin();
////        Person merge = entityManager.merge(entity.get(0));
////        entityManager.persist(merge);
//        entityManager.persist(entity.get(0));
//        entityManager.getTransaction().commit();
////        entityManager.close();
//    }
//
//    @Test
//    public void createEntityFak(){
//        DaoEntity daoEntity = new DaoEntity(
//                true, true, "ABC88", LocalDate.of(2019, 1, 19), "Marriage certificate",LocalDate.of(2018, 3, 22),
//                true, LocalDate.of(2025, 3, 3), "Юлия", "Якушкина", "Юрьевна", LocalDate.of(1998, 9, 19),
//                "5555", "666666", LocalDate.of(2018, 10, 1), "UFMS Republic Mariy - El", "Семён", "Жуков", "Юрьевич", LocalDate.of(1997, 3, 1),
//                "4017", "746733", LocalDate.of(2017, 11, 17), "UFMC Saint-Petersburg Frunzensky rayon", "Марсель", "Жуков", "Семёнович",
//                LocalDate.of(2019, 1, 1)
//                );
//        var entity = daoEntity.createEntity(4l,5l,6l);
//        EntityManager entityManager = entityManagerFactory2.createEntityManager();
//      entityManager.getTransaction().begin();
//
//
//      Person mother = entityManager.merge(entity.get(0));
//
//
//        entityManager.getTransaction().commit();
//
//    }

}