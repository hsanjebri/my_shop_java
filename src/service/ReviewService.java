package service;

import model.Review;
import utils.MyConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private Connection cnx;

    public ReviewService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void addReview(Review review) {
        String query = "INSERT INTO review (courseId, reviewerName, rating, commentTitle, commentContent, createdAt) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setLong(1, review.getCourseId());
            pst.setString(2, review.getReviewerName());
            pst.setInt(3, review.getRating());
            pst.setString(4, review.getCommentTitle());
            pst.setString(5, review.getCommentContent());
            pst.setObject(6, review.getCreatedAt());
            pst.executeUpdate();
            System.out.println("Review added successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

   public void updateReview(Review review) {
    String query = "UPDATE review SET courseId=?, reviewerName=?, rating=?, commentTitle=?, commentContent=?, createdAt=? WHERE reviewId=?";
    try (PreparedStatement pst = cnx.prepareStatement(query)) {
        pst.setLong(1, review.getCourseId());
        pst.setString(2, review.getReviewerName());
        pst.setInt(3, review.getRating());
        pst.setString(4, review.getCommentTitle());
        pst.setString(5, review.getCommentContent());
        pst.setObject(6, review.getCreatedAt());
        pst.setLong(7, review.getReviewId());

        pst.executeUpdate();
        System.out.println("Review updated successfully");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}

    public void deleteReview(long reviewId) {
    String query = "DELETE FROM review WHERE reviewId=?";
    try (PreparedStatement pst = cnx.prepareStatement(query)) {
        pst.setLong(1, reviewId);
        pst.executeUpdate();
        System.out.println("Review deleted successfully");
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
}

    public List<Review> getAllReviewsForCourse(long courseId) {
        List<Review> reviewList = new ArrayList<>();
        String query = "SELECT * FROM review WHERE courseId=?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setLong(1, courseId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Review review = new Review(
                        rs.getLong("reviewId"),
                        rs.getLong("courseId"),
                        rs.getString("reviewerName"),
                        rs.getInt("rating"),
                        rs.getString("commentTitle"),
                        rs.getString("commentContent")
                );
                review.setCreatedAt(rs.getObject("createdAt", java.time.LocalDateTime.class));
                reviewList.add(review);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return reviewList;
    }
    
    public Review getReviewById(long reviewId) {
    String query = "SELECT * FROM review WHERE reviewId = ?";
    try (PreparedStatement pst = cnx.prepareStatement(query)) {
        pst.setLong(1, reviewId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Review review = new Review(
                rs.getLong("reviewId"),
                rs.getLong("courseId"),
                rs.getString("reviewerName"),
                rs.getInt("rating"),
                rs.getString("commentTitle"),
                rs.getString("commentContent"),
                rs.getDate("createdAt")
            );
            return review;
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }
    return null; // Return null if the review with the given reviewId is not found
}

}
