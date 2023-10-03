package GestionUtilisateur.entities;

import java.sql.Date;

public class Student extends User{


    private String currentGradeLevel;
    private String major;
    //private String[] coursesEnrolled;
    //private String[] certifications;

    public Student() {
        this.setUserType("student");
    }

    public Student(String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, String currentGradeLevel, String major) {
        super(username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
        this.currentGradeLevel = currentGradeLevel;
        this.major = major;
    }

    public Student(int id, String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String gender, String address, int phoneNumber, String profilePicture, String userType, Date registrationDate, String currentGradeLevel, String major) {
        super(id, username, password, email, firstName, lastName, dateOfBirth, gender, address, phoneNumber, profilePicture, userType, registrationDate);
        this.currentGradeLevel = currentGradeLevel;
        this.major = major;
    }

    public String getCurrentGradeLevel() {
        return currentGradeLevel;
    }

    public void setCurrentGradeLevel(String currentGradeLevel) {
        this.currentGradeLevel = currentGradeLevel;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "currentGradeLevel='" + currentGradeLevel + '\'' +
                ", major='" + major + '\'' + super.toString()+
                '}';
    }
}
