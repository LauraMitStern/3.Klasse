
import java.io.Serializable;
import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurapein
 */
public class Appointment implements Serializable{
    
    private int tag;
    private int monat;
    private int jahr;
    private int stunde;
    private int minute;
    private String text;
    
    private LocalDateTime ldt;
    
    transient DateTimeFormatter formatterDatum;  //transient bewirkt das die formatter nicht serialisiert werden
    transient DateTimeFormatter formatterZeit;

    public Appointment(int tag, int monat, int jahr, int stunde, int minute, String text) {
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
        this.stunde = stunde;
        this.minute = minute;
        this.text = text;
        
        ldt = LocalDateTime.of(jahr, monat, tag, stunde, minute);
    }

    @Override
    public String toString() {
       return getDatumAsString() + " - " + getZeitAsString()+" --> "+text;
    }
    
    public String getDatumAsString(){
        formatterDatum= DateTimeFormatter.ofPattern("dd.MM.yyyy");        
        return formatterDatum.format(ldt);
    }
    
    public String getZeitAsString(){
        formatterZeit= DateTimeFormatter.ofPattern("hh.mm");        
        return formatterZeit.format(ldt);
    }

    public int getTag() {
        return tag;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    public String getText() {
        return text;
    }
    
    
    
    
}
