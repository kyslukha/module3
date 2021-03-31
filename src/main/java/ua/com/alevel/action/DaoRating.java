package ua.com.alevel.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.dao.RatingDao;
import ua.com.alevel.model.Post;
import ua.com.alevel.model.Rating;
import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;
import java.util.List;

public class DaoRating implements RatingDao {
    private SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();
    public int updateRating(Post post, int vote) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int idPost = post.getId();
            int currentRating = post.getRating();
            Query<Rating> query = session.createQuery("SELECT * FROM rating WHERE idrating =: idPost", Rating.class);
            List<Rating> ratings = query.getResultList();
            int currentVotes = ratings.get(0).getVoters();
            int presentRating = (currentRating * currentVotes + vote) / (currentVotes + 1);
            int presentVotes = currentVotes++;
            Rating rating = new Rating();
            rating.setId(post);
            rating.setRating(presentRating);
            rating.setVoters(presentVotes);
            session.beginTransaction();
            session.update(rating);
            session.getTransaction().commit();
            return presentRating;
        }
    }
}


