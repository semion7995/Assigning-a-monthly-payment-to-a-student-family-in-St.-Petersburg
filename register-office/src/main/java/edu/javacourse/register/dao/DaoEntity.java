package edu.javacourse.register.dao;

import edu.javacourse.register.domain.*;

import java.time.LocalDate;
import java.util.*;

public class DaoEntity {
    
    private boolean mother;
    private boolean father;
    //BirthCertificate created data
    private BirthCertificate birthCertificate;
    private String numberBirthCertificate;
    private LocalDate issueDateBirthCertificate;
    //MarriageCertificate create data
    private MarriageCertificate marriageCertificate;
    private String numberMarriageCertificate;
    private LocalDate issueDateMarriageCertificate;
    private boolean activeMarriageCertificate;
    private LocalDate endDateMarriageCertificate;
    //Mother
    private String motherFirstName;
    private String motherLastName;
    private String motherPatronymic;
    private LocalDate motherDateOfBirth;
    private String motherPassportSerial;
    private String motherPassportNumber;
    private LocalDate motherPassportIssueDate;
    private String motherIssueDepartment;
    private ArrayList<BirthCertificate> birthCertificatesMother;
    private ArrayList<MarriageCertificate> marriageCertificatesWife;

    //Father
    private String fatherFirstName;
    private String fatherLastName;
    private String fatherPatronymic;
    private LocalDate fatherDateOfBirth;
    private String fatherPassportSerial;
    private String fatherPassportNumber;
    private LocalDate fatherPassportIssueDate;
    private String fatherIssueDepartment;
    private ArrayList<BirthCertificate> birthCertificatesFather;
    private ArrayList<MarriageCertificate> marriageCertificatesHusband;
    //Child
    private String childFirstName;
    private String childLastName;
    private String childPatronymic;
    private LocalDate childDateOfBirth;

    public DaoEntity(boolean mother, boolean father, String numberBirthCertificate, LocalDate issueDateCertificate, String numberMarriageCertificate,
                     LocalDate issueDateMarriageCertificate, boolean activeMarriageCertificate, LocalDate endDateMarriageCertificate, String motherFirstName,
                     String motherLastName, String motherPatronymic, LocalDate motherDateOfBirth, String motherPassportSerial, String motherPassportNumber,
                     LocalDate motherPassportIssueDate, String motherIssueDepartment, String fatherFirstName, String fatherLastName, String fatherPatronymic,
                     LocalDate fatherDateOfBirth, String fatherPassportSerial, String fatherPassportNumber, LocalDate fatherPassportIssueDate,
                     String fatherIssueDepartment, String childFirstName, String childLastName, String childPatronymic, LocalDate childDateOfBirth) {
        this.mother = mother;
        this.father = father;
        this.numberBirthCertificate = numberBirthCertificate;
        this.issueDateBirthCertificate = issueDateCertificate;
        this.numberMarriageCertificate = numberMarriageCertificate;
        this.issueDateMarriageCertificate = issueDateMarriageCertificate;
        this.activeMarriageCertificate = activeMarriageCertificate;
        this.endDateMarriageCertificate = endDateMarriageCertificate;
        this.motherFirstName = motherFirstName;
        this.motherLastName = motherLastName;
        this.motherPatronymic = motherPatronymic;
        this.motherDateOfBirth = motherDateOfBirth;
        this.motherPassportSerial = motherPassportSerial;
        this.motherPassportNumber = motherPassportNumber;
        this.motherPassportIssueDate = motherPassportIssueDate;
        this.motherIssueDepartment = motherIssueDepartment;
        this.birthCertificatesMother = new ArrayList<>();
        this.marriageCertificatesWife = new ArrayList<>();
        this.fatherFirstName = fatherFirstName;
        this.fatherLastName = fatherLastName;
        this.fatherPatronymic = fatherPatronymic;
        this.fatherDateOfBirth = fatherDateOfBirth;
        this.fatherPassportSerial = fatherPassportSerial;
        this.fatherPassportNumber = fatherPassportNumber;
        this.fatherPassportIssueDate = fatherPassportIssueDate;
        this.fatherIssueDepartment = fatherIssueDepartment;
        this.birthCertificatesFather = new ArrayList<>();
        this.marriageCertificatesHusband = new ArrayList<>();
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.childPatronymic = childPatronymic;
        this.childDateOfBirth = childDateOfBirth;
    }

    public DaoEntity(
    ) {
    }

    public ArrayList<Person> createEntity(Long motherId, Long fatherId, Long childId){
        ArrayList personArrayList = new ArrayList<Person>();
           personArrayList.add(createMother(motherId));
           personArrayList.add(createFather(fatherId));
           personArrayList.add(createChild(childId));
            return personArrayList;
    }

