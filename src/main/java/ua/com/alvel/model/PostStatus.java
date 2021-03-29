package ua.com.alvel.model;

public enum PostStatus {
    //опубликованн
    STATUS_PUBL ("published"),
    //создан, но еще не был на проверке
    STATUS_DRFT ("draft"),
    //возвращен на доработку после модерации
    STATUS_WRSHT ("worksheet"),
    //на модерации
    STATUS_INPRG ("in progress");

    private String postStatus;

    PostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public static PostStatus getActionName(String name) {
        PostStatus status= null;
        for (PostStatus postStatus: PostStatus.values()) {
            if (postStatus.getPostStatus().equals(name)) {
                 status= postStatus;
            }
        }
        return status;
    }

    @Override
    public String toString() {
        return postStatus;
    }
    }

}