package service;

import model.Course;
import utils.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseService {
    private Connection cnx;

    public CourseService() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void addCourse(Course course) {
        String query = "INSERT INTO course (title, description, price, image, isActive, updatedAt, createdAt, courseContent) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setString(1, course.getTitle());
            pst.setString(2, course.getDescription());
            pst.setFloat(3, course.getPrice());
            pst.setString(4, course.getImage());
            pst.setBoolean(5, course.isActive());
            pst.setObject(6, course.getUpdatedAt());
            pst.setObject(7, course.getCreatedAt());
            pst.setString(8, String.join(",", course.getCourseContent()));

            pst.executeUpdate();
            System.out.println("Course added successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void updateCourse(Course course) {
        String query = "UPDATE course SET title=?, description=?, price=?, image=?, isActive=?, updatedAt=?, courseContent=? WHERE courseId=?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setString(1, course.getTitle());
            pst.setString(2, course.getDescription());
            pst.setFloat(3, course.getPrice());
            pst.setString(4, course.getImage());
            pst.setBoolean(5, course.isActive());
            pst.setObject(6, course.getUpdatedAt());
            pst.setString(7, String.join(",", course.getCourseContent()));
            pst.setLong(8, course.getCourseId());

            pst.executeUpdate();
            System.out.println("Course updated successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void deleteCourse(long courseId) {
        String query = "DELETE FROM course WHERE courseId=?";
        try (PreparedStatement pst = cnx.prepareStatement(query)) {
            pst.setLong(1, courseId);
            pst.executeUpdate();
            System.out.println("Course deleted successfully");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM course";
        try (Statement st = cnx.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Course course = new Course(
                        rs.getLong("courseId"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getFloat("price"),
                        rs.getString("image"),
                        rs.getBoolean("isActive"),
                        rs.getDate("updatedAt"),
                        rs.getDate("createdAt"),
                        rs.getObject("courseContent",List.class)
                );
                course.setUpdatedAt(rs.getObject("updatedAt", java.util.Date.class));
                course.setCreatedAt(rs.getObject("createdAt", java.util.Date.class));
                String[] courseContentArray = rs.getString("courseContent").split(",");
                course.setCourseContent(Arrays.asList(courseContentArray));
                courseList.add(course);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return courseList;
    }
}

