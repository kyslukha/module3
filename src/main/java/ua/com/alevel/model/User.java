package ua.com.alevel.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int id;


    @Column(name = "fullName")
    private String fullName;
    private String login;
    private String email;
    private int age;

    @Transient
    private List<User> subscriptions;
    @Column(name="author")
    private Boolean author = false;
    @Column(name = "moderator")
    private Boolean moderator = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<User> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<User> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Boolean getAuthor() {
        return author;
    }

    public void setAuthor(Boolean author) {
        this.author = author;
    }

    public Boolean getModerator() {
        return moderator;
    }

    public void setModerator(Boolean moderator) {
        this.moderator = moderator;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Transient
    private List<User> followers;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", subscriptions=" + subscriptions +
                ", author=" + author +
                ", moderator=" + moderator +
                ", followers=" + followers +
                '}';
    }
    public User(Integer id, String fullName, String Login, String email, Integer age, List<User> subscriptions, Boolean author, Boolean moderator, List<User> followers) {
        this.id = id;
        this.fullName= fullName;
        this.login = getLogin();
        this.age = age;
        this.subscriptions = subscriptions;
        this.author = author;
        this.moderator = moderator;
        this.followers= followers;
    }
}
