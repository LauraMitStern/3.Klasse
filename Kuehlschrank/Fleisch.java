/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuehlschrank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Julian Heil
 */
public class Fleisch extends Lebensmittel {

    DateTimeFormatter formatter;

    public Fleisch(LocalDate ablaufdat, String hersteller, double menge) {
        super(ablaufdat, hersteller, menge);
        formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
    }

    @Override
    public double berechneKcal() {
        return ((menge * 1000.0) / 100.0) * 130.0;
    }

    @Override
    public String toString() {
        return String.format("Fleisch von %s " + menge + " kg - " + berechneKcal() + " kcal (%s)", hersteller, ablaufdat.format(formatter));
    }

    @Override
    public LocalDate getAblaufdat() {
        return ablaufdat;
    }

    @Override
    public String getHersteller() {
        return hersteller;
    }

    @Override
    public double getMenge() {
        return menge;
    }
   
    
}
