package model;
import java.time.LocalDateTime;

public class Review {
    private long reviewId;
    private long courseId; // To associate the review with a specific course
    private String reviewerName;
    private int rating; // Rating out of 5 or 10
    private String commentTitle;
    private String commentContent;
    private LocalDateTime createdAt;

    public Review(long reviewId, long courseId, String reviewerName, int rating, String commentTitle, String commentContent) {
        this.reviewId = reviewId;
        this.courseId = courseId;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.commentTitle = commentTitle;
        this.commentContent = commentContent;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters for all fields

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", courseId=" + courseId +
                ", reviewerName='" + reviewerName + '\'' +
                ", rating=" + rating +
                ", commentTitle='" + commentTitle + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
