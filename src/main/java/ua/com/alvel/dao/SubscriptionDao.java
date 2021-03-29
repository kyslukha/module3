package ua.com.alvel.dao;


import lecture30.module.model.User;

import java.util.List;

public interface SubscriptionsDao {
    List<User> findAllSubscriptions(User subscriber);
}