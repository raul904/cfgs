/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9uf3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Raul
 */
public class activitat2 {
  	public static void main (String[] args) {
		URL url;
		 Scanner scan = new Scanner(System.in);
		try {
			
		String cerca = null;
                System.out.println("Digues la url:");
                cerca = scan.nextLine();
                
                int port=0;
                System.out.println("Introdueix al port:");
                port = scan.nextInt();
                        
		url = new URL("http", cerca ,port,"");
                                
		Visualitzar (url);
			
			
			
		} catch (MalformedURLException e) { System.out.println(e); }
		
	}
	
	private static void Visualitzar(URL url) {
	
		try {
			
		InputStream inputStream = url.openStream();
                    BufferedReader ine = new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			
			while ((inputLine = ine.readLine()) != null)
				System.out.println(inputLine);
			ine.close();
			
		} catch (IOException e) {e.printStackTrace(); }

	}

        
        }

