package ua.com.alvel.model;

public class Post {
    //уникальный идентификатор
    private int id;
    //максимальная длина 100 символов
    private String title;
    //максимальная длина 1000 символов
    private String content;
    //автор сатьи
    private User author;
    //модератор (тот кто апрувит статью)
    private User moderator;
    //рейтинг статьи, может быть как отрицательный так и положительный
    private int rating;
    //статус
    private PostStatus status;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public User getModerator() {
        return moderator;
    }

    public int getRating() {
        return rating;
    }

    public PostStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title+ '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", moderator='" + moderator + '\'' +
                ", rating='" + rating + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}