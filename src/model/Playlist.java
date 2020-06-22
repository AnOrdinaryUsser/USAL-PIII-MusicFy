/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sergio
 */
public class Playlist implements Serializable{

    Musicfy mf = new Musicfy();

    private String titulo;
    private List<String> canciones;

    public Playlist(String titulo, List<String> canciones) {
        this.titulo = titulo;
        this.canciones = canciones;
    }

    public Playlist() {
        this.titulo = "Unknown";
        canciones = new ArrayList<>();
        canciones.add("Unknown");
    }

    public String exportAsColums() {
        String Columns = String.format("| %20s |%n", this.canciones);
        return Columns;
    }

    public Playlist RandomPlaylist() {
        Random r = new Random();
        String[] titulos = mf.loadPlayListRandom();
        int numCancionesRandom = r.nextInt(10);
        String[] cancion = new String[numCancionesRandom];
        Song s = new Song();
        String tituloPlaylistRandom = titulos[r.nextInt(30)];

        System.out.printf("%nListado de canciones aleatorias asignadas a una playlist aleatoria >> %s%n%n", tituloPlaylistRandom);
        for (int n = 0; n < numCancionesRandom; n++) {
            cancion[n] = mf.getSongsAsColumns().get(r.nextInt(20)).exportAsColums();
            System.out.printf("%s%n", cancion[n]);
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s%n", cancion[i]);
        }

        List<String> canciones = new ArrayList<>();
        Collections.addAll(canciones, cancion);

        Playlist p = new Playlist(tituloPlaylistRandom, canciones);

        return p;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }

}
