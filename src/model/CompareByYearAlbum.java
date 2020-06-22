/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;

/**
 *
 * @author Sergio
 */
public class CompareByYearAlbum implements Comparator<Album> {

    @Override
    public int compare(Album a1, Album a2) {
        return Integer.compare(a1.getAnno(), a2.getAnno());
    }
    
}
