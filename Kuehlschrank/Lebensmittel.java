
package Kuehlschrank;


import java.time.LocalDate;


public class Lebensmittel {
    
    protected LocalDate ablaufdat;
    protected String hersteller;
    protected double menge;

    public Lebensmittel(LocalDate ablaufdat, String hersteller, double menge) {
        this.ablaufdat = ablaufdat;
        this.hersteller = hersteller;
        this.menge = menge;
    }

    public LocalDate getAblaufdat() {
        return ablaufdat;
    }
h
    public double berechneKcal(){
        
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "Default toString";
    }

    public String getHersteller() {
        return hersteller;
    }

    public double getMenge() {
        return menge;
    }
    
    
}
