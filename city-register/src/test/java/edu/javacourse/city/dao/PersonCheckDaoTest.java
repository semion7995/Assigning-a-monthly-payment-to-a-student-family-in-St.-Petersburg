package edu.javacourse.city.dao;

import edu.javacourse.PersonCheckDao;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class PersonCheckDaoTest {
//    @Test
//    public  void tre(){
//        LocalDate dateOfBirth = LocalDate.parse("18.03.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        System.out.println(dateOfBirth);
//    }

    @Test
    public void checkPerson() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильев");
        pr.setGivenName("Павел");
        pr.setPatronymic("Николаевич");
        pr.setDate_of_birth(LocalDate.of(1995, 3, 18));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegister());
        Assert.assertFalse(ps.isTemporal());
        System.out.println(ps.isRegister());
    }
//VALUES ('Васильева', 'Ирина', 'Петровна', '1997-08-21', '4321', '654321', '2017-09-19', null, null );
    //VALUES (1, 1, '274', null, null );
    @Test
    public void checkPerson2() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильева");
        pr.setGivenName("Ирина");
        pr.setPatronymic("Петровна");
        pr.setDate_of_birth(LocalDate.of(1997, 8, 21));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegister());
        Assert.assertFalse(ps.isTemporal());
        System.out.println(ps.isRegister());
    }
    @Test
    public void checkPerson3() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильева");
        pr.setGivenName("Евгения");
        pr.setPatronymic("Павловна");
        pr.setDate_of_birth(LocalDate.of(2016, 1, 11));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegister());
        Assert.assertFalse(ps.isTemporal());
        System.out.println(ps.isRegister());
    }
    @Test
    public void checkPerson4() throws PersonCheckException {
        PersonRequest pr = new PersonRequest();
        pr.setSurName("Васильев");
        pr.setGivenName("Александр");
        pr.setPatronymic("Павлович");
        pr.setDate_of_birth(LocalDate.of(2018, 10, 24));
        pr.setStreetCode(1);
        pr.setBuilding("10");
        pr.setExtension("2");
        pr.setApartment("121");

        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse ps = dao.checkPerson(pr);
        Assert.assertTrue(ps.isRegister());
        Assert.assertFalse(ps.isTemporal());
        System.out.println(ps.isRegister());
    }
}