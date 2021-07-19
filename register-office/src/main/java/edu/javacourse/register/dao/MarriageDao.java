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
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MarriageDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(MarriageDao.class);
    private EntityManager entityManager;

    public MarriageCertificate findMarriageCertificate(MarriageRequest request){
        LOGGER.info("MarriageDao called");
        PersonMale husband = getHusband(request);
        PersonFemale wife = getWife(request);

        Query namedQuery = entityManager.createNamedQuery("MarriageCertificate.findMarriageCertificate");
        namedQuery.setParameter("husband", husband);
        namedQuery.setParameter("wife", wife);
        List<MarriageCertificate> mc = namedQuery.getResultList();
        return mc.size()!=0? mc.get(0):null;
    }

    private PersonMale getHusband(MarriageRequest request) {
        var husband = new PersonMale();
        husband.setFirstName(request.getHusbandGivenName());
        husband.setLastName(request.getHusbandSurname());
        husband.setPatronymic(request.getHusbandPatronymic());
        husband.setDateOfBirth(request.getHusbandDateBirth());
        var husbandPassport = new Passport();
        husbandPassport.setSerial(request.getHusbandPassportSerial());
        husbandPassport.setNumber(request.getHusbandPassportNumber());
        husbandPassport.setIssueDate(request.getHusbandPassportIssueDate());
        var passportsHusband = new ArrayList<Passport>();
        passportsHusband.add(husbandPassport);
        husband.setPassports(passportsHusband);
        return husband;
    }

    private PersonFemale getWife(MarriageRequest request) {
        var wife = new PersonFemale();
        wife.setFirstName(request.getWifeGivenName());
        wife.setLastName(request.getWifeSurname());
        wife.setPatronymic(request.getWifePatronymic());
        wife.setDateOfBirth(request.getWifeDateBirth());
        var wifePassport = new Passport();
        wifePassport.setSerial(request.getWifePassportSerial());
        wifePassport.setNumber(request.getWifePassportNumber());
        wifePassport.setIssueDate(request.getWifePassportIssueDate());
        var passportsWife = new ArrayList<Passport>();
        passportsWife.add(wifePassport);
        wife.setPassports(passportsWife);
        return wife;
    }
}
