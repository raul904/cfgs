/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6act12021;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 *
 * @author Raul
 */
public class M6Act12021 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
    Connection con=null;
    Driver driver = null;
    Statement stmt = null;
    
    String url = "jdbc:mysql://localhost:3306/accions";
    String usuari = "root";
    String password = "";
    
    System.out.println("provaDeconnexio()");
    
    try{

        Class.forName("com.mysql.jdbc.Driver");

        }
    catch(ClassNotFoundException ex){
         System.out.println("No s'ha trobat el controlador JDBC ("+ ex.getMessage()+")");

         return;
        }
    
    try{
        con = DriverManager.getConnection(url, usuari, password);
        System.out.println("Connexio realitzada usant DriverManager");
        con.close();
        
        }
    catch(SQLException ex){
        System.out.println("Error "+ ex.getMessage());
    }
    
    
    try{
        driver = DriverManager.getDriver(url);
        
        Properties properties = new Properties();
        properties.setProperty("user",usuari);
        properties.setProperty("password",password);
        
        con = driver.connect(url,properties);
        System.out.println("Conexió realitzada usant Driver");
        con.close();
    }
    catch(SQLException ex){
        System.out.println("Error "+ ex.getMessage());
    }
    
}
}