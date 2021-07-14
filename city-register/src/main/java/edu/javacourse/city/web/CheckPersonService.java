package edu.javacourse.city.web;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/check")//path на который мы будем реагировать check - название нашего сервиса в рамках нашего приложения
public class CheckPersonService
{
    @POST //я буду принимать параметр внутри тела http запроса
    @Consumes(MediaType.APPLICATION_JSON)//я потребляю json
    @Produces(MediaType.APPLICATION_JSON)//я возвращаю результат в виде json
    public PersonResponse checkPerson(PersonRequest request){
//        System.out.println(request.toString());

        return new PersonResponse();
    }
}



//GET /city-register-1.0/rest/check/101/ - PathParam
//?name=jol - QueryParam

//GET /city-register-1.0/rest/check/101/simple ?name1=value1&name2=value2 - так называемые query параметры, которые передаются прямо в запросе
//GET /city-register-1.0/rest/check/101?name = value - должны получить при компиляции
