package ua.com.alvel.dao;

import lecture30.module.model.Post;
import lecture30.module.model.User;

import java.util.List;

public interface PostDao {
    List<Post> findAllPostsByAuthor(User author);

    List<Post> findTopPosts(int limit);

    List<Post> findTopAuthorsPosts(User author, int limit);
}
