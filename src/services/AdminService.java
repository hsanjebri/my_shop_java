package GestionUtilisateur.services;

import GestionUtilisateur.entities.Admin;
import GestionUtilisateur.utilities.Myconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminService implements CrudInterface<Admin> {

    private Connection cnx;
    private Statement st;
    private ResultSet rs;

    public AdminService() {
        cnx = Myconnection.getInstance().getCnx();
    }

    @Override
    public void create(Admin entity) {
        PreparedStatement pst;
        int n = 0;
        int generatedId = -1;

        try {

            pst = cnx.prepareStatement("INSERT INTO Admin (username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

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

            n = pst.executeUpdate();
            if (n > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getInt(1); // Get the generated ID
                }
            }
            pst.close();
            entity.setId(generatedId);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Admin entity) {
        PreparedStatement pst;
        int n = 0;

        try {
            pst = cnx.prepareStatement("UPDATE Admin SET username=?, password=?, email=?, firstName=?, lastName=?, dateOfBirth=?, gender=?, address=?, phoneNumber=?, profilePicture=?, userType=?, registrationDate=? WHERE id=?");

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
            pst.setInt(13, entity.getId()); // Set the ID for the WHERE clause

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

            st = cnx.prepareStatement("DELETE FROM `Admin` WHERE `id`=?");

            st.setInt(1, id);

            n = st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Admin getById(int id) {

        PreparedStatement st;
        Admin admin = new Admin();
        try {

            st = cnx.prepareStatement("SELECT * FROM `Admin` WHERE `id`=?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()) {

                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setAddress(rs.getString("address"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setFirstName(rs.getString("firstName"));
                admin.setLastName(rs.getString("lastName"));
                admin.setDateOfBirth(rs.getDate("dateOfBirth"));
                admin.setGender(rs.getString("gender"));
                admin.setPhoneNumber(rs.getInt("phoneNumber"));
                admin.setProfilePicture(rs.getString("profilePicture"));
                admin.setUserType(rs.getString("userType"));
                admin.setRegistrationDate(rs.getDate("registrationDate"));

            }
           
        } catch (Exception e) {
            System.out.println(e);
        }
        return admin;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> adminList = new ArrayList<>();
        PreparedStatement st;

        try {
            st = cnx.prepareStatement("SELECT * FROM Admin");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setUsername(rs.getString("username"));
                admin.setAddress(rs.getString("address"));
                admin.setPassword(rs.getString("password"));
                admin.setEmail(rs.getString("email"));
                admin.setFirstName(rs.getString("firstName"));
                admin.setLastName(rs.getString("lastName"));
                admin.setDateOfBirth(rs.getDate("dateOfBirth"));
                admin.setGender(rs.getString("gender"));
                admin.setPhoneNumber(rs.getInt("phoneNumber"));
                admin.setProfilePicture(rs.getString("profilePicture"));
                admin.setUserType(rs.getString("userType"));
                admin.setRegistrationDate(rs.getDate("registrationDate"));
                adminList.add(admin);
            }

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return adminList;
    }
}
