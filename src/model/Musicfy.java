/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class Musicfy implements Serializable {
    
    private List<Album> albumes;
    private List<Artista> artistas;
    private List<Song> songs;
    private List<Playlist> playlist = new ArrayList<>();

    private final String nameOfMainFolder = "musicfy";
    private final String nameOfBinFolder = "binarios";
    private final String nameOfBinFile = "musicfy.bin";
    private final String nameOfBinAlbum = "albumes.bin";
    private final String nameOfBinArtista = "artistas.bin";
    private final String nameOfBinSongs = "songs.bin";
    private final String nameOfBinPlaylist = "playlist.bin";
    private final String nameOfDataFolder = "datos";
    private final String nameOfAlbumFile = "albumes.txt";
    private final String nameOfArtistsFile = "artistas.txt";
    private final String nameOfFinalFolder = "salida";
    private final String nameOfColFile = "artistasCol.col";
    private final String nameOfHTMLFile = "albumesHTML.html";
    private final String nameOfRandomFolder = "aleatorios";
    private final String nameOfRandomAlbumes = "nombresAlbumes.txt";
    private final String nameOfRandomArtistas = "nombresArtistas.txt";
    private final String nameOfRandomPlaylist = "nombresPlaylists.txt";
    private final String nameOfRandomCanciones = "titulosCanciones.txt";

    void arranque() throws Exception {
        
        if (loadBinFile(nameOfBinAlbum) == true) {
            System.out.println("\nSe han importado todos los datos del archivo " + nameOfBinAlbum);
        } else {
            loadAlbumTxtFile();
            System.out.println("\nSe han importado todos los albumes del archivo " + nameOfArtistsFile);
        }
        if (loadBinFile(nameOfBinArtista) == true) {
            System.out.println("\nSe han importado todos los datos del archivo " + nameOfBinArtista);
        } else {
            loadArtistsTxtFile();
            System.out.println("\nSe han importado todos los albumes del archivo " + nameOfArtistsFile);
        }
        if (loadBinFile(nameOfBinSongs) == true) {
            System.out.println("\nSe han importado todos los datos del archivo " + nameOfBinSongs);
        } else {
            System.out.println("\nSe han importado ya todos los archivos");
        }
        if (loadBinFile(nameOfBinPlaylist) == true) {
            System.out.println("\nSe han importado todos los datos del archivo " + nameOfBinPlaylist);
        } else {
            System.out.println("\nSe han importado ya todos los archivos");
        }
    }

    void saveArtistasCOL() {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfFinalFolder
                + File.separator
                + nameOfColFile);

        String path = p.toString();
        //System.out.printf("\n\n%s", path);
        try (PrintWriter pw = new PrintWriter(path)) {
            for (Artista a : this.artistas) {
                pw.println(a.exportAsColumns());
            }
            pw.close();
            System.out.println("\nSe ha creado correctamente el archivo artistas.col");
        } catch (FileNotFoundException ex) {
            System.err.println("\nNo se ha podido crear el archivo artistas.col");
            ex.printStackTrace();
        }
    }

    void saveAlbumesHTML() {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfFinalFolder
                + File.separator
                + nameOfHTMLFile);

        String path = p.toString();

        try (PrintWriter pw = new PrintWriter(path)) {
            pw.println("<!DOCTYPE html><HTML class=\"mdl-js\">\n<HEAD><meta charset=\"UTF-8\">"
                    + "<H1>ALBUMES</H1></HEAD>");
            pw.println("<span class=\"codigo\"> ");
            pw.println("<table border=1 cellspacing=0 ");
            pw.println("<tbody>");
            pw.println("<tr>"
                    + "<th scope=\"col\">TITULO</th>"
                    + "<th scope=\"col\">INTERPRETES</th>"
                    + "<th scope=\"col\">AÑO</th>"
                    + "<th scope=\"col\">DURACION</th>"
                    + "<th scope=\"col\">NÚMERO DE CANCIONES</th>"
                    + "<th scope=\"col\">TIPO DE ALBUM</th>"
                    + "</tr>");
            for (Album a : this.albumes) {
                pw.println(a.exportAsHTMLTableRow());
            }
            pw.println("</tbody></TABLE>");
            pw.println("</HTML>");
            pw.close();
            System.out.println("\n\nSe ha creado correctamente el archivo HTML\n\n");
        } catch (FileNotFoundException ex) {
            System.err.println("\n\nNo se ha podido crear el archivo HTML\n\n");
        }
    }

    public void saveBinFiles(String nameOfFile) {
        Path pathOfBinFile = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfBinFolder
                + File.separator
                + nameOfFile);

        FileOutputStream fos;
        BufferedOutputStream bos;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(pathOfBinFile.toFile());
            bos = new BufferedOutputStream(fos);
            oos = new ObjectOutputStream(bos);

            switch (nameOfFile) {
                case "albumes.bin":
                    oos.writeObject(albumes);
                    break;
                case "artistas.bin":
                    oos.writeObject(artistas);
                    break;
                case "songs.bin":
                    oos.writeObject(songs);
                    break;
                case "playlist.bin":
                    oos.writeObject(playlist);
                    break;
                case "musicfy.bin":
                    //oos.writeObject(mf);
                    break;
                default:
                    System.err.println("\n\nNo fue posible encontrar nameOfFile\n\n");
            }
            oos.close();
            System.out.println("Se ha guardado correctamente " + nameOfFile);
        } catch (IOException ex) {
            System.err.println("\n\nNo fue posible guardar el archivo " + nameOfFile);
            System.err.println(ex.toString());
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.err.println("\n\nNo fue posible cerrar el archivo" + nameOfFile);
                    System.out.println(ex.toString());
                }
            }
        }
    }

    public boolean loadBinFile(String nameOfFile) {
        Path pathOfBinFile = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfBinFolder
                + File.separator
                + nameOfFile);
        FileInputStream fis;
        BufferedInputStream bis;
        ObjectInputStream ois = null;
        boolean importado = true;

        if (!Files.exists(pathOfBinFile)) {
            System.err.println("El archivo " + nameOfFile + " no existe");
            return false;
        }

        try {
            fis = new FileInputStream(pathOfBinFile.toFile());
            bis = new BufferedInputStream(fis);
            ois = new ObjectInputStream(bis);

            switch (nameOfFile) {
                case "albumes.bin":
                    albumes = (ArrayList<Album>) ois.readObject();
                    break;
                case "artistas.bin":
                    artistas = (ArrayList<Artista>) ois.readObject();
                    break;
                case "songs.bin":
                    songs = (ArrayList<Song>) ois.readObject();
                    break;
                case "playlist.bin":
                    playlist = (ArrayList<Playlist>) ois.readObject();
                    break;
                case "musicfy.bin":
                    //mf = (Musicfy) ois.readObject();
                    break;
                default:
                    System.err.println("\n\nNo fue posible encontrar nameOfFile\n\n");
                    importado = false;
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("\n\nNo se ha podido leer el archivo binario " + nameOfBinFile);
            System.out.println(ex.toString());
            importado = false;
        } finally {
            if (null != ois) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.err.println("\n\nNo se ha podido cerrar el archivo\n\n");
                }
            }
        }
        return importado;
    }

    public void salida() {
        saveBinFiles(nameOfBinAlbum);
        saveBinFiles(nameOfBinArtista);
        saveBinFiles(nameOfBinSongs);
        saveBinFiles(nameOfBinPlaylist);
    }

    public void loadAlbumTxtFile() throws Exception {
        Path pathOfAlbumFile = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfDataFolder
                + File.separator
                + nameOfAlbumFile);

        //System.out.println(pathOfAlbumFile.toString());
        if (!Files.exists(pathOfAlbumFile)) {
            System.err.println("El archivo " + nameOfAlbumFile + " no existe");
        }
        List<String> tmp;

        try {
            tmp = Files.readAllLines(pathOfAlbumFile);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfAlbumFile);
            return;
        }

        this.albumes = new ArrayList<>();
        this.songs = new ArrayList<>();
        Album A = new Album();
        Song S = new Song();

        if (!tmp.isEmpty()) {
            for (String s : tmp) {
                String[] a = s.split("\t");
                int numCanciones = Integer.parseInt(a[4]);

                this.albumes.add(A.stringToAlbum(s));
                int num = 0;
                if (a[4].equalsIgnoreCase("1")) {

                } else {
                    String[] can = a[6].split(";");
                    for (int i = 0; i < can.length; i++) {
                        this.songs.add(S.stringToSong(s, num));
                        num++;

                    }
                }

            }
        }
    }

    public void loadArtistsTxtFile() {
        Path pathOfArtistsFile = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfDataFolder
                + File.separator
                + nameOfArtistsFile);

        if (!Files.exists(pathOfArtistsFile)) {
            System.err.println("El archivo " + nameOfArtistsFile + " no existe");
        }
        List<String> tmp;

        try {
            tmp = Files.readAllLines(pathOfArtistsFile);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfArtistsFile);
            return;
        }

        this.artistas = new ArrayList<>();
        Artista At = new Artista();

        if (!tmp.isEmpty()) {
            for (String s : tmp) {
                this.artistas.add(At.stringToArtist(s));
            }
        }
    }

    public String[] loadAlbumesRandom() {
        Path pathOfRandomAlbumes = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfRandomFolder
                + File.separator
                + nameOfRandomAlbumes);

        this.albumes = new ArrayList<>();

        Album a = new Album();

        if (!Files.exists(pathOfRandomAlbumes)) {
            System.err.println("El archivo " + nameOfRandomAlbumes + " no existe");
        }
        List<String> tmp = new ArrayList<>();

        try {
            tmp = Files.readAllLines(pathOfRandomAlbumes);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfRandomAlbumes);
        }

        String[] titulos = new String[tmp.size()];

        if (!tmp.isEmpty()) {
            for (String c : tmp) {
                titulos = tmp.toArray(titulos);
            }
        }

        return titulos;

    }

    public String[] loadArtistasRandom() {
        Path pathOfRandomArtistas = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfRandomFolder
                + File.separator
                + nameOfRandomArtistas);

        this.artistas = new ArrayList<>();
        Artista a = new Artista();

        if (!Files.exists(pathOfRandomArtistas)) {
            System.err.println("El archivo " + nameOfRandomArtistas + " no existe");
        }
        List<String> tmp = new ArrayList<>();

        try {
            tmp = Files.readAllLines(pathOfRandomArtistas);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfRandomArtistas);
        }

        String[] artistas = new String[tmp.size()];

        if (!tmp.isEmpty()) {
            for (String c : tmp) {
                artistas = tmp.toArray(artistas);
            }
        }

        return artistas;
    }

    public String[] loadPlayListRandom() {
        Path pathOfRandomPlaylist = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfRandomFolder
                + File.separator
                + nameOfRandomPlaylist);

        this.playlist = new ArrayList<>();
        Playlist p = new Playlist();

        if (!Files.exists(pathOfRandomPlaylist)) {
            System.err.println("El archivo " + nameOfRandomPlaylist + " no existe");
        }
        List<String> tmp = new ArrayList<>();

        try {
            tmp = Files.readAllLines(pathOfRandomPlaylist);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfRandomPlaylist);
        }

        String playlist[] = new String[tmp.size()];

        if (!tmp.isEmpty()) {
            for (String c : tmp) {
                playlist = tmp.toArray(playlist);
            }
        }

        return playlist;

    }

    public String[] loadCancionesRandom() {
        Path pathOfRandomCanciones = FileSystems.getDefault().getPath(System.getProperty("user.home"),
                File.separator
                + "Desktop"
                + File.separator
                + nameOfMainFolder
                + File.separator
                + nameOfRandomFolder
                + File.separator
                + nameOfRandomCanciones);

        this.songs = new ArrayList<>();
        Song s = new Song();

        if (!Files.exists(pathOfRandomCanciones)) {
            System.err.println("El archivo " + nameOfRandomCanciones + " no existe");
        }
        List<String> tmp = new ArrayList<>();

        try {
            tmp = Files.readAllLines(pathOfRandomCanciones);
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo " + nameOfRandomCanciones);
        }

        String canciones[] = new String[tmp.size()];

        if (!tmp.isEmpty()) {
            for (String c : tmp) {
                canciones = tmp.toArray(canciones);
            }
        }
        /*
        Solo es para mostrar si se han importado
        for (String c : canciones) {
            System.out.printf("%s%n", c);
        }
         */

        return canciones;

    }

    public void añadirCancionAleatoria() {
        Song s = new Song();
        this.songs.add(s.RandomSong());
    }

    public void añadirPlaylistAleatoria() {
        Playlist p = new Playlist();
        this.playlist.add(p.RandomPlaylist());
    }

    public void añadirArtistaAleatotio() {
        Artista a = new Artista();
        this.artistas.add(a.RandomArtista());
    }

    public void añadirAlbumAleatorio() {
        Album a = new Album();
        this.albumes.add(a.RandomAlbum());
    }

    //Setters
    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    // Getters
    public List<Album> getAlbumes() {
        return albumes;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void orderAlbumesByYear() {
        Comparator<Album> c;
        c = new CompareByYearAlbum();
        Collections.sort(this.albumes, c);
    }

    public List<Song> getSongsAsColumns() {
        Comparator<Song> s;
        s = new CompareByYearSong();
        Collections.sort(songs, s);
        return songs;
    }
}
