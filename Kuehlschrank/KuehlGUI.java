/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kuehlschrank;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class KuehlGUI extends javax.swing.JFrame {

    /**
     * Creates new form KuehlGUI
     */
    KuehlBL currentModel = new KuehlBL();
    KuehlBL gefrierModel = new KuehlBL();
    KuehlBL kuehlModel = new KuehlBL();
    KuehlBL obstModel = new KuehlBL();

    private LinkedList<String> gefrierList;
    private LinkedList<String> kuehlList;
    private LinkedList<String> obstList;

    private int startingIndex = 0;
    
    private String hersteller;
    private LocalDate ablaufdat;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private double menge;

    public KuehlGUI()  {
        initComponents();
        
        cbItems.setSelectedIndex(startingIndex);
        
        gefrierList = new LinkedList();
        kuehlList = new LinkedList();
        obstList = new LinkedList();

        File f = new File("test.csv");
        if (f.exists()) {
            Lebensmittel l = null;
            LocalDate tmp;
            String parts[];
            try {
                Scanner sc = new Scanner(f);
                for (int i = 0; sc.hasNextLine(); i++) {
                    parts = sc.nextLine().split(";");
                    switch (parts[1]) {
                        case "M":
                            tmp = LocalDate.parse(parts[2], formatter);
                            l = new Milch(tmp, parts[3], Double.parseDouble(parts[4]));
                            break;
                        case "F":
                            tmp = LocalDate.parse(parts[2], formatter);
                            l = new Fleisch(tmp, parts[3], Double.parseDouble(parts[4]));
                            break;
                        case "A":
                            tmp = LocalDate.parse(parts[2], formatter);
                            l = new Apfel(tmp, parts[3], Double.parseDouble(parts[4]));
                            break;
                    }
                    switch (parts[0]) {
                        case "g":
                            gefrierModel.addElementE(l);
                            break;
                        case "k":
                            kuehlModel.addElementE(l);
                            break;
                        case "o":
                            obstModel.addElementE(l);
                            break;
                    }
                }
                liAusgabe.repaint();
                sc.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(KuehlGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        sortMenu = new javax.swing.JPopupMenu();
        sortMenge = new javax.swing.JMenuItem();
        sortHersteller = new javax.swing.JMenuItem();
        sortAblaufdat = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cbItems = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        rbFleisch = new javax.swing.JRadioButton();
        rbMilch = new javax.swing.JRadioButton();
        rbApfel = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        liAusgabe = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfHersteller = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAblaufdatum = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfMenge = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btHinzufuegen = new javax.swing.JButton();
        btLoeschen = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btAbgelaufene = new javax.swing.JButton();
        btAlle = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        sortMenge.setText("sortMenge");
        sortMenge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSortMenge(evt);
            }
        });
        sortMenu.add(sortMenge);

        sortHersteller.setText("sortHersteller");
        sortHersteller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSortHersteller(evt);
            }
        });
        sortMenu.add(sortHersteller);

        sortAblaufdat.setText("Nach Ablaufdatum sortieren");
        sortAblaufdat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortAblaufdatActionPerformed(evt);
            }
        });
        sortMenu.add(sortAblaufdat);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kühlschrank");

        jPanel2.setLayout(new java.awt.BorderLayout());

        cbItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gefrierfach", "Kühlfach", "Obstfach" }));
        cbItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSetFach(evt);
            }
        });
        jPanel2.add(cbItems, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 3));

        group.add(rbFleisch);
        rbFleisch.setText("Fleisch");
        jPanel3.add(rbFleisch);

        group.add(rbMilch);
        rbMilch.setText("Milch");
        jPanel3.add(rbMilch);

        group.add(rbApfel);
        rbApfel.setText("Apfel");
        jPanel3.add(rbApfel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.setLayout(new java.awt.BorderLayout());

        liAusgabe.setModel(gefrierModel);
        liAusgabe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onClicked(evt);
            }
        });
        jScrollPane2.setViewportView(liAusgabe);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(3, 2));

        jLabel2.setText("Hersteller");
        jPanel5.add(jLabel2);
        jPanel5.add(tfHersteller);

        jLabel3.setText("Ablaufdatum (TT.MM.JJJJ)");
        jPanel5.add(jLabel3);
        jPanel5.add(tfAblaufdatum);

        jLabel1.setText("Menge (kg)");
        jPanel5.add(jLabel1);
        jPanel5.add(tfMenge);

        jPanel6.setLayout(new java.awt.GridLayout(2, 1));

        btHinzufuegen.setText("Hinzufügen");
        btHinzufuegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onAdd(evt);
            }
        });
        jPanel6.add(btHinzufuegen);

        btLoeschen.setText("Löschen");
        btLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onLoeschen(evt);
            }
        });
        jPanel6.add(btLoeschen);

        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        btAbgelaufene.setText("Zeige nur Abgelaufene");
        btAbgelaufene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onZeigeAbgelaufene(evt);
            }
        });
        jPanel7.add(btAbgelaufene);

        btAlle.setText("Zeige alle");
        btAlle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onZeigeAlle(evt);
            }
        });
        jPanel7.add(btAlle);

        jButton1.setText("In csv speichern");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onSave(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onSetFach(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSetFach
     switch (cbItems.getSelectedIndex()) {
            case 0:
                liAusgabe.setModel(gefrierModel);
                currentModel = gefrierModel;
                break;
            case 1:
                liAusgabe.setModel(kuehlModel);
                currentModel = kuehlModel;
                break;
            case 2:
                liAusgabe.setModel(obstModel);
                currentModel = obstModel;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_onSetFach

    private void onAdd(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onAdd
        hersteller = tfHersteller.getText();
        ablaufdat = LocalDate.parse(tfAblaufdatum.getText(), formatter);
        menge = Double.parseDouble(tfMenge.getText());

        Lebensmittel l = null;
        String tmp = "";

        if (rbFleisch.isSelected()) {
            l = new Fleisch(ablaufdat, hersteller, menge);
            tmp = "F;" + ablaufdat.format(formatter) + ";" + hersteller + ";" + Double.toString(menge);
        } else if (rbMilch.isSelected()) {
            l = new Milch(ablaufdat, hersteller, menge);
            tmp = "M;" + ablaufdat.format(formatter) + ";" + hersteller + ";" + Double.toString(menge);
        } else if (rbApfel.isSelected()) {
            l = new Apfel(ablaufdat, hersteller, menge);
            tmp = "A;" + ablaufdat.format(formatter) + ";" + hersteller + ";" + Double.toString(menge);
        }

        if (currentModel == gefrierModel) {
            gefrierList.add(tmp);
        } else if (currentModel == kuehlModel) {
            kuehlList.add(tmp);
        } else if (currentModel == obstModel) {
            obstList.add(tmp);
        }

        currentModel.addElementE(l);
        liAusgabe.repaint();
    }//GEN-LAST:event_onAdd

    private void onLoeschen(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onLoeschen
        try {
            int index = liAusgabe.getSelectedIndex();

            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Bitte zuerst ein Element auswählen", "Error", JOptionPane.ERROR_MESSAGE);
            }

            switch (cbItems.getSelectedIndex()) {
                case 0:
                    gefrierModel.delete(index);
                    gefrierList.remove(index);
                    break;
                case 1:
                    kuehlModel.delete(index);
                    kuehlList.remove(index);
                    break;
                case 2:
                    obstModel.delete(index);
                    obstList.remove(index);
                    break;
                default:
                    break;
            }
            liAusgabe.repaint();
        } catch (java.lang.IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Keine Elemente vorhanden! \n" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_onLoeschen

    private void onSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSave
        try {
            FileWriter fw = new FileWriter("test.csv");
            for (int i = 0; i < gefrierList.size(); i++) {
                fw.write("g;" + gefrierList.get(i));
                fw.write("\n");
            }

            for (int i = 0; i < kuehlList.size(); i++) {
                fw.write("k;" + kuehlList.get(i));
                fw.write("\n");
            }

            for (int i = 0; i < obstList.size(); i++) {
                fw.write("o;" + obstList.get(i));
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_onSave

    private void onClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onClicked
        if (evt.getButton() == MouseEvent.BUTTON2 || evt.getButton() == MouseEvent.BUTTON3) {
            this.sortMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_onClicked

    private void sortAblaufdatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortAblaufdatActionPerformed
        Collections.sort(currentModel.getList(), new Kuehlschrank.CompDate());
        liAusgabe.repaint();
    }//GEN-LAST:event_sortAblaufdatActionPerformed

    private void onZeigeAbgelaufene(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onZeigeAbgelaufene
        currentModel.zeigeAbgelaufene();
        liAusgabe.repaint();
    }//GEN-LAST:event_onZeigeAbgelaufene

    private void onZeigeAlle(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onZeigeAlle
        currentModel.zeigeAlle();
        liAusgabe.repaint();
    }//GEN-LAST:event_onZeigeAlle

    private void onSortHersteller(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSortHersteller
       Collections.sort(currentModel.getList(), new Kuehlschrank.CompHersteller());
        liAusgabe.repaint();
    }//GEN-LAST:event_onSortHersteller

    private void onSortMenge(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSortMenge
        
    }//GEN-LAST:event_onSortMenge

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KuehlGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KuehlGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KuehlGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KuehlGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KuehlGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbgelaufene;
    private javax.swing.JButton btAlle;
    private javax.swing.JButton btHinzufuegen;
    private javax.swing.JButton btLoeschen;
    private javax.swing.JComboBox<String> cbItems;
    private javax.swing.ButtonGroup group;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Lebensmittel> liAusgabe;
    private javax.swing.JRadioButton rbApfel;
    private javax.swing.JRadioButton rbFleisch;
    private javax.swing.JRadioButton rbMilch;
    private javax.swing.JMenuItem sortAblaufdat;
    private javax.swing.JMenuItem sortHersteller;
    private javax.swing.JMenuItem sortMenge;
    private javax.swing.JPopupMenu sortMenu;
    private javax.swing.JTextField tfAblaufdatum;
    private javax.swing.JTextField tfHersteller;
    private javax.swing.JTextField tfMenge;
    // End of variables declaration//GEN-END:variables
}
