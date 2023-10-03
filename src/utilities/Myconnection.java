package GestionUtilisateur.utilities;

import java.sql.*;

public class Myconnection {
    private String url = "jdbc:mysql://localhost:3306/CoursifyDB";
    private String login = "root";
    private String password ="";

    Connection cnx;
    private static Myconnection instance;

    private Myconnection(){
    try {
        cnx = DriverManager.getConnection(url, login, password);
        System.out.println("Connected to DB ! ");
    }
    catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    }

    public Connection getCnx(){
        return cnx ;
    }
    public static Myconnection getInstance() {

        if (instance == null){
            instance = new Myconnection();
        }
        return instance;
    }




}
