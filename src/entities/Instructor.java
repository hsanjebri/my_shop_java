package GestionUtilisateur.entities;

import java.sql.Date;

public class Instructor extends User{
    //private String [] coursesTaught;
    //private String[] studentsEnrolled;
    // private String [] expertiseAreas;
    private int yearsOfExperience;
    private String  bio;
   // private Double [] ratings;

    public Instructor() {
        this.setUserType("instructor");
    }

    public Instructor(String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, String[] expertiseAreas, int yearsOfExperience, String bio, Double[] ratings) {
        super(username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
      //  this.expertiseAreas = expertiseAreas;
        this.yearsOfExperience = yearsOfExperience;
        this.bio = bio;
     //   this.ratings = ratings;
    }

    public Instructor(int id, String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, String[] expertiseAreas, int yearsOfExperience, String bio, Double[] ratings) {
        super(id, username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
     //   this.expertiseAreas = expertiseAreas;
        this.yearsOfExperience = yearsOfExperience;
        this.bio = bio;
    //    this.ratings = ratings;
    }

    /*public String[] getExpertiseAreas() {
        return expertiseAreas;
    }*/

   /* public void setExpertiseAreas(String[] expertiseAreas) {
        this.expertiseAreas = expertiseAreas;
    }*/

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

   /* public Double[] getRatings() {
        return ratings;
    }

    public void setRatings(Double[] ratings) {
        this.ratings = ratings;
    }*/

    @Override
    public String toString() {
        return "Instructor{" +
              //  "expertiseAreas=" Arrays.toString(expertiseAreas) +
                "yearsOfExperience=" + yearsOfExperience +
                ", bio='" + bio + '\'' +
                //", ratings=" + Arrays.toString(ratings) 
                 super.toString() +
                '}';
    }
}

