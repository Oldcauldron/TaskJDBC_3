package jm.task.core.jdbc.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String DATABASE = "userbase";
    private static final String NAME = "root";
    private static final String PASS = "port40";

    public static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConnection() throws SQLException {

        registerDriver();
        String connectionUrl = "jdbc:mysql://localhost:3306/" +
                DATABASE + "?" +
                "allowPublicKeyRetrieval=true&" +
                "useSSL=false&" +
                "useUnicode=true&" +
                "characterEncoding=UTF-8&" +
                "zeroDateTimeBehavior=CONVERT_TO_NULL&" +
                "serverTimezone=GMT";
        return DriverManager.getConnection(connectionUrl, NAME, PASS);

    }

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();

                properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/testbase?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT");
                properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
                properties.setProperty("hibernate.connection.username", "root");
                properties.setProperty("hibernate.connection.password", "port40");
                properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
                properties.setProperty("show_sql", "true");

                SessionFactory sessionFactory = new Configuration().addProperties(properties).buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Exception from getSessionFactory()" + e);
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
