package edu.javacourse.register.dao;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Passport;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MarriageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageDao() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request){
        LOGGER.info("findMarriageCertificate called:{}", test);
//        PersonMale husband = getHusband(request);
//        PersonFemale wife = getWife(request);
//        entityManager.getTransaction().begin();
//        entityManager.merge(husband);
//        entityManager.merge(wife);
//        entityManager.getTransaction().commit();
//
//        Query namedQuery = entityManager.createNamedQuery("MarriageCertificate.findMarriageCertificate");
//        namedQuery.setParameter("husband", husband);
//        namedQuery.setParameter("wife", wife);
//        List<MarriageCertificate> mc = namedQuery.getResultList();
//        return mc.size()!=0? mc.get(0):null;
        return null;
    }

    /**
     *     private Long marriageCertificateId;
     *     private String number;
     *     private LocalDate issueDate;
     *     private PersonMale husband;
     *     private PersonFemale wife;
     *     private boolean active;
     *     private LocalDate endDate;
     */

    private PersonMale getHusband(MarriageRequest request) {
        var husband = new PersonMale();
        husband.setPersonId(2l);
        husband.setFirstName(request.getHusbandGivenName());
        husband.setLastName(request.getHusbandSurname());
        husband.setPatronymic(request.getHusbandPatronymic());
        husband.setDateOfBirth(request.getHusbandDateBirth());

        var husbandPassport = new Passport();
        husbandPassport.setPassportId(2l);
        husbandPassport.setSerial(request.getHusbandPassportSerial());
        husbandPassport.setNumber(request.getHusbandPassportNumber());
        husbandPassport.setPerson(husband);
        husbandPassport.setIssueDate(request.getHusbandPassportIssueDate());
        husbandPassport.setIssueDepartment("Department Passport 2");
        var passportsHusband = new ArrayList<Passport>();
        passportsHusband.add(husbandPassport);
        husband.setPassports(passportsHusband);
        return husband;
    }

    private PersonFemale getWife(MarriageRequest request) {
        var wife = new PersonFemale();
        wife.setPersonId(1l);
        wife.setFirstName(request.getWifeGivenName());
        wife.setLastName(request.getWifeSurname());
        wife.setPatronymic(request.getWifePatronymic());
        wife.setDateOfBirth(request.getWifeDateBirth());
        var wifePassport = new Passport();
        wifePassport.setPassportId(1l);
        wifePassport.setSerial(request.getWifePassportSerial());
        wifePassport.setNumber(request.getWifePassportNumber());
        wifePassport.setPerson(wife);
        wifePassport.setIssueDate(request.getWifePassportIssueDate());
        wifePassport.setIssueDepartment("Department Passport");
        var passportsWife = new ArrayList<Passport>();
        passportsWife.add(wifePassport);
        wife.setPassports(passportsWife);
        return wife;
    }
}
