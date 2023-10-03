package GestionUtilisateur.test;

import GestionUtilisateur.entities.Instructor;
import GestionUtilisateur.entities.Student;
import GestionUtilisateur.entities.Admin;
import GestionUtilisateur.services.AdminService;
import GestionUtilisateur.services.InstructorService;
import GestionUtilisateur.services.StudentService;
import GestionUtilisateur.utilities.Myconnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Myconnection myconnection = Myconnection.getInstance();

        Student student = new Student();
        student.setUsername("yyyyy");
        Date currentDate = new Date(System.currentTimeMillis());

        student.setRegistrationDate(currentDate);
        student.setProfilePicture("yyypic");
        student.setPhoneNumber(1111110);
        student.setPassword("4444");
        student.setMajor("CS");
        student.setLastName("yyyyy");
        student.setFirstName("Med xx");
        student.setEmail("mxxxi@esprit.tn");
        student.setDateOfBirth(currentDate);
        student.setCurrentGradeLevel("4th");
        student.setAddress("Tunis");
        student.setGender("male");

        StudentService ss = new StudentService();

        //ss.create(student);
        System.out.println("Student created successfully.");

        Instructor instructor = new Instructor();
        instructor.setUsername("prof22");

        instructor.setRegistrationDate(currentDate);
        instructor.setProfilePicture("pro22");
        instructor.setPhoneNumber(22222);
        instructor.setPassword("22222");
        instructor.setBio("bioo222");
        instructor.setLastName("nomprof22");
        instructor.setFirstName("prenomprof22");
        instructor.setEmail("mail222@esprit.tn");
        instructor.setDateOfBirth(currentDate);
        instructor.setYearsOfExperience(2);
        instructor.setAddress("Tunis");
        instructor.setGender("male");

        InstructorService is = new InstructorService();

       // is.create(instructor);
        System.out.println("Instructor created successfully.");

        Admin admin = new Admin();
        admin.setUsername("editedAdmin");

        admin.setRegistrationDate(currentDate);
        admin.setProfilePicture("adminpic2");
        admin.setPhoneNumber(222222);
        admin.setPassword("222222");
        admin.setLastName("yyyy");
        admin.setFirstName("xxxx");
        admin.setEmail("admin22@esprit.tn");
        admin.setDateOfBirth(currentDate);
        admin.setAddress("Tunis");
        admin.setGender("male");
        //admin.setId(8);

        AdminService as = new AdminService();

        //as.create(admin);

        /* System.out.println("Admin created successfully.");
        System.out.println("Admin id :" + admin.getId());
        System.out.println("student id :" + student.getId());
        System.out.println("instructor id :" + instructor.getId());*/

 /* is.delete(2);
       as.delete(7);
       ss.delete(2);*/
        // System.out.println(is.getById(3).toString());
        // System.out.println(as.getById(8).toString());
        //System.out.println(ss.getById(3).toString());
        /*List<Admin> adminList = new ArrayList<>();
         adminList =as.getAll();

        for (Admin admin2 : adminList) {
            System.out.println(admin2);
        }*/
 /*  List<Student> studentList = new ArrayList<>();
         studentList =ss.getAll();

        for (Student student2 : studentList) {
            System.out.println(student2);
        }*/
 
        /*List<Instructor> instructortList = new ArrayList<>();
        instructortList = is.getAll();

        for (Instructor instructor2 : instructortList) {
            System.out.println(instructor2);
        }*/
        
      // as.update(admin);
    }
}
