package edu.javacourse.register.dao;

import edu.javacourse.register.domain.*;
import org.junit.Test;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonDaoTest {
   @Test
    public void addPerson(){

//       private String number;
//
//       private LocalDate issueDate;
//
//       private Person person;
//
//       private PersonMale father;
//
//       private PersonFemale mother;

//       PersonDao dao = new PersonDao();
//
//       Person child = new Person("Марсель", "Жуков", "Семёнович", LocalDate.of(2019, 1, 1), null, null);
//
//       BirthCertificate birthCertificate = new BirthCertificate("666", LocalDate.of(2019, 01, 01), child);
//       var passportsHusband = new ArrayList<Passport>();
//       var passportWife = new ArrayList<Passport>();
//       PersonMale husband = dao.createDataPerson(Sex.MALE, "Семён", "Жуков", "Юрьевич", LocalDate.of(1997, 3, 1),
//               birthCertificate, passportsHusband, );
//       PersonMale wife = dao.createDataPerson(Sex.FEMALE, "Юлия", "Якушкина", "Юрьевна", LocalDate.of(1998, 9, 19),
//               birthCertificate, passportWife, );

   }


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
            if (p instanceof PersonMale){
                System.out.println("Birth Cert Male:" + ((PersonMale) p).getBirthCertificates().size());
                System.out.println("Marriage Cert Male:"+((PersonMale) p).getMarriageCertificates().size());
                System.out.println();
            }
            else {
                System.out.println("Birth Cert Female:" + ((PersonFemale) p).getBirthCertificates().size());
                System.out.println("Marriage Cert Female:"+((PersonFemale) p).getMarriageCertificates().size());
                System.out.println();
            }
        });
    }

}