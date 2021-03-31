package ua.com.alevel.dao;

import ua.com.alevel.model.Post;

public interface RatingDao {
int updateRating(Post post, int vote);
}
