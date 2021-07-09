package edu.javacource.studentorder.validator;

import edu.javacource.studentorder.domain.wedding.AnswerWedding;
import edu.javacource.studentorder.domain.StudentOrder;

public class WeddingValidator {
    String hastName;
    String login;
    String password;
    public AnswerWedding checkWedding(StudentOrder so) { //свадьба
        System.out.println("Wedding запущен на:" + hastName + "," + login+ "," + password);
        return new AnswerWedding();
    }
}
