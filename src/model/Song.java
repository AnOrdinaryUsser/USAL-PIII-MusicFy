/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sergio
 */
public class Song implements Serializable{

    Musicfy mf = new Musicfy();
    
    private String titulo;
    private int anno;
    private String duracion;
    private List<String> interpretes;

    public Song(String titulo, int anno, String duracion, List<String> interpretes) {
        this.titulo = titulo;
        this.anno = anno;
        this.duracion = duracion;
        this.interpretes = interpretes;
    }

    public Song() {
        this.titulo = "Unknown";
        this.anno = 9999;
        this.duracion = "Unknown";
        interpretes = new ArrayList<>();
        interpretes.add("Unknown");
    }

    public Song stringToSong(String s, int i) {
        Song S = new Song();
        String[] a = s.split("\t");
        Random r = new Random();

        /*
            if (a[0].length() > 0) {
                //s1.titulo = s2[0];
            }*/
        if (a[1].length() > 0) {
            S.interpretes = stringPointAndCommaToStringList(a[1]);
        }
        if (a[2].length() > 0) {
            S.anno = Integer.parseInt(a[2]);
        }
        if (a[3].length() > 0) {
            S.duracion = DURACION[r.nextInt(DURACION.length)];
        }
        if (a[4].length() > 0) {
            //DO NOTHING
        }
        if (a[5].length() > 0) {
            //DO NOTHING
        }
        if (a[5].length() != 5) {
            //DO NOTHING
        } else if (a[6].length() > 0) {

            String[] can = a[6].split(";");
            
            S.titulo = can[i];           
            
        }

        return S;
    }
    
    public Song RandomSong () {
        Random r = new Random();
        String[] titulos = mf.loadCancionesRandom();
        String[] artista = mf.loadArtistasRandom();
        String[] artistasRandom = new String[r.nextInt(1)+1];
        for (int i = 0; i < artistasRandom.length; i++) {
            artistasRandom[i] = artista[r.nextInt(300)];
        }
        List<String> artistas;
        artistas = Arrays.asList(artistasRandom);       
               
        Song s;
        
        s = new Song(titulos[r.nextInt(350)],2019,DURACION[r.nextInt(DURACION.length)],artistas);
        
        return s;
    }

    public List<String> stringPointAndCommaToStringList(String s) {
        String[] scc = s.split(";");
        List<String> tmp = new ArrayList<>();

        for (String str : scc) {
            tmp.add(str);
        }

        return tmp;
    }

    public String exportAsColums() {
        String Columns = String.format("| %-36s | %4d | %14s | %-23s |", this.titulo, this.anno,
                this.duracion, this.interpretes);
        return Columns;
    }
    
    // Generación Aleatoria de Duraciones para las canciones
    private static final String[] DURACION = {"3 min 12 seg", "2 min 15 seg", "3 min 56 seg", "3 min 4 seg", "4 min 23 seg", "2 min 33 seg",
                                            "2 min 45 seg", "3 min 4 seg", "5 min 3 seg", "1 min 56 seg"};

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public int getAnno() {
        return anno;
    }

    // Setters
    public String getDuracion() {
        return duracion;
    }

    public List<String> getInterpretes() {
        return interpretes;
    }

    public void setTitulo(List<String> titulo) {
//        this.titulo = titulo;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setInterpretes(List<String> interpretes) {
        this.interpretes = interpretes;
    }

}
