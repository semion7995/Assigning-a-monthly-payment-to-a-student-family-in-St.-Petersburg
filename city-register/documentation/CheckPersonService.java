ackage edu.javacourse.city.web;

import edu.javacourse.city.domain.PersonResponse;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/check")//path на который мы будем реагировать check - название нашего сервиса в рамках нашего приложения
public class CheckPersonService
{
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON) //когда я генерирую некий ответ я хочу из объекта который отдаю создать
    //PersonResponse в ответ прилетит в виде json чтобы преобразовывать в json или xml и обратно в объект lib by jersey-media-moxy
    public PersonResponse checkPerson(@PathParam("id") int simpleId, @QueryParam("name") String simpleName){
        PersonResponse pr = new PersonResponse();

        return pr;
    }
}



//GET /city-register-1.0/rest/check/101/ - PathParam
//?name=jol - QueryParam

//GET /city-register-1.0/rest/check/101/simple ?name1=value1&name2=value2 - так называемые query параметры, которые передаются прямо в запросе
//GET /city-register-1.0/rest/check/101?name = value - должны получить при компиляции
