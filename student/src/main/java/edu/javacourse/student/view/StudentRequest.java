package edu.javacourse.student.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
//example JSON
/**{
"lastName":"Last",
"firstName":"First",
"middleName":"Middle",
"dateOfBirth":"12.04.2000",
"passportSerial":"1111",
"passportNumber":"222222",
"passportDate":"30.04.2016"
        }*/

public class StudentRequest {

    private String firstName;
    private String lastName;
    private String middleName;
//    @XmlJavaTypeAdapter(value = LocalDateAdapter.class) для стандартной java спецификации
    @JsonSerialize(converter = LocalDateStringConverter.class)//Data -> String аннотация для ReST Spring
    @JsonDeserialize(converter = StringLocalDateConverter.class)//String -> Data
    private LocalDate dateOfBirth;
    private String passportSerial;
    private String passportNumber;
//    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    @JsonSerialize(converter = LocalDateStringConverter.class)//Data -> String аннотация для ReST Spring
    @JsonDeserialize(converter = StringLocalDateConverter.class)//String -> Data
    private LocalDate passportDate;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(LocalDate passportDate) {
        this.passportDate = passportDate;
    }
}
