/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_shop;

import model.Course;
import model.Review;
import service.CourseService;
import utils.MyConnection;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import service.ReviewService;

/**
 *
 * @author hassa
 */
public class My_shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         MyConnection mc= new MyConnection();
         String str="2022-08-10";
         String str2="2022-06-10";
            // Create a list of course content
        String[] courseContentArray = {"Module 1", "Module 2", "Module 3"};  
        
         // Add a new course
        /*Course course = new Course(12345, "Java Programming", "Learn flutter programming from scratch",
                49.99f, "java_course.jpg", true, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), Arrays.asList(courseContentArray));
        courseService.addCourse(course);*/

        // Delete a course by ID
        // courseService.deleteCourse(2);
        /*updated 
        Course updatedCourse = new Course(
        3,
        "Updated Java Programming", // Updated title
        "Updated description", // Updated description
        59.99f, // Updated price
        "updated_java_course.jpg", // Updated image
        true,
        new Date(System.currentTimeMillis()), // Updated updatedAt
        new Date(System.currentTimeMillis()), // Updated createdAt
        Arrays.asList("Module 4", "Module 5") // Updated course content
    );
    courseService.updateCourse(updatedCourse);
      
       
       
    // Retrieve and display all courses
        /*List<Course> courses = courseService.getAllCourses();
        for (Course courseItem : courses) {
            System.out.println(courseItem);
        }*/
      
     // Find a course by ID
        /*long courseIdToFind = 1; // Replace with the desired course ID
        Course foundCourse = courseService.findById(courseIdToFind);
        if (foundCourse != null) {
            System.out.println("Found Course: " + foundCourse);
        } else {
            System.out.println("Course not found with ID: " + courseIdToFind);
        }*/
        
           // Update a course
        /*Course courseToUpdate = courseService.findById(3);
        if (courseToUpdate != null) {
            courseToUpdate.setDescription("Top-rated flutter course");
            courseService.updateCourse(courseToUpdate);
        }*/
         ReviewService reviewService = new ReviewService();

        // Test adding a review
       Review review = new Review(1, 12345, "John Doe", 5, "Great Course", "I learned a lot.", new Date(System.currentTimeMillis()));

    // Add the review to the database
   // reviewService.addReview(review);
          Review updatedReview = new Review(1, 12345, "John Doe", 4, "Updated Title", "This review has been updated.", new Date());

        // Call the updateReview method to update the review in the database
       // reviewService.updateReview(updatedReview);
        
        
        
    
}}
