package model;


import java.util.Date;
import java.util.List;

public class Course {
    private long courseId;
    private String title;
    private String description;
    private float price;
    private String image;
    private boolean isActive;
    private Date updatedAt;
    private Date createdAt;
    private List<String> courseContent;

    public Course(long courseId, String title, String description, float price, String image, boolean isActive, Date updateAt,Date createdAt, List<String> curseContent) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.isActive = isActive;
        this.updatedAt = updateAt;
        this.createdAt = createdAt;
        this.courseContent = curseContent;
    }

 

    // Getters and Setters for all fields

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<String> getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(List<String> courseContent) {
        this.courseContent = courseContent;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", isActive=" + isActive +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", courseContent=" + courseContent +
                '}';
    }
}
