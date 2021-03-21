/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6uf3;

/**
 *
 * @author Raul
 */
public class M6UF3 {

    /**
     * @param args the command line arguments
     */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import org.xmlb.api.*;

import java.util.Scanner;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;

/**
 *
 * @author Alumne
 */
public class Activitat3 {
       public static Scanner scan = new Scanner(System.in);
       
        static Collection col = null;
        static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db/";
        
        static  String usu = "admin";
        
        static String usuPass = "alumne";
    
      
       public static void main (String[] args) throws XMLDBException{
    
        
        String driver = "org.exist.xmldb.DatabaseImpl";
        Collection col = null;
        
        
        
        try {
        Class cl = Class.forName(driver);
        
        Database database = (Database) cl.newInstance();
        
        DatabaseManager.registerDatabase(database);
        
        }catch(Exception e){
            System.out.println("Error en inicializar la base de dades eXist");
            e.printStackTrace();
        
        }
        
        
        int opcio;
         System.out.println("Menu:");
        System.out.println("1-Inserir departament");
        System.out.println("2-Esborrar departament amb el seu numero");
         System.out.println("3-Modificar departament amb el seu numero");
        opcio = scan.nextInt();
        switch(opcio){
            case 1 :insereixdep();
                break;
            case 2:esborradep();
                break;
            case 3:modificardep();
                break;
                
        }
        
        

    }

    public static void insereixdep() throws XMLDBException {
        Collection col = null;
        int depNum;
        String dNombre;
        String loc;
     
        
        System.out.println("Introdueix el nou numero del departament");
        depNum = scan.nextInt();
        
        System.out.println("Introdueix el nom de departament");
        dNombre = scan.next();
        
        System.out.println("Introdueix la localització");
        loc = scan.next();
                  
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if(col==null){        
        System.out.println("***LA COLLECIO NO EXITEIX***");
        }
        //departament num , nom, localitat, 
        
        
        XPathQueryService servei = (XPathQueryService)col.getService("XPathQueryService", "1.0");
      
        
         ResourceSet result2 = 
         servei.query( " for $em in /departamentos/DEP_ROW[DEPT_NO = "+depNum+"] return $em");
         ResourceIterator i;
            i = result2.getIterator();
            if(i.hasMoreResources()){
                       System.out.println("Existeix");
      
            
            }else{
                 System.out.println("LA CONSULTA NO TORNA RES");
                
                 ResourceSet result = 
                    servei.query( " update insert <DEP_ROW>"+"<DEPT_NO>"+depNum+"</DEPT_NO>"+"<DNOMBRE>"+ dNombre+"</DNOMBRE>"+"<LOC>"+loc+"</LOC>"+"</DEP_ROW> into /departamentos");

                   ResourceIterator j;
                   j = result.getIterator();
         
            }

        
    }

    public static void esborradep() throws XMLDBException {
        Collection col = null;
        int depNum;
  
        
        System.out.println("Introdueix el numero del departament que vols esborrar");
        depNum = scan.nextInt();
            
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if(col==null){        
        System.out.println("***LA COLLECIO NO EXITEIX***");
        }
      
        XPathQueryService servei = (XPathQueryService)col.getService("XPathQueryService", "1.0");
              
         ResourceSet result2 = 
         servei.query( " for $em in /departamentos/DEP_ROW[DEPT_NO = "+depNum+"] return $em");
         ResourceIterator i;
            i = result2.getIterator();
            if(i.hasMoreResources()){
                    System.out.println("LA CONSULTA NO TORNA RES");
                
                 ResourceSet result = 
                    servei.query( "update delete //DEP_ROW[DEPT_NO = "+depNum+"]");

                 ResourceIterator j;
                   j = result.getIterator();
                                  
            
            }else{
                   System.out.println("No Existeix");           
            }
        
    }

    private static void modificardep() throws XMLDBException {
         Collection col = null;
        int depNum;
        String dNombre;
        String loc;
     
        
        System.out.println("Introdueix el numero del departament a modificar");
        depNum = scan.nextInt();
        
        System.out.println("Introdueix el nom de departament");
        dNombre = scan.next();
        
        System.out.println("Introdueix la localització");
        loc = scan.next();
               
        
        col = DatabaseManager.getCollection(URI, usu, usuPass);
        if(col==null){        
        System.out.println("***LA COLLECIO NO EXITEIX***");
        }
        //departament num , nom, localitat, 
        
        
        XPathQueryService servei = (XPathQueryService)col.getService("XPathQueryService", "1.0");
      
        
         ResourceSet result2 = 
         servei.query( " for $em in /departamentos/DEP_ROW[DEPT_NO = "+depNum+"] return $em");
         ResourceIterator i;
            i = result2.getIterator();
            if(i.hasMoreResources()){
                 System.out.println("LA CONSULTA NO TORNA RES");
                
                 ResourceSet result = 
                 servei.query( " update replace /departamentos/DEP_ROW[DEPT_NO = "+depNum+"] with <DEP_ROW> <DEPT_NO>"+depNum+"</DEPT_NO>"+"<DNOMBRE>"+ dNombre+"</DNOMBRE>"+"<LOC>"+loc+"</LOC>"+"</DEP_ROW>");
                 ResourceIterator j;
                 j = result.getIterator();  
     
            }else{
                  System.out.println("No Existeix");
                  
             
         
            }
        
    }
}