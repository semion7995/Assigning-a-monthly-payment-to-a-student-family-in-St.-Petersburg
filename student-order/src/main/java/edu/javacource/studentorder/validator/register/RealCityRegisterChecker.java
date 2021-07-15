package edu.javacource.studentorder.validator.register;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import edu.javacource.studentorder.config.Config;
import edu.javacource.studentorder.domain.register.CityRegisterRequest;
import edu.javacource.studentorder.domain.register.CityRegisterResponse;
import edu.javacource.studentorder.domain.Person;
import edu.javacource.studentorder.exception.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person)throws CityRegisterException {
        try {
            CityRegisterRequest request = new CityRegisterRequest(person);
            System.out.println(request);

            Client client = ClientBuilder.newClient();
            CityRegisterResponse response = client.target(
                    Config.getProperty(Config.CR_URL))
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(request, MediaType.APPLICATION_JSON))
                    .readEntity(CityRegisterResponse.class);
            return response;
        } catch (Exception ex){
            throw new CityRegisterException("1", ex.getMessage(), ex );
        }
    }
}
