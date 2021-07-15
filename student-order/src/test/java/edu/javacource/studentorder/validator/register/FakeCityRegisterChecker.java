package edu.javacource.studentorder.validator.register;

import edu.javacource.studentorder.domain.Adult;
import edu.javacource.studentorder.domain.Child;
import edu.javacource.studentorder.domain.register.CityRegisterResponse;
import edu.javacource.studentorder.domain.Person;
import edu.javacource.studentorder.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker{
    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";//ошибки из ГРН
    private static final String ERROR_2 = "2002";//ошибки из ГРН
    private static final String ERROR_T_1 = "1003";//Транспортная ошибка
    private static final String ERROR_T_2 = "2003";
    public CityRegisterResponse checkPerson(Person person)throws CityRegisterException  {
        CityRegisterResponse res = new CityRegisterResponse();
        if (person instanceof Adult){
            Adult t = (Adult) person;
            String ps = t.getPassportSeria();
            if (ps.equals(GOOD_1)||ps.equals(GOOD_2)){
                res.setRegister(true);
                res.setTemporal(false);
            }
            if (ps.equals(BAD_1)||ps.equals(BAD_2)){
                res.setRegister(false);
            }
            if (ps.equals(ERROR_1)||ps.equals(ERROR_2)){
                CityRegisterException ex = new CityRegisterException("1","GRN ERROR " + ps);
                throw ex;
            }

        }
        if (person instanceof Child){
            res.setRegister(true);
            res.setTemporal(true);
        }
        System.out.println(res.toString());
        return res;
    }
}
