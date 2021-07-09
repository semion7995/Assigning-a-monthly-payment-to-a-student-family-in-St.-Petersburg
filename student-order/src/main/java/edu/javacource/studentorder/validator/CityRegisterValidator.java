package edu.javacource.studentorder.validator;

import edu.javacource.studentorder.domain.Child;
import edu.javacource.studentorder.domain.Person;
import edu.javacource.studentorder.domain.register.AnswerCityRegister;
import edu.javacource.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacource.studentorder.domain.register.CityRegisterResponse;
import edu.javacource.studentorder.domain.StudentOrder;
import edu.javacource.studentorder.exception.CityRegisterException;
import edu.javacource.studentorder.exception.TransportException;
import edu.javacource.studentorder.validator.register.CityRegisterChecker;
import edu.javacource.studentorder.validator.register.FakeCityRegisterChecker;

import java.util.List;

public class CityRegisterValidator {
    public static final String IN_CODE = "NO_GRN";//интонал код проблема с нашей стороны не смогли до ГРН добраться

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        this.personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        //надо сделать так чтобы при отсутствии связи с регистром написать логику на этот случай
        AnswerCityRegister ans = new AnswerCityRegister();
           ans.addItem(checkPerson(so.getHusband()));
           ans.addItem(checkPerson(so.getWife()));
            List<Child> children = so.getChildren();

            for (Child child : children) {
                ans.addItem(checkPerson(child));
            }
        return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person){
        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;
        try{
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting()? AnswerCityRegisterItem.CityStatus.YES: AnswerCityRegisterItem.CityStatus.NO;
        }
        catch (CityRegisterException ex){
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(), ex.getMessage());
        } catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_CODE, ex.getMessage());
        }
        catch (Exception ex){
            ex.printStackTrace(System.out);
        }
        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status, person, error);
        return ans;
    }
}
