package edu.javacource.studentorder.exception;
//если ГРН нам вернул что-то нехорошее

public class CityRegisterException extends Exception{
    private String code;

    public String getCode() {
        return code;
    }

    public CityRegisterException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CityRegisterException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}