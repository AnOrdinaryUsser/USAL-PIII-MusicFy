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
public class Album implements Serializable{

    Musicfy mf = new Musicfy();

    private String titulo;
    private List<String> interpretes;
    private int anno;
    private String duracion;
    private int num_canciones;
    private String tipo;
    private List<String> canciones;

    public Album(String titulo, List<String> interpretes, int anno, String duracion, int num_canciones, String tipo, List<String> canciones) {
        this.titulo = titulo;
        this.interpretes = interpretes;
        this.anno = anno;
        this.duracion = duracion;
        this.num_canciones = num_canciones;
        this.tipo = tipo;
        this.canciones = canciones;
    }

    public Album() {
        this.titulo = "Unknown";
        interpretes = new ArrayList<>();
        interpretes.add("Unknown");
        this.anno = 9999;
        this.duracion = "Unknown";
        this.num_canciones = 99;
        this.tipo = "Unknwon";
        canciones = new ArrayList<>();
        canciones.add("Unknown");
    }

    public Album stringToAlbum(String s) {
        Album al = new Album();
        String[] a = s.split("\t");

        if (a[0].length() > 0) {
            al.titulo = a[0];
        }
        if (a[1].length() > 0) {
            al.interpretes = stringPointAndCommaToStringList(a[1]);
        }
        if (a[2].length() > 0) {
            al.anno = Integer.parseInt(a[2]);
        }
        if (a[3].length() > 0) {
            al.duracion = a[3];
        }
        if (a[4].length() > 0) {
            al.num_canciones = Integer.parseInt(a[4]);
        }
        if (a[5].length() > 0) {
            al.tipo = a[5];
        }
        if (a[5].length() != 5) {
            //DO NOTHING
        } else if (a[6].length() > 0) {
            al.canciones = stringPointAndCommaToStringList(a[6]);
        }

        return al;

    }

    //Prueba
    public String[] stringToString(String s) {
        String[] a = s.split("\n");
        return a;
    }

    public List<String> stringPointAndCommaToStringList(String s) {
        String[] scc = s.split(";");
        List<String> tmp = new ArrayList<>();

        for (String str : scc) {
            tmp.add(str);
        }

        return tmp;
    }

    public String exportAsHTMLTableRow() {
        String interprete = String.join(";", this.interpretes);
        return String.format("<tr>"
                + "<td>%s</td>"
                + "<td>%s</td>"
                + "<td ALIGN=center>%d</td>"
                + "<td ALIGN=center>%s</td>"
                + "<td ALIGN=center>%d</td>"
                + "<td ALIGN=center>%s</td>"
                + "</tr>", this.titulo, this.interpretes, this.anno, this.duracion, this.num_canciones,
                this.tipo);
    }

    public String exportAllAtributesAsString() {
        String artistas = String.join(";", this.interpretes);
        String songs = String.join(";", this.canciones);
        return String.format("TITULO: %s\n"
                + "INTERPRETES: %s\n" + "AÑO: %d\n" + "DURACION: %s\n" + "Nº DE CANCIONES: %d\n"
                + "TIPO: %s\n" + "CANCIONES: %s\n", this.titulo, this.interpretes, this.anno,
                this.duracion, this.num_canciones, this.tipo, songs);
    }

    public String exportAsColums() {
        String Columns = String.format("| %20s | %15s | %10d | %15s | %5d | %10s |", this.titulo, this.interpretes,
                this.anno, this.duracion, this.num_canciones, this.tipo);
        return Columns;
    }

    public Album RandomAlbum() {
        Random r = new Random();
        String[] titulos = mf.loadAlbumesRandom();
        String[] artista = mf.loadArtistasRandom();
        String[] cancion = mf.loadCancionesRandom();

        // Artistas aleatorios
        String[] artistasRandom = new String[r.nextInt(1)+1];
        for (int i = 0; i < artistasRandom.length; i++) {
            artistasRandom[i] = artista[r.nextInt(300)];
        }
        List<String> artistas;
        artistas = Arrays.asList(artistasRandom);

        // Canciones aleatorias
        String tipo;
        int numCancionesAleatorias = r.nextInt(15);
        if (numCancionesAleatorias >= 1) {
            tipo = "álbum";
        } else {
            tipo = "sencillo";
        }
        String[] cancionesRandom = new String[numCancionesAleatorias];
        for (int j = 0; j < cancionesRandom.length; j++) {
            cancionesRandom[j] = cancion[r.nextInt(350)];
        }
        List<String> canciones;
        canciones = Arrays.asList(cancionesRandom);

        Album a;

        a = new Album(titulos[r.nextInt(300)], artistas, 2019, DURACION[r.nextInt(DURACION.length)], numCancionesAleatorias, tipo, canciones);

        return a;

    }

    // String para duraciones aleatorias de un album
    private static final String[] DURACION = {"43 min 12 seg", "22 min 15 seg", "31 min 56 seg", "15 min 4 seg", "24 min 23 seg", "52 min 33 seg",
        "32 min 45 seg", "38 min 4 seg", "57 min 3 seg", "19 min 56 seg"};

    //Getters
    public String getTitulo() {
        return titulo;
    }

    public List<String> getInterpretes() {
        return interpretes;
    }

    public int getAnno() {
        return anno;
    }

    public String getDuracion() {
        return duracion;
    }

    public int getNum_canciones() {
        return num_canciones;
    }

    public String getTipo() {
        return tipo;
    }

    public List<String> getCanciones() {
        return canciones;
    }

    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInterpretes(List<String> interpretes) {
        this.interpretes = interpretes;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setNum_canciones(int num_canciones) {
        this.num_canciones = num_canciones;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCanciones(List<String> canciones) {
        this.canciones = canciones;
    }

}
