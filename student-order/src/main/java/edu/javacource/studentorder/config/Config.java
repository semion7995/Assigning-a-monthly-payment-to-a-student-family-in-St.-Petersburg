package edu.javacource.studentorder.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_LIMIT = "db.limit";

    private static Properties properties = new Properties();//частный случай мап


    public synchronized static String getProperty(String name){
        if (properties.isEmpty()){
            Config.class.getClassLoader().getResourceAsStream("dao.properties"); //мы хотим взять текущий поток байтов который находится в файле
            try (InputStream is = Config.class.getClassLoader().getResourceAsStream("dao.properties")){
                    properties.load(is);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);//при ошибке всё упадёт сразу

            }
        }
        return properties.getProperty(name);
    }
}
