/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUtilisateur.services;

import GestionUtilisateur.entities.Instructor;
import GestionUtilisateur.utilities.Myconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghanm
 */
public class InstructorService implements CrudInterface<Instructor> {

    private Connection cnx;
    private Statement st;
    private ResultSet rs;

    public InstructorService() {
        cnx = Myconnection.getInstance().getCnx();
    }

    @Override
    public void create(Instructor entity) {
        PreparedStatement pst;
        int n = 0;
        int generatedId = -1;

        try {

            pst = cnx.prepareStatement("INSERT INTO Instructor (username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate, yearsOfExperience, bio) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

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
            pst.setInt(13, entity.getYearsOfExperience());
            pst.setString(14, entity.getBio());

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
    public void update(Instructor entity) {
        PreparedStatement pst;
        int n = 0;

        try {
            pst = cnx.prepareStatement("UPDATE Instructor SET username=?, password=?, email=?, firstName=?, lastName=?, dateOfBirth=?, gender=?, address=?, phoneNumber=?, profilePicture=?, userType=?, registrationDate=?, yearsOfExperience=?, bio=? WHERE id=?");

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
            pst.setInt(13, entity.getYearsOfExperience());
            pst.setString(14, entity.getBio());
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

            st = cnx.prepareStatement("DELETE FROM `Instructor` WHERE `id`=?");

            st.setInt(1, id);

            n = st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Instructor getById(int id) {
        int n = 0;
        PreparedStatement st;
        Instructor instructor = new Instructor();
        try {

            st = cnx.prepareStatement("SELECT * FROM `Instructor` WHERE `id`=?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {

                instructor.setId(rs.getInt("id"));
                instructor.setUsername(rs.getString("username"));
                instructor.setAddress(rs.getString("address"));
                instructor.setPassword(rs.getString("password"));
                instructor.setEmail(rs.getString("email"));
                instructor.setFirstName(rs.getString("firstName"));
                instructor.setLastName(rs.getString("lastName"));
                instructor.setDateOfBirth(rs.getDate("dateOfBirth"));
                instructor.setGender(rs.getString("gender"));
                instructor.setPhoneNumber(rs.getInt("phoneNumber"));
                instructor.setProfilePicture(rs.getString("profilePicture"));
                instructor.setUserType(rs.getString("userType"));
                instructor.setRegistrationDate(rs.getDate("registrationDate"));
                instructor.setBio(rs.getString("bio"));
                instructor.setYearsOfExperience(rs.getInt("yearsOfExperience"));

            }
            cnx.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return instructor;
    }

    @Override
    public List<Instructor> getAll() {
        List<Instructor> instructorList = new ArrayList<>();
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("SELECT * FROM Instructor");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setId(rs.getInt("id"));
                instructor.setUsername(rs.getString("username"));
                instructor.setAddress(rs.getString("address"));
                instructor.setPassword(rs.getString("password"));
                instructor.setEmail(rs.getString("email"));
                instructor.setFirstName(rs.getString("firstName"));
                instructor.setLastName(rs.getString("lastName"));
                instructor.setDateOfBirth(rs.getDate("dateOfBirth"));
                instructor.setGender(rs.getString("gender"));
                instructor.setPhoneNumber(rs.getInt("phoneNumber"));
                instructor.setProfilePicture(rs.getString("profilePicture"));
                instructor.setUserType(rs.getString("userType"));
                instructor.setRegistrationDate(rs.getDate("registrationDate"));
                instructor.setBio(rs.getString("bio"));
                instructor.setYearsOfExperience(rs.getInt("yearsOfExperience"));
                instructorList.add(instructor);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return instructorList;
    }

}
