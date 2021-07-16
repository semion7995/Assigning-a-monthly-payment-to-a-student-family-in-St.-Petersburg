package edu.javacourse.register.manager;

import edu.javacourse.register.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

/**
 * класс для примера возможностей hibernate непосредственно
 */
public class PersonManager {
    public static void main(String[] args) {

//        sessionExampleHib();
        jpaExample();
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");//берем имя из конфиг
/**
 * на практике работают преимущественно с JPA но всё пересекается и очень часто для использования интересных возможностей, которые предлагает hibernate
 * используют и его реализацию
 */
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new Person();
        p.setFirstName("Антон");
        p.setLastName("Жуков");
        em.persist(p);//не возвращает ничего но инициализирует недостающее поле в нашем случае это id
        //вставили
        System.out.println(p.getPersonId());
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();//ReadOnly
        List list = em.createQuery("FROM Person").getResultList();//тут мы используем язык jPA-QL, можно исп и HQL они похожи
        list.forEach(p1-> System.out.println(p1));
        em.close();
    }

    private static void sessionExampleHib() {
        SessionFactory sf = buildSessionFactory();//создали аналог коннектов к БД глобальный объект

        System.out.println();
        System.out.println();
        System.out.println();

        Session session = sf.openSession();//на время выполнения единичной операции в виде транзакции мы создаём сессию

        session.getTransaction().begin();//для того чтобы иметь возможность модификации создаём транзакцию

        Person p = new Person();
        p.setFirstName("Семён");
        p.setLastName("Жуков");

        Long id = (Long) session.save(p);//вставит наш объект по команде insert
        System.out.println(id);
        //получаем в ответ идентификатором в моём случае это Long но в практике бывают и строки и даже СОСТАВНОЙ ОБЪЕКТ!!!
        //поэтому в ответ возвращается объект Serialazible мы просто знаем что у нас Long

//        session.saveOrUpdate(p); будет искать id нашего объекта и обновлять, в нашем случае просто присвоит и вставит
        session.getTransaction().commit();
//        session.getTransaction().rollback();
        session.close();
        session= sf.openSession();//здесь обращение идёт в режиме readOnly - режим исключительно для чтения
        // в этом случае не всегда есть необходимость открывать транзакцию
        //для того чтобы закоммитить наши изменения
        Person person = session.get(Person.class, id);
        System.out.println(person);
        session.close();

        session = sf.openSession();

        List<Person> list = session.createQuery("FROM Person", Person.class).list();//запросы делаются не с помощью языка SQL а с помощью языка HQL
//вытаскиваем всё так как мы обращаемся к классу пишем с большой буквы
        list.forEach(person1 -> System.out.println(person1));
        System.out.println();
        list.forEach(System.out::println);
        session.close();
    }

    private static SessionFactory buildSessionFactory(){//по сути это строительный блок
        //SessionFactory - это некий пулл конектов, позволяет получать некий аналог коннектов к базе данных
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//сервис регистрируется в hibernate через него он всем управляет
                    .configure("hibernate.cfg.xml").build();//строю сервис по своему описанию

            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            //создаём метаданные для построения Session Factory

            return metadata.getSessionFactoryBuilder().build();
        }
        catch (Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
