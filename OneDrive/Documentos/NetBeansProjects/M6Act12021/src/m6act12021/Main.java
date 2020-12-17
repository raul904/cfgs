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
        System.out.println("3-Modificar alumne");
        System.out.println("5-Sortir");
           
        int Opcion;
        Opcion = sc.nextInt();
        switch(Opcion){
        
           case 1: introducirNom() ;
           break;
               
           case 2: esborrarAlumne();  
           break;
               
           case 3: modificarAlumne();
           break;
           
           case 4:afegirPoblacions();
           break;
               
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

    public static void modificarAlumne() throws SQLException {
        ResultSet resModificacio;
        String Nom;
        String DNI;
        String data;
        String adreçaPostal;
        String genero;
        String codiPostal;
        boolean mod;
        
        stmt = (Statement) con.createStatement();
        
        System.out.println("Digues el dni del alumne que vols modificar");
         DNI = sc.next();
        resModificacio = stmt.executeQuery("SELECT * FROM alumne WHERE Dni = '"+ DNI +"'");
        

        mod=resModificacio.next();
        String n,ap,s,cp;

        if(mod=true){
        
          n=resModificacio.getString(1);
          ap=resModificacio.getString(4);
          s=resModificacio.getString(5);
          cp=resModificacio.getString(6);
          
          
        try{
            
           sc.nextLine();
           System.out.println("Nom["+n+"]: ");
           Nom = sc.nextLine();
           if(!(Nom.length()==0)){
            stmt.executeUpdate("UPDATE alumne SET Nom = '"+ Nom + "'WHERE Dni='"+DNI+"';");
           }
           
           System.out.println("Adreça Postal["+ap+"]: ");
           adreçaPostal = sc.nextLine();
           if(!(adreçaPostal.length()==0)){
             stmt.executeUpdate("UPDATE alumne SET Adreça_Postal = '"+ adreçaPostal + "'WHERE Dni='"+DNI+"';");
           }
        
           System.out.println("Sexe["+s+"]: ");
            genero = sc.nextLine();
            if(!(genero.length()==0)){
                 stmt.executeUpdate("UPDATE alumne SET Sexe = '"+ genero + "'WHERE Dni='"+DNI+"';");
            }
           
//                     comprobar
            System.out.println("Codi Postal["+cp+"]: ");
            codiPostal = sc.nextLine();
            if(!(codiPostal.length()==0)){
            stmt.executeUpdate("UPDATE alumne SET Sexe = '"+ genero + "'WHERE Dni='"+DNI+"';");
            }
                //1
//            sc.nextLine();
//            System.out.println("Nom["+n+"]: ");
//            Nom = sc.nextLine();
//            if(!Nom.equalsIgnoreCase("")){
//                 stmt.executeUpdate("UPDATE alumne SET Nom = '"+ Nom + "'WHERE Dni='"+DNI+"';");
//            }
//            
//            sc.nextLine();
//            System.out.println("Adreça Postal["+ap+"]: ");
//            adreçaPostal = sc.next();
//            if(!adreçaPostal.equalsIgnoreCase("")){
//                 stmt.executeUpdate("UPDATE alumne SET Adreça_Postal = '"+ adreçaPostal + "'WHERE Dni='"+DNI+"';");
//            }
//           sc.nextLine();
//           
//            System.out.println("Sexe["+s+"]: ");
//            genero = sc.next();
//            if(!genero.equalsIgnoreCase("")){
//                 stmt.executeUpdate("UPDATE alumne SET Sexe = '"+ genero + "'WHERE Dni='"+DNI+"';");
//            }
            
            
            
//            ToDo CodiPostal
//            System.out.println("Codi Postal["+cp+"]: ");
//            codiPostal = sc.nextInt();
//            if(){}
//            stmt.executeUpdate("UPDATE alumne SET Sexe = '"+ genero + "'WHERE Dni='"+DNI+"';");
            
            
            
        
//            System.out.println("codiPostal["+cp+"]: ");
//            codiPostal = sc.nextInt();
//            int length = String.valueOf(number).length();
//            if(codiPostal.valueOf){
//                 stmt.executeUpdate("UPDATE alumne SET Codi_Postal = '"+ codiPostal + "'WHERE Dni='"+DNI+"';");
//            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
            
            }     
  
        
        
    
    }
    
      public static void afegirPoblacions() {
        
        }

   
       
}
