package edu.javacourse;

import edu.javacourse.city.domain.PersonRequest;
import edu.javacourse.city.domain.PersonResponse;
import edu.javacourse.city.exception.PersonCheckException;

import java.sql.*;

public class PersonCheckDao {

    private static final String SQL_REQUEST = "SELECT temporal from cr_address_person ap " +
            "INNER JOIN cr_person p ON p.person_id = ap.person_id " +
            "INNER JOIN cr_address a ON a.address_id = ap.address_id " +
            "WHERE " +
            "CURRENT_DATE >= ap.start_date AND (CURRENT_DATE <= ap.end_date or ap.end_date is null) " +
            "AND UPPER (p.sur_name) = UPPER (?) " +
            "AND UPPER(p.given_name) = UPPER (?) " +
            "AND UPPER(p.patronymic) = UPPER (?) " +
            "AND p.date_of_birth = ? " +
            "AND a.street_code = ?  " +
            "AND UPPER(a.building) = UPPER (?) " ;

    private edu.javacourse.ConnectionBuilder connectionBuilder;

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private Connection getConnection() throws SQLException {
//            return DriverManager.getConnection("jdbc:postgresql://localhost/city_register", "postgres", "2134");
        return connectionBuilder.getConnection();
    }
    //    public PersonCheckDao() {
//        try {
//         Class.forName("org.postgresql.Driver"); //зарание загружаю драйвер, чтобы эта штуковина работала на сервере
//        } catch (Exception e) { //причины почему на сервере без этого не работает пока не знаю
//            e.printStackTrace();
//        }

//        }
    //8 параметров

    public PersonResponse checkPerson (PersonRequest request) throws PersonCheckException {
            PersonResponse response = new PersonResponse();
            String sql = SQL_REQUEST;
            if (request.getExtension()!= null){                          //обрабатываю частный случай отсутствия корпуса или квартиры
                sql += "AND UPPER (a.extension) = UPPER (?) ";           //чтобы при сравнении не вернулся отрицательный ответ на запрос при отсутствии
            }                                                            //корпуса или квартиры и не выбросилась ошибка
            else {
                sql+= "and a.extension is null ";
            }
            if (request.getApartment() != null){
                sql+="AND UPPER (a.apartment) = UPPER (?) ";
            }
            else {
                sql+= "and a.apartment is null ";
            }
            try (Connection con = getConnection()){
                PreparedStatement stmt = con.prepareStatement(sql);
                int count = 1;
                    stmt.setString(count++, request.getSurName());
                    stmt.setString(count++, request.getGivenName());
                    stmt.setString(count++, request.getPatronymic());
                    stmt.setDate(count++, java.sql.Date.valueOf(request.getDate_of_birth()));
                    stmt.setInt(count++, request.getStreetCode());
                    stmt.setString(count++,request.getBuilding());
                    if (request.getExtension() != null){                                   //обрабатываюситуацию с отсутствием корпуса или квартиры
                        stmt.setString(count++, request.getExtension());
                    }
                    if (request.getApartment() != null)
                    stmt.setString(count++, request.getApartment());

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
}
