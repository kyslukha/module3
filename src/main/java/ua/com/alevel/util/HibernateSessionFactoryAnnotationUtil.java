package ua.com.alevel.util;

import ua.com.alevel.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

 public class  HibernateSessionFactoryAnnotationUtil{
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryAnnotationUtil() {
        throw new UnsupportedOperationException();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Post.class);
                configuration.addAnnotatedClass(Followers.class);
                configuration.addAnnotatedClass(Rating.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception exc) {
                System.out.println("Error! " + exc);
            }
        }
        return sessionFactory;
    }
}