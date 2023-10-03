/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUtilisateur.services;

import GestionUtilisateur.entities.Student;
import GestionUtilisateur.utilities.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghanm
 */
public class StudentService implements CrudInterface<Student> {

    private Connection cnx;
    private Statement st;
    private ResultSet rs;

    public StudentService() {
        cnx = Myconnection.getInstance().getCnx();
    }

    @Override
    public void create(Student entity) {
        PreparedStatement pst;
        int n = 0;
        int generatedId = -1;
        try {

            pst = cnx.prepareStatement("INSERT INTO Student (username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate, currentGradeLevel, major) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, entity.getUsername());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getEmail());
            pst.setString(4, entity.getFirstName());
            pst.setString(5, entity.getLastName());
            pst.setDate(6, entity.getDateOfBirth());
            pst.setString(7, entity.getGender());
            pst.setString(8, entity.getAddress());
            pst.setInt(9, entity.getPhoneNumber());
            pst.setString(10, entity.getProfilePicture());
            pst.setString(11, entity.getUserType());
            pst.setDate(12, entity.getRegistrationDate());
            pst.setString(13, entity.getCurrentGradeLevel());
            pst.setString(14, entity.getMajor());

            n = pst.executeUpdate();

            if (n > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Get the generated ID
                }
                entity.setId(generatedId);
            }
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Student entity) {
        PreparedStatement pst;
        int n = 0;

        try {
            pst = cnx.prepareStatement("UPDATE Student SET username=?, password=?, email=?, firstName=?, lastName=?, dateOfBirth=?, gender=?, address=?, phoneNumber=?, profilePicture=?, userType=?, registrationDate=?, currentGradeLevel=?, major=? WHERE id=?");

            pst.setString(1, entity.getUsername());
            pst.setString(2, entity.getPassword());
            pst.setString(3, entity.getEmail());
            pst.setString(4, entity.getFirstName());
            pst.setString(5, entity.getLastName());
            pst.setDate(6, entity.getDateOfBirth());
            pst.setString(7, entity.getGender());
            pst.setString(8, entity.getAddress());
            pst.setInt(9, entity.getPhoneNumber());
            pst.setString(10, entity.getProfilePicture());
            pst.setString(11, entity.getUserType());
            pst.setDate(12, entity.getRegistrationDate());
            pst.setString(13, entity.getCurrentGradeLevel());
            pst.setString(14, entity.getMajor());
            pst.setInt(15, entity.getId()); // Set the ID for the WHERE clause

            n = pst.executeUpdate();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        int n = 0;
        PreparedStatement st;
        try {

            st = cnx.prepareStatement("DELETE FROM `Student` WHERE `id`=?");

            st.setInt(1, id);

            n = st.executeUpdate();

            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Student getById(int id) {
        int n = 0;
        PreparedStatement st;
        Student student = new Student();
        try {

            st = cnx.prepareStatement("SELECT * FROM `Student` WHERE `id`=?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {

                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setAddress(rs.getString("address"));
                student.setPassword(rs.getString("password"));
                student.setEmail(rs.getString("email"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setDateOfBirth(rs.getDate("dateOfBirth"));
                student.setGender(rs.getString("gender"));
                student.setPhoneNumber(rs.getInt("phoneNumber"));
                student.setProfilePicture(rs.getString("profilePicture"));
                student.setUserType(rs.getString("userType"));
                student.setRegistrationDate(rs.getDate("registrationDate"));
                student.setCurrentGradeLevel(rs.getString("currentGradeLevel"));
                student.setMajor(rs.getString("major"));

            }
            cnx.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("SELECT * FROM Student");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setUsername(rs.getString("username"));
                student.setAddress(rs.getString("address"));
                student.setPassword(rs.getString("password"));
                student.setEmail(rs.getString("email"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setDateOfBirth(rs.getDate("dateOfBirth"));
                student.setGender(rs.getString("gender"));
                student.setPhoneNumber(rs.getInt("phoneNumber"));
                student.setProfilePicture(rs.getString("profilePicture"));
                student.setUserType(rs.getString("userType"));
                student.setRegistrationDate(rs.getDate("registrationDate"));
                student.setCurrentGradeLevel(rs.getString("currentGradeLevel"));
                student.setMajor(rs.getString("major"));
                studentList.add(student);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return studentList;

    }

}
