/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Model;

/**
 *
 * @author Sergio
 */
public class Controller {

    Model m = new Model();
    
    public void arranque() throws Exception {
        m.arranque();
    }
    
    public void salida() {
        m.salida();
    }
    
    // Opcion 2. Exportar Archivos
    public void artistasEnColumnas() {
        m.artistasCOL();
    }

    public void albumesEnHTML() {
        m.albumesHTML();
    }
    
    // Métodos para Album
    public void añadirAlbum(String[] atributos, int[] annoDuracionNumCanciones) {
        m.añadirAlbum(atributos, annoDuracionNumCanciones);
    }

    public int busquedaAlbum(String album) {
        return m.busquedaAlbum(album);
    }

    public void borrarAlbum(int i) {
        m.borrarAlbum(i);
    }

    public boolean modificarAlbum(int iSubOption, int i, String nuevoCampo) {
        return m.modificarAlbum(iSubOption, i, nuevoCampo);
    }

    public String consultaAlbumes(String album) {
        String tmp = m.consultaAlbumes(album);
        return tmp;
    }
    
    // Métodos para Artista
    public int busquedaArtista(String artista) {
        return m.busquedaArtista(artista);
    }

    public boolean modificarArtista(int iSubOption, int i, String nuevoCampo) {
        return m.modificarArtista(iSubOption, i, nuevoCampo);
    }

    public void añadirArtista(String[] atributos) {
        m.añadirArtista(atributos);
    }

    public void borrarArtista(int i) {
        m.borrarArtista(i);
    }

    public String[] albumesArtista(int i) {
        String[] tmp = m.albumesArtista(i);
        return tmp;
    }

    public String[] cancionesColumns() {
        return m.cancionesAsColumns();
    }

    
    // Métodos para Playlist
    public void añadirPlaylist(String[] playlist, int[] num_canciones_p) {
        m.añadirPlaylist(playlist, num_canciones_p);
    }

    public int busquedaPlaylist(String tituloPlaylist) {
        return m.busquedaPlaylist(tituloPlaylist);
    }

    public String[] cancionesPlaylist(int i) {
        String[] tmp = m.cancionesPlaylist(i);
        return tmp;
    }

    public int busquedaCancionPlaylist(String cancionPlaylist) {
        return m.busquedaCancionPlaylist(cancionPlaylist);
    }

    public void borrarCancionPlaylist(int j, int i) {
        m.borrarCancionPlaylist(j, i);
    }

    public void añadirCancionPlaylist(String cancionPlaylist, int pos, int j) {
        m.añadirCancionPlaylist(cancionPlaylist, pos, j);
    }

    public int busquedaCancion(String cancionPlaylist) {
        return m.busquedaCancion(cancionPlaylist);
    }

    public void añadirCancionSongs(String cancionPlaylist) {
        m.añadirCancionSongs(cancionPlaylist);
    }

    public void cargarAleatorios() {
        m.cargarAleatorios();
    }

    

    

    
    
}
