package ua.com.alevel.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;
import java.util.List;
import ua.com.alevel.action.DaoUser;
import org.hibernate.query.Query;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.model.User;
import ua.com.alevel.util.*;
import java.util.*;

public class DaoAuthor implements AuthorDao {
    private static SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();


   public  List<User> findAllAuthors() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<User> query = session.createQuery("  FROM  user WHERE isAuthor=true ", User.class);
            List<User> authors = query.getResultList();
            session.getTransaction().commit();
            return authors;
        }

    }

    public List<User> findTopAuthors(int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Integer> query = session.createQuery("SELECT author  FROM  post GROUP BY author ORDER BY COUNT(idpost) DESC");
            List<User> topAuthors = new ArrayList<>();
            int i =0;
            for (int authors : query.getResultList()) {
              if (i<limit) {
                  i++;
                  User user = DaoUser.findById(authors);
                    topAuthors.add(user);
                }
            }
            session.getTransaction().commit();
            return topAuthors;
        }
    }

}

