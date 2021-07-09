package edu.javacource.studentorder.validator;

import edu.javacource.studentorder.domain.student.AnswerStudent;
import edu.javacource.studentorder.domain.StudentOrder;

public class StudentValidator {
    String hastName;
    String login;
    String password;
    public AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Студенты проверяются на:" + hastName + "," + login +"," + password );
        return new AnswerStudent();
    }
}
