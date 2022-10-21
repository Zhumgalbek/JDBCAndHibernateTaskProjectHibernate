package peaksoft.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class UtilHibernate {

    public static EntityManagerFactory createEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("persistence");
    }
    public static SessionFactory createSessionFactory() {
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/figma.com");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "1234");


        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put(Environment.SHOW_SQL, "true");


        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(User.class);

        return configuration.buildSessionFactory();

    }
}
