package edu.javacource.studentorder.validator;

import edu.javacource.studentorder.domain.children.AnswerChildren;
import edu.javacource.studentorder.domain.StudentOrder;

public class ChildrenValidator {
    public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
