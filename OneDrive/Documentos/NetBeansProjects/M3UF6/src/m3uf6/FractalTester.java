/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m3uf6;

import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class FractalTester {
   static Scanner scan = new Scanner (System.in);
   static int numero;
   
  public static void main (String[] args){

      System.out.println("Introdueix el numero");
      numero = scan.nextInt();
      fract(numero);
  
  }

    private static int fract(int num) {
        int resultado;
       if (num == 1){
           resultado=4;
       }else{
           resultado = 4 * num + 4 * fract(num/2);
       }
	System.out.println(resultado);
        return resultado;
    }
    
}
