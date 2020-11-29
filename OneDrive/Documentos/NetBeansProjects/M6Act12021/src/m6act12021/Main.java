/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6act12021;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Raul
 */
public class Main {
    public static void main(String[] args) {
     Connection connection = null;
        Statement stmt = null;
        String url = "jdbc:mysql://localhost:3306/accions";
        String usuari = "root";
        String password = "";
        try
        {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url, usuari, password);
            
            
//                try{
//        con = DriverManager.getConnection(url, usuari, password);
//        System.out.println("Connexio realitzada usant DriverManager");
//        con.close();
  
//        }
//    catch(SQLException ex){
//        System.out.println("Error "+ ex.getMessage());
    
    
            
            
            
            stmt = connection.createStatement();
            stmt.execute("INSERT INTO EMPLOYEE (Nom) "
                                + "VALUES ('Lokesh')");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                stmt.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    
    
    
    }
}
