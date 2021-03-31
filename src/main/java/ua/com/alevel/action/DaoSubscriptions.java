package ua.com.alevel.action;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.model.User;
import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;
import ua.com.alevel.action.*;

import java.util.List;

import ua.com.alevel.dao.SubscriptionsDao;

import java.util.ArrayList;

public class DaoSubscriptions implements SubscriptionsDao {
    private static SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();

    public List<User> findAllSubscriptions(User subscriber){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int yourReadme= subscriber.getId();
            Query<Integer> query = session.createQuery("SELECT youreadme FROM followers  WHERE id_followers =: yourReadme");
            List<User> subscribers = new ArrayList<>();
            for (int subscr : query.getResultList()) {
                User user = DaoUser.findById(subscr);
                subscribers.add(user);
            }
            session.getTransaction().commit();
            return subscribers;
        }
    }
}
