package edu.javacourse.register.view;

import java.io.Serializable;
import java.time.LocalDate;

//делаем сериализуемым потому что как правило для передачи объекта по сети его нужно сериализовать
public class MarriageRequest implements Serializable {
        private String husbandSurname;
        private String husbandGivenName;
        private String husbandPatronymic;
        private LocalDate husbandDateBirth;
        private String husbandPassportSerial;
        private String husbandPassportNumber;
        private LocalDate husbandPassportIssueDate;
        private String wifeSurname;
        private String wifeGivenName;
        private String wifePatronymic;
        private LocalDate wifeDateBirth;
        private String wifePassportSerial;
        private String wifePassportNumber;
        private LocalDate wifePassportIssueDate;

        private String marriageCertificateNumber;
        private String marriageCertificateDate;

}
