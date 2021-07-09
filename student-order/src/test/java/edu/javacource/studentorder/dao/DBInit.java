package edu.javacource.studentorder.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    public static void startUp() throws Exception {
        URL url1 = DictionaryDaoImplTest.class.getClassLoader().getResource("CreateTableDB.sql");
        URL url2 = DictionaryDaoImplTest.class.getClassLoader().getResource("INSERTstudent_data.sql");
        List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
        //получаем все строчки с нашего файлика
        List<String> str2 = Files.readAllLines(Paths.get(url2.toURI()));
        String sql2 = str2.stream().collect(Collectors.joining());
        String sql1 = str1.stream().collect(Collectors.joining());
        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement()){
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);
        }
    }
}
