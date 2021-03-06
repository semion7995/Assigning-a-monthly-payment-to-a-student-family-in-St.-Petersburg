package edu.javacourse.register.domain;

import javax.persistence.*;
import java.time.LocalDate;
@Table(name = "ro_passport")
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_id")
    private Long passportId;

    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(name = "serial")
    private String serial;
    @Column(name = "number")
    private String number;
    @Column(name = "date_issue")
    private LocalDate issueDate;
    @Column (name = "issue_department")
    private String issueDepartment;

    public Passport(String serial, String number, LocalDate issueDate, String issueDepartment) {
        this.serial = serial;
        this.number = number;
        this.issueDate = issueDate;
        this.issueDepartment = issueDepartment;
    }
    public Passport() {

    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPassportId() {
        return passportId;
    }

    public void setPassportId(Long passportId) {
        this.passportId = passportId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }
}
