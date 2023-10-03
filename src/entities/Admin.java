package GestionUtilisateur.entities;

import java.sql.Date;
import java.util.HashMap;

public class Admin extends User{

   // private HashMap <Integer,Boolean>reclamations ;

    public Admin() {
        this.setUserType("admin");
    }

    public Admin(String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, HashMap<Integer, Boolean> reclamations) {
        super(username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
       // this.reclamations = reclamations;
    }

    public Admin(int id, String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, HashMap<Integer, Boolean> reclamations) {
        super(id, username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
       // this.reclamations = reclamations;
    }

   /* public HashMap<Integer, Boolean> getReclamations() {
        return reclamations;
    }

    public void setReclamations(HashMap<Integer, Boolean> reclamations) {
        this.reclamations = reclamations;
    }*/

    @Override
    public String toString() {
        return "Admin{"
               /* + "reclamations=" + reclamations */ + super.toString()+
                '}';
    }
}
