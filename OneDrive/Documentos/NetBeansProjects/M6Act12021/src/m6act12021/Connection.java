/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6act12021;


import java.sql.Driver;
import java.sql.DriverManager;

import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Raul
 */
public class Connection {
        public static void main(String[] args) {
    Connection connection = null; 
    Statement stmt = null;
    
    try{
  

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/accions",
                "root", "");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/accions","root","password");
        
    }catch(Exception e){
        System.out.println("No conecta");
    }
        }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
