package edu.javacourse.city.dao;

import edu.javacourse.city.web.CheckPersonServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolConnectionBuilder implements ConnectionBuilder{

    private static final Logger logger = LoggerFactory.getLogger(PoolConnectionBuilder.class);

    private DataSource dataSource;

    public PoolConnectionBuilder() {
        try {
            Context ctx = new InitialContext(); //чтобы воспользоваться именованным ресурсом который зарегистрирован на вашем сервере где-то
            // вы исп этот объект который умеет работать с этими ресурсами
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/cityRegister");//ищем ресурс <java:comp/env> префикс для TomCat
        }catch (NamingException e){
            logger.error("", e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
