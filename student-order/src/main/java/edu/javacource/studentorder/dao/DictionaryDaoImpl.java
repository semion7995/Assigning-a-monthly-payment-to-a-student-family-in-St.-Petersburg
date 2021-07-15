package edu.javacource.studentorder.dao;

import edu.javacource.studentorder.config.Config;
import edu.javacource.studentorder.domain.CountryArea;
import edu.javacource.studentorder.domain.PassportOffice;
import edu.javacource.studentorder.domain.RegisterOffice;
import edu.javacource.studentorder.domain.Street;
import edu.javacource.studentorder.exception.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao
{
    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImpl.class);
    private static final String GET_STREET = "select street_code, street_name from jc_street where upper(street_name) like upper(?) ";
    private static final String GET_PASSPORT = "select * from jc_passport_office where p_office_area_id = ?";
    private static final String GET_REGISTER = "select * from jc_register_office where r_office_area_id = ?";
    private static final String GET_AREA = "select * from jc_country_struct where area_id like ? and area_id <> ?";

    private Connection getConnection() throws SQLException {
        return ConnectionBuilder.getConnection();
    }

    @Override
    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();

//        String sql = "select street_code, street_name from jc_street where upper(street_name) like upper('%" + pattern + "%')";
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_STREET))
        {
            stmt.setString(1, "%" + pattern + "%");
        ResultSet rs = stmt.executeQuery();//получаем множество записей по которым можно двигаться
        while (rs.next()){
            Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
//         new Street(rs.getLong("street_code") , rs.getString("street_name"));идентичные записи
            result.add(str);
        }
        } catch (SQLException ex){
            logger.error(ex.getMessage(), ex);
            throw  new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<RegisterOffice> findRegisterOffice (String areaId) throws DaoException {
        List<RegisterOffice> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_REGISTER))
        {
            stmt.setString(1, areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                RegisterOffice ro = new RegisterOffice(rs.getLong(1), rs.getString(2), rs.getString(3));
                result.add(ro);
            }
        } catch (SQLException ex){
            logger.error(ex.getMessage(), ex);
            throw  new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoException {
        List<PassportOffice> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_PASSPORT))
        {
            stmt.setString(1, areaId );
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                PassportOffice po = new PassportOffice(rs.getLong(1), rs.getString(2), rs.getString(3));
                result.add(po);
            }
        } catch (SQLException ex){
            logger.error(ex.getMessage(), ex);
            throw  new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<CountryArea> findAreas(String areaId) throws DaoException {
        List<CountryArea> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_AREA))
        {
            String param1 = buildParam(areaId);
            String param2 = areaId;
            stmt.setString(1, param1 );
            stmt.setString(2, param2 );

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
              CountryArea ca = new CountryArea(rs.getString(1), rs.getString(2));
              result.add(ca);
            }
        } catch (SQLException ex){
            logger.error(ex.getMessage(), ex);
            throw  new DaoException(ex);
        }
        return result;
    }

    private String buildParam(String areaId) throws SQLException {
        if (areaId == null || areaId.trim().isEmpty()){
            return "__0000000000";
        }
        else if (areaId.endsWith("0000000000")){
           String result = areaId.substring(0, 2) + "___0000000";
           return result;
        }
        else if (areaId.endsWith("0000000")){
            return areaId.substring(0, 5) + "___0000";
        }
        else if (areaId.endsWith("0000")){
            return areaId.substring(0, 8) + "____";
        }
        throw new SQLException("Invalid parametr AreaId : " + areaId);
    }
}
