package ua.com.alevel.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.dao.Dao;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;

import java.util.List;

public class DaoUser  {
    private static SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();

    public static User create(User model) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
            return model;
        }
    }

    public static User update(User model) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(model);
            session.getTransaction().commit();
            return model;
        }
    }

    public static  User findById(int id) {

        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("SELECT *  FROM  user WHERE iduser =: id");
            User user = query.list().get(0);
            session.getTransaction().commit();
            return user;
        }
    }

    public static List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("SELECT * FROM user", User.class);
            List<User> user = query.getResultList();
            session.getTransaction().commit();
            return user;
        }
    }
    public  static List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("  FROM  User ", User.class);
            List<User> resultList = query.getResultList();
            session.getTransaction().commit();
            return resultList;
        }
    }


    public static void showUser() {
        List<User> categoryList = getAllUsers();
        for (User user : categoryList) {
            System.out.println("\n" + user + "\n");
        }
    }



    public boolean deleteById(int id) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            boolean flag = false;
            session.beginTransaction();
            if (equals(findById(id))) {
                Query query = session.createQuery("DELETE FROM user  WHERE iduser =: id");
                flag = true;
                session.getTransaction().commit();
            }
            session.getTransaction().commit();
            return flag;
        }
    }
}
