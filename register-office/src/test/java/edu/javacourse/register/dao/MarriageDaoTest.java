package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.view.MarriageRequest;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class MarriageDaoTest {

    @Test
    public void findMarriageCertificate() {
        Date date1 = new Date();
        MarriageDao md = new MarriageDao();
        MarriageRequest request = new MarriageRequest();
        request.setHusbandSurname("Васильев");
        request.setHusbandGivenName("Олег");
        request.setHusbandPatronymic("Петрович");
        request.setHusbandDateBirth(LocalDate.of(1997, 10, 16));
        request.setHusbandPassportSerial("5000");
        request.setHusbandPassportNumber("654321");
        request.setHusbandPassportIssueDate(LocalDate.of(2017, 11, 20));

//        PersonMale husband = new PersonMale("Семён", "Жуков", "Юрьевич", LocalDate.of(1997, 3, 1));
//        PersonFemale wife = new PersonFemale("Якушкина", "Юлия", "Юрьевна", LocalDate.of(1998, 9, 19));

        request.setWifeSurname("Васильева");
        request.setWifeGivenName("Елена");
        request.setWifePatronymic("Сергеевна");
        request.setWifeDateBirth(LocalDate.of(1998, 3, 24));
        request.setWifePassportSerial("4000");
        request.setWifePassportNumber("123456");
        request.setWifePassportIssueDate(LocalDate.of(2018, 4, 10));
        request.setMarriageCertificateNumber("F123");
        request.setMarriageCertificateDate("2018-03-22");

        MarriageCertificate marriageCertificate = md.findMarriageCertificate(request);
        System.out.println(marriageCertificate.getMarriageCertificateId());
        System.out.println(marriageCertificate.getNumber());
        System.out.println(marriageCertificate.getIssueDate());
        System.out.println(marriageCertificate.getHusband().getLastName());
        System.out.println(marriageCertificate.getWife().getLastName());
        System.out.println(marriageCertificate.getEndDate());
        Date date2 = new Date();
        System.out.println(date2.getTime()- date1.getTime());
    }
}