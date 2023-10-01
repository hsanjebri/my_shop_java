/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_shop;

import model.Course;
import service.CourseService;
import utils.MyConnection;

import java.util.Arrays;
import java.util.Date;

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
        CourseService courseService =new CourseService();
        Course course = new Course(12345, "Java Programming", "Learn Java programming from scratch",
                49.99f, "java_course.jpg", true, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), Arrays.asList(courseContentArray));
        courseService.addCourse(course);
    }
    
}
