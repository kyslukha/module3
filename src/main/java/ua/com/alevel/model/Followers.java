package ua.com.alevel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "followers")
public class Followers implements Serializable {


    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User id;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "youreadme")
    private User youReadMe;

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public User getYouReadMe() {
        return youReadMe;
    }

    public void setYouReadMe(User youReadMe) {
        this.youReadMe = youReadMe;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "id=" + id +
                ", youReadMe=" + youReadMe +
                '}';
    }
}
