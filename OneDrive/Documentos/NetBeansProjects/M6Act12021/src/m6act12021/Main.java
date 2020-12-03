/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6act12021;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;


/**
 *
 * @author Raul
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Statement stmt = null;
    static  Connection con = null;
    private static ResultSet res;
    public static void main(String[] args) throws SQLException {
      
        
//        Connection connection = null;
     
        String url = "jdbc:mysql://localhost:3306/alumnes";
        String usuari = "root";
        String password = "";
       
        
        try{
            
           Class.forName("com.mysql.jdbc.Driver");
           con = (Connection) DriverManager.getConnection(url, usuari, password);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        int chivato=0;
        while(chivato!=1){
        System.out.println("1-Introduir Alumne");
        System.out.println("2-Eliminar Alumne");
        System.out.println("5-Sortir");
           
        int Opcion;
        Opcion = sc.nextInt();
        switch(Opcion){
        
           case 1: introducirNom() ;
            
            break;
               
           case 2: esborrarAlumne();  
               
           case 5: chivato=1;
               break;
        
        }
        
        
        }
        
            
//            
//            
//            stmt = connection.createStatement();
//            stmt.execute("INSERT INTO EMPLOYEE (Nom) "
//                                + "VALUES ('Lokesh')");
//        } 
//        catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                stmt.close();
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    
    
    
    
    }
    
    public static void introducirNom() throws SQLException {
            System.out.println("Introdueix el nom");
		String Nom = sc.next();
            System.out.println("Introdueix el dni");
                String DNI = sc.next();
            System.out.println("Introdueix la data");
                String data = sc.next();
            System.out.println("Introdueix la adreça postal");
                String adreçaPostal = sc.next();
            System.out.println("Introdueix el codi postal");
                int codiPostal = sc.nextInt();
            System.out.println("Sexe home(H) o done(D)");
                String genero = sc.next();
    
                
            
            stmt = (Statement) con.createStatement();
	stmt.executeUpdate("INSERT INTO alumne(Nom,Dni,Data_De_Naixement,Adreça_Postal,Sexe,Codi_Postal)"+ 
                        "VALUES  ('"+Nom+"','"
                                   +DNI+"','"
                                   +data+"','"
                                   +adreçaPostal+"','"
                                   +genero+"','"
                                   +codiPostal+"')");
           
    }

    public static void esborrarAlumne() throws SQLException {
        System.out.println("Digues el dni del alumne que vols eliminar");
        
        String dni = sc.next();
        
        stmt = (Statement) con.createStatement();
        
        
        res = stmt.executeQuery("SELECT * FROM alumne WHERE Dni = '"+ dni +"'");
        
        //System.out.println(res.next());
     
        if(res.next()==true){
             stmt = (Statement) con.createStatement();
            stmt.execute("DELETE FROM alumne WHERE Dni = '"+ dni +"'");
        }

        
    }
	
}
