/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.View;

/**
 *
 * @author Sergio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        View v = new View();
        
        v.runMenu("\n============== STREAMING APP =============="
                + "\n1.- Generación Aleatoria"
                + "\n2.- Archivos"
                + "\n3.- Álbum"
                + "\n4.- Artista"
                + "\n5.- PlayList"
                + "\n6.- Canciones"
                + "\nq.- Salir"
                + "\n==========================================="
                + "\nOpciones -> ");
    }
    
}
