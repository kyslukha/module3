package ua.com.alvel.model;

import java.util.List;

public class User {

    //уникальный идентификатор
    private int id;
    private String fullName;
    //должен быть уникальным, не null
    private String login;
    //должен быть уникальным и содержать символ '@'
    private String email;
    //не меньше 18
    private int age;
    //подписки
    private List<User> subscriptions;
    //является ли данный пользователь автором (у пользователя должно быть 1 или более публикаций)
    private Boolean isAuthor;
    //может ли пользователь модерировать статьи
    private Boolean isModerator;
    //0 если пользователь не "автор"
    private List<User> followers;

    public Integer getUserId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getLogin(){return login;
    }
    public String getEmail() {
        return email;
    }

    public Boolean getAuthor() {
        return isAuthor;
    }

    public Boolean getModerator() {
        return isModerator;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public User(Integer id, String fullName, String login, Integer age, String email) {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.age = age;
        this.email = email;
    }


}
