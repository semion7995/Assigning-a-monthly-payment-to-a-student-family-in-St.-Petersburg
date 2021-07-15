package edu.javacource.studentorder.domain;

import edu.javacource.studentorder.domain.Person;

import java.time.LocalDate;

public class Child extends Person {
    private String certificateNummber;
    private LocalDate issueDate;
    private RegisterOffice issueDepartment;//департамент выпуска

    public Child(String surName, String givenName, String patronymic, LocalDate dateOfBirth) {
        super(surName, givenName, patronymic, dateOfBirth);
    }

    public String getCertificateNummber() {
        return certificateNummber;
    }

    public void setCertificateNummber(String certificateNummber) {
        this.certificateNummber = certificateNummber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public RegisterOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(RegisterOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    @Override
    public String toString() {
        return "Child{" +
//                "certificateNummber='" + certificateNummber + '\'' +
//                ", issueDate=" + issueDate +
//                ", issueDepartment=" + issueDepartment +
//                "} "
                 super.toString();
    }
}
