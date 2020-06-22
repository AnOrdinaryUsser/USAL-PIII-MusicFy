/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Sergio
 */
public class Model {

    Musicfy mf = new Musicfy();
    private static final String[] DURACION = {"3 min 12 seg", "2 min 15 seg", "3 min 56 seg", "3 min 4 seg", "4 min 23 seg", "2 min 33 seg",
        "2 min 45 seg", "3 min 4 seg", "5 min 3 seg", "1 min 56 seg"};

    public void arranque() throws Exception {
        mf.arranque();
    }
    
    public void salida() {
        mf.salida();
    }

    public void artistasCOL() {
        mf.saveArtistasCOL();
    }

    public void albumesHTML() {
        mf.saveAlbumesHTML();
    }

    public void añadirAlbum(String[] atributos, int[] annoDuracionNumCanciones) {

        // Añadimos los artistas que sean nuevos
        String[] artistas = atributos[1].split(";");
        for (String at : artistas) {
            int art = busquedaArtista(at);
            if (-1 != art) {
                mf.getArtistas().get(art).getAlbumes().add(atributos[0]);
                System.out.println("\n\nSe ha añadido un nuevo álbum a el artista " + at);
            } else {
                Artista a = new Artista();
                a.setNombre(at);
                List<String> tmp = new ArrayList<>();
                tmp.add(atributos[0]);
                a.setAlbumes(tmp);
                System.out.println("\n\nSe ha añadido el artista " + at + " a la lista de artistas");
                mf.getArtistas().add(a);
            }
        }
        
        String[] canciones = atributos[3].split(";");

        // Por ultimo añadimos todos los demás atributos
        List<String> interpretes = new ArrayList<>();
        Collections.addAll(interpretes, artistas);
        List<String> songs = new ArrayList<>();
        Collections.addAll(songs, canciones);

        String duracion = annoDuracionNumCanciones[1] + " min" + annoDuracionNumCanciones[2] + "seg";

        Album Alb = new Album(atributos[0], interpretes, annoDuracionNumCanciones[0],
                duracion, annoDuracionNumCanciones[3],
                atributos[2], songs);
        mf.getAlbumes().add(Alb);
    }

    public int busquedaAlbum(String album) {
        for (int n = 0; n < mf.getAlbumes().size(); n++) {
            if (0 == album.compareToIgnoreCase(mf.getAlbumes().get(n).getTitulo())) {
                return n;
            }
        }
        return -1;
    }

    public void borrarAlbum(int i) {
        String tituloAlbum = mf.getAlbumes().get(i).getTitulo();
        String artistaTemp = String.join(";", mf.getAlbumes().get(i).getInterpretes());
        String[] artistas = artistaTemp.split(";");
        for (String art : artistas) {
            int pos = busquedaArtista(art);
            if (pos != -1) {
                int pos1 = mf.getArtistas().get(pos).getAlbumes().indexOf(tituloAlbum);
                if (-1 != pos) {
                    System.out.println("\nSe ha eliminado el album " + tituloAlbum + " del Artista" + art);
                    mf.getArtistas().get(pos).getAlbumes().remove(pos1);
                }
            }
        }

        mf.getAlbumes().remove(i);
    }

    public boolean modificarAlbum(int iSubOption, int i, String nuevoCampo) {
        switch (iSubOption) {
            case 1:
                try {
                    int anno = Integer.parseInt(nuevoCampo);
                    mf.getAlbumes().get(i).setAnno(anno);
                    return true;
                } catch (NumberFormatException ex) {
                    System.out.printf("%n%nEl campo año debe ser un número entero%n%n");
                    return false;
                }
            case 2:
                try {
                    int duracion = Integer.parseInt(nuevoCampo);
                    mf.getAlbumes().get(i).setAnno(duracion);
                    return true;
                } catch (NumberFormatException ex) {
                    System.out.printf("%n%nEl campo duración debe ser un número entero%n%n");
                    return false;
                }
            case 3:
                try {
                    int num_canciones = Integer.parseInt(nuevoCampo);
                    mf.getAlbumes().get(i).setAnno(num_canciones);
                    return true;
                } catch (NumberFormatException ex) {
                    System.out.printf("%n%nEl campo Nº de canciones debe ser un número entero%n%n");
                    return false;
                }
            case 4:
                mf.getAlbumes().get(i).setTipo(nuevoCampo);
                return true;
            default:
                return false;
        }
    }

