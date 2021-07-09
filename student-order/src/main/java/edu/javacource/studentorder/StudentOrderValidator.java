package edu.javacource.studentorder;

import edu.javacource.studentorder.dao.StudentOrderDaoImpl;
import edu.javacource.studentorder.domain.*;
import edu.javacource.studentorder.domain.children.AnswerChildren;
import edu.javacource.studentorder.domain.register.AnswerCityRegister;
import edu.javacource.studentorder.domain.student.AnswerStudent;
import edu.javacource.studentorder.domain.wedding.AnswerWedding;
import edu.javacource.studentorder.exception.DaoException;
import edu.javacource.studentorder.mail.MailSander;
import edu.javacource.studentorder.validator.ChildrenValidator;
import edu.javacource.studentorder.validator.CityRegisterValidator;
import edu.javacource.studentorder.validator.StudentValidator;
import edu.javacource.studentorder.validator.WeddingValidator;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для описания алгоритма проверки
 */
public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;

    private MailSander mailSander;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSander = new MailSander();
    }

    //SOLID
    public static void main(String[] args)  {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

     public void checkAll()  {
        try {
         List<StudentOrder> soList = readStudentOrders();

         for (StudentOrder so : soList) {
//             System.out.println();
             checkOneOrder(so);
         }
        } catch (DaoException e) {
            e.printStackTrace();
        }
     }

    static List<StudentOrder> readStudentOrders() throws DaoException {
        return new StudentOrderDaoImpl().getStudentOrders();
    }
    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityAnswer = checkCityRegister(so);//польше 25-30 операций в одном блоке - дурной тон
//        AnswerWedding wedAnswer = checkWedding(so); //если набирается больше выдели ещё подблоки бро
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }
    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }
    public AnswerChildren checkChildren(StudentOrder so) {
       return childrenVal.checkChildren(so);
    }
    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }
    public void sendMail(StudentOrder so) {
        mailSander.sendMail(so);
    }
}
