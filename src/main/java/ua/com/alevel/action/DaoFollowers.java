package ua.com.alevel.action;
import ua.com.alevel.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.dao.FollowersDao;
import ua.com.alevel.model.User;

import java.util.ArrayList;
import java.util.List;

import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;

public class DaoFollowers implements FollowersDao {
    private static SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();

    public List<User> findAllFollowers(User author) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int authorId = author.getId();
            Query<User> query = session.createQuery("SELECT youreadme FROM followers  WHERE id_followers =: authorId", User.class);
            List<User> followers = query.getResultList();
            session.getTransaction().commit();
            return followers;
        }
    }
}