    private BirthCertificate createBirthCertificate(){
        birthCertificate = new BirthCertificate();
        birthCertificate.setNumber(numberBirthCertificate);
        birthCertificate.setIssueDate(issueDateBirthCertificate);
        return birthCertificate;
    }

    private MarriageCertificate createMarriageCertificate(){
        marriageCertificate = new MarriageCertificate();
        marriageCertificate.setNumber(numberMarriageCertificate);
        marriageCertificate.setIssueDate(issueDateMarriageCertificate);
        marriageCertificate.setActive(activeMarriageCertificate);
        marriageCertificate.setEndDate(endDateMarriageCertificate);
        return marriageCertificate;
    }

    private PersonFemale createMother(Long motherId){
        PersonFemale mother = new PersonFemale(motherFirstName, motherLastName, motherPatronymic, motherDateOfBirth);
        Passport passport = new Passport(motherPassportSerial, motherPassportNumber, motherPassportIssueDate,motherIssueDepartment);
        mother.setPersonId(motherId);
        passport.setPerson(mother);
        ArrayList passports = new ArrayList<Passport>();
        passports.add(passport);
        mother.setPassports(passports);
        if (birthCertificate == null){
        birthCertificate = createBirthCertificate();
        }

        birthCertificate.setMother(mother);
        birthCertificatesMother.add(birthCertificate);
        mother.setBirthCertificates(birthCertificatesMother);
        if (marriageCertificate==null) {
            marriageCertificate = createMarriageCertificate();
        }
        marriageCertificate.setWife(mother);
        marriageCertificatesWife.add(marriageCertificate);
        mother.setMarriageCertificates(marriageCertificatesWife);
        return mother;
    }

    private PersonMale createFather(Long fatherId){
        PersonMale father = new PersonMale(fatherFirstName, fatherLastName, fatherPatronymic, fatherDateOfBirth);
        Passport passport = new Passport(fatherPassportSerial, fatherPassportNumber, fatherPassportIssueDate,fatherIssueDepartment);
        father.setPersonId(fatherId);
        passport.setPerson(father);
        ArrayList passports = new ArrayList<Passport>();
        passports.add(passport);
        father.setPassports(passports);
        if(birthCertificate==null){
        birthCertificate = createBirthCertificate();
        }
        birthCertificate.setFather(father);
        birthCertificatesFather.add(birthCertificate);
        father.setBirthCertificates(birthCertificatesFather);
        if (marriageCertificate==null) {
            marriageCertificate = createMarriageCertificate();
        }
        marriageCertificate.setHusband(father);
        marriageCertificatesHusband.add(marriageCertificate);
        father.setMarriageCertificates(marriageCertificatesHusband);
        return father;
    }


    private PersonMale createChild(Long childId){
        PersonMale child = new PersonMale(childFirstName, childLastName, childPatronymic, childDateOfBirth);
        birthCertificate.setPerson(child);
        child.setBirthCertificate(birthCertificate);
        child.setPersonId(childId);
        return child;
    }
    public boolean isMother() {
        return mother;
    }

    public void setMother(boolean mother) {
        this.mother = mother;
    }

    public boolean isFather() {
        return father;
    }

    public void setFather(boolean father) {
        this.father = father;
    }

    public BirthCertificate getBirthCertificate() {
        return birthCertificate;
    }

    public void setBirthCertificate(BirthCertificate birthCertificate) {
        this.birthCertificate = birthCertificate;
    }

    public String getNumberBirthCertificate() {
        return numberBirthCertificate;
    }

    public void setNumberBirthCertificate(String numberBirthCertificate) {
        this.numberBirthCertificate = numberBirthCertificate;
    }

    public LocalDate getIssueDateBirthCertificate() {
        return issueDateBirthCertificate;
    }

    public void setIssueDateBirthCertificate(LocalDate issueDateBirthCertificate) {
        this.issueDateBirthCertificate = issueDateBirthCertificate;
    }

    public MarriageCertificate getMarriageCertificate() {
        return marriageCertificate;
    }

    public void setMarriageCertificate(MarriageCertificate marriageCertificate) {
        this.marriageCertificate = marriageCertificate;
    }

    public String getNumberMarriageCertificate() {
        return numberMarriageCertificate;
    }

    public void setNumberMarriageCertificate(String numberMarriageCertificate) {
        this.numberMarriageCertificate = numberMarriageCertificate;
    }

    public LocalDate getIssueDateMarriageCertificate() {
        return issueDateMarriageCertificate;
    }

    public void setIssueDateMarriageCertificate(LocalDate issueDateMarriageCertificate) {
        this.issueDateMarriageCertificate = issueDateMarriageCertificate;
    }

    public boolean isActiveMarriageCertificate() {
        return activeMarriageCertificate;
    }

    public void setActiveMarriageCertificate(boolean activeMarriageCertificate) {
        this.activeMarriageCertificate = activeMarriageCertificate;
    }

