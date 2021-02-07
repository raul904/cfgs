/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jocdames;

/**
 *
 * @author Raul
 */
public class JocDames {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int fila = obtenerFilaClicada();
        int columna = obtenerColumnaClicada();
        
        boolean jugaX = true;
        boolean jugaO = false;
        int filaOrigen = -1;
        int columnaOrigen = -1;

       if (noHiHaOrigen())
	if(jugaX && EsX(fila,columna))ActualitzaNouOrigen(fila,columna);
        
                               
        else{ if (jugaO && EsO(fila,columna))ActualitzaNouOrigen(fila,columna);		
       
            else mostraError();
       }

    
		
    	

     else{
	if(movimentVàlid(fila,columna));//si diagonal cap avall per X o cap a dalt per O
        
            if(esBuit(fila,columna) || OcupatContrari(fila,columna))mou(fila,columna);
			
	
            else { if (OcupatPropi(fila,columna))actualitzaNouOrigen(fila,columna);
                       
            }	
       }
    }
//            else(mostraErrorMoviment());
             

  
//                        }


    private static boolean noHiHaOrigen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mostraError() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mostraErrorMoviment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int obtenerFilaClicada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static int obtenerColumnaClicada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean EsX(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void ActualitzaNouOrigen(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean EsO(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean movimentVàlid(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean esBuit(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean OcupatContrari(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mou(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static boolean OcupatPropi(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void actualitzaNouOrigen(int fila, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
       
    
    
}


    


