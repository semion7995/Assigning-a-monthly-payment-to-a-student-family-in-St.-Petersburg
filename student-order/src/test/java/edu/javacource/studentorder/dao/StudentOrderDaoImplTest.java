package edu.javacource.studentorder.dao;

import edu.javacource.studentorder.domain.*;
import edu.javacource.studentorder.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class StudentOrderDaoImplTest {
   @BeforeClass
   public static void startUp() throws Exception {
      DBInit.startUp();
   }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test (expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
         StudentOrder so = buildStudentOrder(10);
         so.getHusband().setSurName(null);
         Long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

     public StudentOrder buildStudentOrder(long id){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1L, "","");
        so.setMarriageOffice(ro);

        Street street = new Street(1l, "First street");


        Address address = new Address("195000", street, "12", "", "142");
        //Муж
        Adult husband = new Adult("Петров","Виктор","Сергеевич", LocalDate.of(1997,8,24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017,9,15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId(""+(100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("HH12345");
        //Жена
        Adult wife = new Adult("Петров","Виктор","Сергеевич", LocalDate.of(1997,8,24));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018,4,5));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("WW12345");
        //Ребенок
        Child child = new Child("Петрова","Ирина","Викторовна", LocalDate.of(2018,6,29));
        child.setCertificateNummber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(2L, "","");
        child.setIssueDepartment(ro2);
        child.setAddress(address);
        //Ребёнок 2
        Child child2 = new Child("Петров","Евгений","Павловна", LocalDate.of(2018,6,29));
        child2.setCertificateNummber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3L, "","");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);
        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child);
        so.addChild(child2);
        return so;
    }
   @Test
   public void getStudentOrders() throws DaoException {
      List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
   }
}