    public LocalDate getEndDateMarriageCertificate() {
        return endDateMarriageCertificate;
    }

    public void setEndDateMarriageCertificate(LocalDate endDateMarriageCertificate) {
        this.endDateMarriageCertificate = endDateMarriageCertificate;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getMotherPatronymic() {
        return motherPatronymic;
    }

    public void setMotherPatronymic(String motherPatronymic) {
        this.motherPatronymic = motherPatronymic;
    }

    public LocalDate getMotherDateOfBirth() {
        return motherDateOfBirth;
    }

    public void setMotherDateOfBirth(LocalDate motherDateOfBirth) {
        this.motherDateOfBirth = motherDateOfBirth;
    }

    public String getMotherPassportSerial() {
        return motherPassportSerial;
    }

    public void setMotherPassportSerial(String motherPassportSerial) {
        this.motherPassportSerial = motherPassportSerial;
    }

    public String getMotherPassportNumber() {
        return motherPassportNumber;
    }

    public void setMotherPassportNumber(String motherPassportNumber) {
        this.motherPassportNumber = motherPassportNumber;
    }

    public LocalDate getMotherPassportIssueDate() {
        return motherPassportIssueDate;
    }

    public void setMotherPassportIssueDate(LocalDate motherPassportIssueDate) {
        this.motherPassportIssueDate = motherPassportIssueDate;
    }

    public String getMotherIssueDepartment() {
        return motherIssueDepartment;
    }

    public void setMotherIssueDepartment(String motherIssueDepartment) {
        this.motherIssueDepartment = motherIssueDepartment;
    }

    public ArrayList<BirthCertificate> getBirthCertificatesMother() {
        return birthCertificatesMother;
    }

    public void setBirthCertificatesMother(ArrayList<BirthCertificate> birthCertificatesMother) {
        this.birthCertificatesMother = birthCertificatesMother;
    }

    public ArrayList<MarriageCertificate> getMarriageCertificatesWife() {
        return marriageCertificatesWife;
    }

    public void setMarriageCertificatesWife(ArrayList<MarriageCertificate> marriageCertificatesWife) {
        this.marriageCertificatesWife = marriageCertificatesWife;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getFatherPatronymic() {
        return fatherPatronymic;
    }

    public void setFatherPatronymic(String fatherPatronymic) {
        this.fatherPatronymic = fatherPatronymic;
    }

    public LocalDate getFatherDateOfBirth() {
        return fatherDateOfBirth;
    }

    public void setFatherDateOfBirth(LocalDate fatherDateOfBirth) {
        this.fatherDateOfBirth = fatherDateOfBirth;
    }

    public String getFatherPassportSerial() {
        return fatherPassportSerial;
    }

    public void setFatherPassportSerial(String fatherPassportSerial) {
        this.fatherPassportSerial = fatherPassportSerial;
    }

    public String getFatherPassportNumber() {
        return fatherPassportNumber;
    }

    public void setFatherPassportNumber(String fatherPassportNumber) {
        this.fatherPassportNumber = fatherPassportNumber;
    }

    public LocalDate getFatherPassportIssueDate() {
        return fatherPassportIssueDate;
    }

    public void setFatherPassportIssueDate(LocalDate fatherPassportIssueDate) {
        this.fatherPassportIssueDate = fatherPassportIssueDate;
    }

    public String getFatherIssueDepartment() {
        return fatherIssueDepartment;
    }

    public void setFatherIssueDepartment(String fatherIssueDepartment) {
        this.fatherIssueDepartment = fatherIssueDepartment;
    }

    public ArrayList<BirthCertificate> getBirthCertificatesFather() {
        return birthCertificatesFather;
    }

    public void setBirthCertificatesFather(ArrayList<BirthCertificate> birthCertificatesFather) {
        this.birthCertificatesFather = birthCertificatesFather;
    }

    public ArrayList<MarriageCertificate> getMarriageCertificatesHusband() {
        return marriageCertificatesHusband;
    }

    public void setMarriageCertificatesHusband(ArrayList<MarriageCertificate> marriageCertificatesHusband) {
        this.marriageCertificatesHusband = marriageCertificatesHusband;
    }

    public String getChildFirstName() {
        return childFirstName;
    }

    public void setChildFirstName(String childFirstName) {
        this.childFirstName = childFirstName;
    }

    public String getChildLastName() {
        return childLastName;
    }

    public void setChildLastName(String childLastName) {
        this.childLastName = childLastName;
    }

    public String getChildPatronymic() {
        return childPatronymic;
    }

    public void setChildPatronymic(String childPatronymic) {
        this.childPatronymic = childPatronymic;
    }

    public LocalDate getChildDateOfBirth() {
        return childDateOfBirth;
    }

    public void setChildDateOfBirth(LocalDate childDateOfBirth) {
        this.childDateOfBirth = childDateOfBirth;
    }
}