    public String consultaAlbumes(String album) {
        int consultar = busquedaAlbum(album);
        if (consultar != -1) {
            return mf.getAlbumes().get(consultar).exportAllAtributesAsString();
        }
        return null;
    }

    public int busquedaArtista(String artista) {
        for (int n = 0; n < mf.getArtistas().size(); n++) {
            if (0 == artista.compareToIgnoreCase(mf.getArtistas().get(n).getNombre())) {
                return n;
            }
        }
        return -1;
    }

    public void añadirArtista(String[] atributos) {
        String[] albumes = atributos[6].split(";");
        List<String> albums = new ArrayList<>();
        Collections.addAll(albums, albumes);
        Artista a = new Artista(atributos[0], atributos[1], atributos[2], atributos[3],
                atributos[4], atributos[5], albums);
        mf.getArtistas().add(a);
    }

    public boolean modificarArtista(int iSubOption, int i, String nuevoCampo) {
        switch (iSubOption) {
            case 1:
                mf.getArtistas().get(i).setBiografia(nuevoCampo);
                return true;
            case 2:
                mf.getArtistas().get(i).setInstagram(nuevoCampo);
                return true;
            case 3:
                mf.getArtistas().get(i).setTwitter(nuevoCampo);
                return true;
            case 4:
                mf.getArtistas().get(i).setFacebook(nuevoCampo);
                return true;
            case 5:
                mf.getArtistas().get(i).setWikipedia(nuevoCampo);
                return true;
            default:
                return false;
        }
    }

    public void borrarArtista(int i) {
        String albumesTemp = String.join(";", mf.getArtistas().get(i).getAlbumes());
        String[] albumes = albumesTemp.split(";");
        boolean albumesExistentes = false;
        for (String a : albumes) {
            int pos = busquedaAlbum(a);
            if (-1 != pos) {
                System.out.printf("%s, ", a);
                albumesExistentes = true;
            }
        }
        if (albumesExistentes == true) {
            System.out.printf("%n%nNo se puede borrar el artista porque hay algun(nos) albumes de ese artista existentes%n%n");
        } else {
            mf.getArtistas().remove(i);
            System.out.printf("%n%nEl artista ha sido eliminado correctamente%n%n");
        }
    }

    public String[] albumesArtista(int i) {
        String albumesTemp = String.join(";", mf.getArtistas().get(i).getAlbumes());
        String[] albumes = albumesTemp.split(";");
        String[] tmp = new String[albumes.length];
        mf.orderAlbumesByYear();
        for (int n = 0; n < albumes.length; n++) {
            int pos = busquedaAlbum(albumes[n]);
            if (-1 != pos) {
                tmp[n] = mf.getAlbumes().get(pos).exportAsColums();
            } else {
                tmp[n] = String.format("| %20s | %15s | %10d | %15s | %5d | %10s |", albumes[n], "", 2019, "",
                        0, "");
            }
        }
        return tmp;
    }

    public String[] cancionesAsColumns() {
        if (null == mf.getSongsAsColumns().get(0)) {
            return null;
        }
        String[] tmp = new String[mf.getSongsAsColumns().size()];
        for (int n = 0; n < tmp.length; n++) {
            tmp[n] = mf.getSongsAsColumns().get(n).exportAsColums();
        }
        return tmp;
    }

