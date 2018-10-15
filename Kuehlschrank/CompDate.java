/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuehlschrank;

import java.util.Comparator;

/**
 *
 * @author Julian Heil
 */
public class CompDate implements Comparator<Lebensmittel> {

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() == obj.getClass()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }

    @Override
    public int compare(Lebensmittel o1, Lebensmittel o2) {
        return ((Lebensmittel) o1).getAblaufdat().compareTo(((Lebensmittel) o2).getAblaufdat());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

}
