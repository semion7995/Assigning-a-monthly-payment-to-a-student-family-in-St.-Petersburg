package edu.javacourse.city.web;

import edu.javacourse.PersonCheckDao;
import edu.javacourse.PoolConnectionBuilder;
import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;


@Path("/check")//path на который мы будем реагировать check - название нашего сервиса в рамках нашего приложения
@Singleton
public class CheckPersonService
{
    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);
    private PersonCheckDao dao;

    @PostConstruct
    public void init(){
        logger.info("SERVICE is Created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

//    @PreDestroy
//    public void destroy(){
//        logger.info("FINISH");
//    }


    @POST //я буду принимать параметр внутри тела http запроса
    @Consumes(MediaType.APPLICATION_JSON)//я потребляю json
    @Produces(MediaType.APPLICATION_JSON)//я возвращаю результат в виде json
    public PersonResponse checkPerson(PersonRequest request) throws PersonCheckException {
        logger.info(request.toString());
//        throw new PersonCheckException("EXCEPTION");
        return dao.checkPerson(request);//вернул true  с сервера
    }

//    @GET
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonRequest checkPersons(PersonRequest request){
//        PersonRequest pr = new PersonRequest();
//        pr.setSurName("Жуков");
//        pr.setGivenName("Семён");
//        pr.setPatronymic("Юрьевич");
//        pr.setDate_of_birth(LocalDate.of(1997, 3, 1));
//        pr.setStreetCode(612370);
//        pr.setExtension("");
//        pr.setBuilding("85");
//        pr.setApartment("1");
//        return pr;
//    }
}



//GET /edu.javacourse.dao.city-register-1.0/rest/check/101/ - PathParam
//?name=jol - QueryParam

//GET /edu.javacourse.dao.city-register-1.0/rest/check/101/simple ?name1=value1&name2=value2 - так называемые query параметры, которые передаются прямо в запросе
//GET /edu.javacourse.dao.city-register-1.0/rest/check/101?name = value - должны получить при компиляции
