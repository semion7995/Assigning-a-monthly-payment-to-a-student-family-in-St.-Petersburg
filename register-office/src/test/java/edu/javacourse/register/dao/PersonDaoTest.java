package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {
    @Test
    public void findPerson(){
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPerson();
        persons.forEach(p->{
            System.out.println("Name:" + p.getFirstName());
            System.out.println("Class for sex" + p.getClass().getName());
            System.out.println("Passports:"+p.getPassports().size());
            System.out.println("Birth:"+p.getBirthCertificate());
            System.out.println();
//            if (p instanceof PersonMale){
//                System.out.println("Birth Cert Male:" + ((PersonMale) p).getBirthCertificates().size());
//                System.out.println("Marriage Cert Male:"+((PersonMale) p).getMarriageCertificates().size());
//                System.out.println();
//            }
//            else {
//                System.out.println("Birth Cert Female:" + ((PersonFemale) p).getBirthCertificates().size());
//                System.out.println("Marriage Cert Female:"+((PersonFemale) p).getMarriageCertificates().size());
//                System.out.println();
//            }
        });
    }

}