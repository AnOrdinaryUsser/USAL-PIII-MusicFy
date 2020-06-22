/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class CompareByYearSong implements Comparator<Song> {

    @Override
    public int compare(Song s1, Song s2) {
        
            return Integer.compare(s1.getAnno(), s2.getAnno());
        
//return Integer.compare(s1.getAnno(), s2.getAnno());
        
    }
    
}