    public void añadirPlaylist(String[] playlist, int[] num_canciones_p) {
        Random r = new Random();
        int numCanciones = num_canciones_p[0];
        String[] cancion = new String[numCanciones];
        Song s = new Song();

        System.out.printf("%nListado de canciones aleatorias asignadas a la playlist >> %s%n%n", playlist[0]);
        for (int n = 0; n < numCanciones; n++) {
            int aleatorio = r.nextInt(s.getTitulo().length() * 20);
            cancion[n] = mf.getSongsAsColumns().get(r.nextInt(aleatorio)).exportAsColums(); //numCanciones o canciones.length para generar aleatorios
            System.out.printf("%s%n", cancion[n]);
        }

        List<String> canciones = new ArrayList<>();
        Collections.addAll(canciones, cancion);

        Playlist p = new Playlist(playlist[0], canciones);

        mf.getPlaylist().add(p);

    }

    public int busquedaPlaylist(String tituloPlaylist) {
        for (int n = 0; n < mf.getPlaylist().size(); n++) {
            if (0 == tituloPlaylist.compareToIgnoreCase(mf.getPlaylist().get(n).getTitulo())) {
                return n;
            }
        }
        return -1;
    }

    public String[] cancionesPlaylist(int i) {
        String cancionesTemp = String.join(";", mf.getPlaylist().get(i).getCanciones());
        String[] canciones = cancionesTemp.split(";");
        String[] tmp = new String[canciones.length];
        
        for (int n = 0; n < canciones.length; n++) {
            tmp[n] = String.format("%-40s", canciones[n]);
        }
        return tmp;
    }

    public int busquedaCancionPlaylist(String cancionPlaylist) {

        for (int n = 0; n < mf.getPlaylist().size(); n++) {

            if (0 == cancionPlaylist.compareToIgnoreCase(mf.getPlaylist().get(n).getCanciones().get(n))) {
                return n;
            }
        }
        return -1;
    }

    public void borrarCancionPlaylist(int j, int i) {
        mf.getPlaylist().get(i).getCanciones().remove(j);
    }

    public void añadirCancionPlaylist(String cancionPlaylist, int pos, int j) {
        int k = busquedaCancion(cancionPlaylist);
        if (-1 == k) {
            System.out.printf("%n%nERROR: No se ha añadido correctamente la cancion a Songs y por ello no se puede añadir a la playlist");
        } else {
            String cancion = mf.getSongsAsColumns().get(k).exportAsColums();
            mf.getPlaylist().get(pos).getCanciones().add(cancion);
        }

    }

    public int busquedaCancion(String cancion) {
        for (int n = 0; n < mf.getSongs().size(); n++) {
            if (0 == cancion.compareToIgnoreCase(mf.getSongs().get(n).getTitulo())) {
                return n;
            }
        }
        return -1;
    }

    public void añadirCancionSongs(String cancionPlaylist) {
        Random r = new Random();
        List<String> artistas = new ArrayList<>();
        artistas.add("Unknown");
        Song s = new Song(cancionPlaylist, 2019, DURACION[r.nextInt(DURACION.length)], artistas);
        mf.getSongs().add(s);
    }

    public void cargarAleatorios() {
        mf.loadAlbumesRandom();
        System.out.printf("%nSe ha importado los albumes aleatorios%n");
        mf.loadArtistasRandom();
        System.out.printf("%nSe ha importado los artistas aleatorios%n");
        mf.loadPlayListRandom();
        System.out.printf("%nSe ha importado las playlist aleatorios%n");
        mf.loadCancionesRandom();
        System.out.printf("%nSe ha importado las canciones aleatorios%n");
        System.out.printf("%n%nCargamos canciones aleatorias...%n");
        for (int i = 0; i < 20; i++) {
            mf.añadirCancionAleatoria();
        }
        //mf.añadirPlaylistAleatoria();
        for (int i = 0; i < 20; i++) {
            mf.añadirArtistaAleatotio();
        }
        for (int i = 0; i < 20; i++) {
            mf.añadirAlbumAleatorio();
        }
    }
    
    

}
