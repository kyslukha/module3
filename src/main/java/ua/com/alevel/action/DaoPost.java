package ua.com.alevel.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ua.com.alevel.dao.Dao;
import ua.com.alevel.dao.PostDao;
import ua.com.alevel.model.Post;
import ua.com.alevel.model.User;

import java.util.ArrayList;
import java.util.List;

import ua.com.alevel.util.HibernateSessionFactoryAnnotationUtil;

public class DaoPost implements PostDao, Dao<Post> {
    private SessionFactory sessionFactory = HibernateSessionFactoryAnnotationUtil.getSessionFactory();

    public Post create(Post model) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(model);
            session.getTransaction().commit();
            return model;
        }

    }

    public Post update(Post model) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(model);
            session.getTransaction().commit();
            return model;
        }
    }

    public Post findById(int id) {

        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Post> query = session.createQuery("SELECT *  FROM  post WHERE idpost =: id", Post.class);
            Post post = query.list().get(0);
            session.getTransaction().commit();
            return post;
        }
    }

    public List<Post> findAll() {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Post> query = session.createQuery("SELECT * FROM post", Post.class);
            List<Post> post = query.getResultList();
            session.getTransaction().commit();
            return post;
        }
    }

    public boolean deleteById(int id) {

        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            boolean flag = false;
            if (!findById(id).getTitle().isEmpty()) {
                Query query = session.createQuery("DELETE FROM post  WHERE idpost =: id");
                flag = true;
            }

            session.getTransaction().commit();
            return flag;
        }
    }

    public List<Post> findAllPostsByAuthor(Post author) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            int authorId = author.getId();
            Query<Post> query = session.createQuery("SELECT * FROM post  WHERE author =: authorId", Post.class);
            List<Post> authors = query.getResultList();
            session.getTransaction().commit();
            return authors;
        }
    }


    @Override
    public List<Post> findAllPostsByAuthor(User author) {
        return null;
    }

    public List<Post> findTopPosts(int limit) {
        try (org.hibernate.Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query<Post> query = session.createQuery("SELECT *  FROM  post GROUP BY author ORDER BY rating DESC", Post.class);
            List<Post> topPosts = new ArrayList<>();

            for (Post post : query.getResultList()) {
                for (int i = 0; i < limit; i++) {

                    topPosts.add(post);
                }
            }

            session.getTransaction().commit();
            return topPosts;
        }
    }

    @Override
    public List<Post> findTopAuthorsPosts(User author, int limit) {
        return null;
    }


    public List<Post> findTopAuthorsPosts(Post author, int limit) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            int authorId = author.getId();
            Query<Post> query = session.createQuery("SELECT *  FROM  post GROUP BY author =: authorId ORDER BY rating DESC", Post.class);
            List<Post> topAuthorPosts = new ArrayList<>();
            int i = 0;
            for (Post post : query.getResultList()) {
                if (i < limit) {
                    i++;
                    topAuthorPosts.add(post);
                }
            }
            System.out.println("This user is not author");
            return topAuthorPosts;
        }
    }
}
