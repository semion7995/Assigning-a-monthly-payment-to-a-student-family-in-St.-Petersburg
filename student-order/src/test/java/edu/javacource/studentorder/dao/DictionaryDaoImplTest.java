package edu.javacource.studentorder.dao;
/**@BeforeClass выполняется один раз перед запуском всех тестов
 * @Before будет выполняться перед каждым методом
 * @After после каждоого метода
 * @AfterBefore после всех методов (тестов)
 */

import edu.javacource.studentorder.domain.CountryArea;
import edu.javacource.studentorder.domain.PassportOffice;
import edu.javacource.studentorder.domain.RegisterOffice;
import edu.javacource.studentorder.domain.Street;
import edu.javacource.studentorder.exception.DaoException;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest
{
    private static final Logger logger = LoggerFactory.getLogger(DictionaryDaoImplTest.class);

    @BeforeClass
    public static void startUp() throws Exception {
       DBInit.startUp();
    }

    @Test
    public void testStreet() throws DaoException {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now();
//        logger.isDebugEnabled();//проверяем уровень логирования и если он соответствует мы что-то печатаем если нет то мы сразу выходим
//        logger.isInfoEnabled();// проверяем что уровень логирования соотесьтвустет уровню и только тогда заходит в метод info
        //если метод без параметров то вызов метода это наносекунды
        logger.info("TEST {} {}", dt1, dt2);

        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(d.size() == 2);
    }


    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffice("010010000000");
        Assert.assertTrue(ro.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(ca1.size() == 2);

        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(ca2.size() == 2);

        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(ca3.size() == 2);

        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(ca4.size() == 2);
    }

}