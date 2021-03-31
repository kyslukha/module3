package ua.com.alevel.dao;

import ua.com.alevel.model.User;
import ua.com.alevel.model.Post;
import java.util.List;

public interface PostDao {
    List<Post> findAllPostsByAuthor(User author);

    List<Post> findTopPosts(int limit);

    List<Post> findTopAuthorsPosts(User author, int limit);
}
