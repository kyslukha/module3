package ua.com.alevel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="rating")
public class Rating implements Serializable {

    @Id

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idrating")
    private Post id;
    private int rating;
    private int voters;

    public Post getId() {
        return id;
    }

    public void setId(Post id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getVoters() {
        return voters;
    }

    public void setVoters(int voters) {
        this.voters = voters;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", voters=" + voters +
                '}';
    }
}
