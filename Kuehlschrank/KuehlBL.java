/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuehlschrank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Julian Heil
 */
public class KuehlBL extends AbstractListModel<Lebensmittel> {

    private boolean abgelaufen;
    private LinkedList<Lebensmittel> aktuelleListe = new LinkedList<>();
    private LinkedList<Lebensmittel> liste = new LinkedList<>();

    public KuehlBL() {
        aktuelleListe = liste;
        abgelaufen = false;
    }

    @Override
    public Lebensmittel getElementAt(int i) {
        return aktuelleListe.get(i);
    }

    @Override
    public int getSize() {
        return aktuelleListe.size();
    }

    public void addElementE(Lebensmittel element) {
        liste.add(element);
        if (abgelaufen) {
            zeigeAbgelaufene();
        } else {
            zeigeAlle();
        }
        super.fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public LinkedList<Lebensmittel> getList() {
        return aktuelleListe;
    }

    public void delete(int index) {
        this.aktuelleListe.remove(index);
        this.fireIntervalRemoved(this, 0, aktuelleListe.size());
    }

    public void zeigeAbgelaufene() {
        abgelaufen = true;
        LinkedList<Lebensmittel> liste2 = new LinkedList<>();
        LocalDate now = LocalDate.now();
        for (Lebensmittel l : liste) {
            if (l.getAblaufdat().isBefore(now)) {
                liste2.add(l);
            }
        }
        aktuelleListe = liste2;
        super.fireContentsChanged(this, 0, getSize() - 1);
    }

    public void zeigeAlle() {
        abgelaufen = false;
        aktuelleListe = liste;
        super.fireContentsChanged(this, 0, getSize() - 1);
    }
}
