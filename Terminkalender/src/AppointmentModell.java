
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author laurapein
 */
public class AppointmentModell extends AbstractListModel{

    ArrayList<Appointment> al;
    
    public AppointmentModell(){
        this.al= new ArrayList();
    }
    
    
    @Override
    public int getSize() {
        return this.al.size();
    }

    @Override
    public Appointment getElementAt(int index) {
       return this.al.get(index);
    }
    
    public void addAppointment(Appointment a){
        this.al.add(a);
        super.fireIntervalAdded(this,0, getSize()-1);
    }
    
    public void removeAppointment(int i){
        this.al.remove(i);
        super.fireIntervalRemoved(this, 0,getSize()-1) ;
    }
    
    public void changeObject(Appointment a, int index){
        this.al.set(index, a);
        super.fireContentsChanged(this, 0, getSize()-1);
    }
    
    public int getIndexFromObject(Appointment a){
        int index =-1;
        
        
        for(int i=0; i<al.size();i++){
            if(al.get(i).equals(a)){
                index=i;
            }
        }
        
        return index;
    }
}
