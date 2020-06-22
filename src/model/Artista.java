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
public class Artista implements Serializable {

    Musicfy mf = new Musicfy();

    private String nombre;
    private String biografia;
    private String instagram;
    private String twitter;
    private String facebook;
    private String wikipedia;
    private List<String> albumes;

    public Artista(String nombre, String biografia, String instagram, String twitter, String facebook, String wikipdia, List<String> albumes) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.instagram = instagram;
        this.twitter = twitter;
        this.facebook = facebook;
        this.wikipedia = wikipedia;
        this.albumes = albumes;
    }

    public Artista() {
        this.nombre = "Unknown";
        this.biografia = "Unknown";
        this.instagram = "@Unknown";
        this.twitter = "@Unknown";
        this.facebook = "Unknown";
        this.wikipedia = "Unknown";
        albumes = new ArrayList<>();
        albumes.add("Unknown");
    }

    Artista stringToArtist(String s) {
        Artista at = new Artista();
        String[] a = s.split("#");
        if (a[0].length() > 0) {
            at.nombre = a[0];
        }
        if (a[1].length() > 0) {
            at.biografia = a[1];
        }
        if (a[2].length() > 0) {
            at.instagram = a[2];
        }
        if (a[3].length() > 0) {
            at.twitter = a[3];
        }
        if (a[4].length() > 0) {
            at.facebook = a[4];
        }
        if (a[5].length() > 0) {
            at.wikipedia = a[5];
        }
        if (a[6].length() > 0) {
            at.albumes = stringPointAndCommaToStringList(a[6]);
        }
        return at;
    }

    public List<String> stringPointAndCommaToStringList(String s) {
        String[] scc = s.split(";");
        List<String> tmp = new ArrayList<>();

        for (String str : scc) {
            tmp.add(str);
        }

        return tmp;
    }

    public String exportAsColumns() {
        String artistAlbums = String.join(",", this.albumes);
        String columns = String.format("| %-20s | %-280s | %25s | %25s | %25s | %40s | %-150s |",
                this.nombre, this.biografia, this.instagram, this.twitter, this.facebook,
                this.wikipedia, artistAlbums);
        return columns;
    }

    public Artista RandomArtista() {
        Random r = new Random();
        String[] nombres = mf.loadArtistasRandom();
        String[] albumesR = mf.loadAlbumesRandom();
        String[] albumesRandom = new String[r.nextInt(10)];
        for (int n = 0; n < albumesRandom.length; n++) {
            albumesRandom[n] = albumesR[r.nextInt(300)];
        }
        List<String> albumes;
        albumes = Arrays.asList(albumesRandom);

        Artista a;

        a = new Artista(nombres[r.nextInt(300)], "Unknown", "@Unknown", "@Unknown", "Unknown", "Unknown ref", albumes);

        return a;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public List<String> getAlbumes() {
        return albumes;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public void setAlbumes(List<String> albumes) {
        this.albumes = albumes;
    }

}
