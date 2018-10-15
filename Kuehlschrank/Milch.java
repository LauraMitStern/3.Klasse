
package Kuehlschrank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Milch extends Lebensmittel {

    DateTimeFormatter formatter;

    public Milch(LocalDate ablaufdat, String hersteller, double menge) {
        super(ablaufdat, hersteller, menge);
        formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
    }

    @Override
    public double berechneKcal() {
        return ((menge * 1000.0) / 100.0) * 64.0;
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

    @Override
    public String toString() {
        return String.format("Milch von %s " + menge + " kg - " + berechneKcal() + " kcal (%s)", hersteller, ablaufdat.format(formatter));
    }

}
