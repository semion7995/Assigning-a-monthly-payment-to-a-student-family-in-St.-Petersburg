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

        public String getHusbandSurname() {
                return husbandSurname;
        }

        public void setHusbandSurname(String husbandSurname) {
                this.husbandSurname = husbandSurname;
        }

        public String getHusbandGivenName() {
                return husbandGivenName;
        }

        public void setHusbandGivenName(String husbandGivenName) {
                this.husbandGivenName = husbandGivenName;
        }

        public String getHusbandPatronymic() {
                return husbandPatronymic;
        }

        public void setHusbandPatronymic(String husbandPatronymic) {
                this.husbandPatronymic = husbandPatronymic;
        }

        public LocalDate getHusbandDateBirth() {
                return husbandDateBirth;
        }

        public void setHusbandDateBirth(LocalDate husbandDateBirth) {
                this.husbandDateBirth = husbandDateBirth;
        }

        public String getHusbandPassportSerial() {
                return husbandPassportSerial;
        }

        public void setHusbandPassportSerial(String husbandPassportSerial) {
                this.husbandPassportSerial = husbandPassportSerial;
        }

        public String getHusbandPassportNumber() {
                return husbandPassportNumber;
        }

        public void setHusbandPassportNumber(String husbandPassportNumber) {
                this.husbandPassportNumber = husbandPassportNumber;
        }

        public LocalDate getHusbandPassportIssueDate() {
                return husbandPassportIssueDate;
        }

        public void setHusbandPassportIssueDate(LocalDate husbandPassportIssueDate) {
                this.husbandPassportIssueDate = husbandPassportIssueDate;
        }

        public String getWifeSurname() {
                return wifeSurname;
        }

        public void setWifeSurname(String wifeSurname) {
                this.wifeSurname = wifeSurname;
        }

        public String getWifeGivenName() {
                return wifeGivenName;
        }

        public void setWifeGivenName(String wifeGivenName) {
                this.wifeGivenName = wifeGivenName;
        }

        public String getWifePatronymic() {
                return wifePatronymic;
        }

        public void setWifePatronymic(String wifePatronymic) {
                this.wifePatronymic = wifePatronymic;
        }

        public LocalDate getWifeDateBirth() {
                return wifeDateBirth;
        }

        public void setWifeDateBirth(LocalDate wifeDateBirth) {
                this.wifeDateBirth = wifeDateBirth;
        }

        public String getWifePassportSerial() {
                return wifePassportSerial;
        }

        public void setWifePassportSerial(String wifePassportSerial) {
                this.wifePassportSerial = wifePassportSerial;
        }

        public String getWifePassportNumber() {
                return wifePassportNumber;
        }

        public void setWifePassportNumber(String wifePassportNumber) {
                this.wifePassportNumber = wifePassportNumber;
        }

        public LocalDate getWifePassportIssueDate() {
                return wifePassportIssueDate;
        }

        public void setWifePassportIssueDate(LocalDate wifePassportIssueDate) {
                this.wifePassportIssueDate = wifePassportIssueDate;
        }

        public String getMarriageCertificateNumber() {
                return marriageCertificateNumber;
        }

        public void setMarriageCertificateNumber(String marriageCertificateNumber) {
                this.marriageCertificateNumber = marriageCertificateNumber;
        }

        public String getMarriageCertificateDate() {
                return marriageCertificateDate;
        }

        public void setMarriageCertificateDate(String marriageCertificateDate) {
                this.marriageCertificateDate = marriageCertificateDate;
        }
}
