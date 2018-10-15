
package Wetterwerte;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.AbstractListModel;


 
public class WetterModel extends AbstractListModel {

    LinkedList<Wetterwert> wetter;

    public WetterModel() {
        this.wetter = new LinkedList();
    }

    @Override
    public int getSize() {
        return wetter.size();
    }

    @Override
    public Object getElementAt(int index) {
        return wetter.get(index);
    }

    public void add(Wetterwert e) {
        wetter.add(e);
        super.fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public void save(String path) {
        FileWriter fw;
        String s;
        try {
            fw = new FileWriter(path);

            for (int i = 0; i < wetter.size(); i++) {
                s= (""+ this.wetter.get(i).getLdt().toEpochSecond(ZoneOffset.UTC)+ ";" 
                        + Integer.toString(this.wetter.get(i).getTemperatur())+ ";"
                        + Integer.toString(this.wetter.get(i).getLuftfeuchtigkeit()));
                fw.write(s +"\r\n");
                
                
            }

            fw.flush();
            fw.close();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void laden(String path) {

        Scanner scan;
        Wetterwert w;
        String[] l;
        LocalDateTime ldt;
        try {
            scan = new Scanner(new File(path));

         while (scan.hasNextLine()) {
                l = scan.nextLine().split(";");
                ldt= LocalDateTime.ofEpochSecond(Long.parseLong(l[0]), 0, ZoneOffset.UTC);
                w= new Wetterwert(ldt, Integer.parseInt(l[1]), Integer.parseInt(l[2]));
                wetter.add(w);
            }
         scan.close();
        } catch (Exception e) {
           e.printStackTrace();
        }

    }
    public void saveBin(File f) throws Exception {
        
        OutputStream fos= null;
        
        try{
            fos= new FileOutputStream(f);
            
            ObjectOutputStream os= new ObjectOutputStream(fos);
            
            for(Wetterwert w: wetter){
                os.writeObject(w);
            }
        }
        catch(IOException e){
            //Log
            System.err.println("Save:"+ e.getMessage());
            throw e; // weiterleiten der Exception 
        }
        finally{
            fos.close();
        }
        
    }

}
