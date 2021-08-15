package edu.javacourse.register.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("1")

public class PersonFemale extends Person implements Serializable {
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "wife")
    private List<MarriageCertificate> marriageCertificates;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "mother")
    private List<BirthCertificate> birthCertificates;

    public PersonFemale(String firstName, String lastName, String patronymic, LocalDate dateOfBirth) {
        super(firstName, lastName, patronymic, dateOfBirth);
        this.marriageCertificates = marriageCertificates;
        this.birthCertificates = birthCertificates;
    }
    public PersonFemale() {

    }

    public List<MarriageCertificate> getMarriageCertificates() {
        return marriageCertificates;
    }

    public void setMarriageCertificates(List<MarriageCertificate> marriageCertificates) {
        this.marriageCertificates = marriageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
}
