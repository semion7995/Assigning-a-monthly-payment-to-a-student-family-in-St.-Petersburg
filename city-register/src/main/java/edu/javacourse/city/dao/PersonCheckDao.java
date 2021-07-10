package edu.javacourse.city.dao;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCheckDao {
    private static final String SQL_REQUEST = "SELECT temporal from cr_address_person ap " +
            "INNER JOIN cr_person p ON p.person_id = ap.person_id" +
            "INNER JOIN cr_address a ON a.address_id = ap.address_id" +
            "WHERE " +
            "UPPER (p.sur_name) = UPPER (?) " +
            "AND UPPER (p.given_name) = UPPER (?) " +
            "AND UPPER (patronymic) = UPPER(?) " +
            "AND p.date_of_birth = ? " +
            "AND a.street_code = ?  " +
            "AND UPPER (a.building) = UPPER(?) " +
            "AND UPPER (extension) = UPPER(?) " +
            "AND UPPER (apartment) = UPPER(?);";

    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {
            PersonResponse response = new PersonResponse();

            try (Connection con = getConnection();){
                PreparedStatement stmt = con.prepareStatement(SQL_REQUEST);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()){
                    response.setRegister(true);
                    response.setTemporal(rs.getBoolean("temporal"));
                }
            }
            catch (SQLException ex){
                throw new PersonCheckException(ex);
            }

            return response;
        }

    private Connection getConnection() {
            return null;
    }
}
