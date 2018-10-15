
package Wetterwerte;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Wetterwert {
   private int temperatur;
   private int luftfeuchtigkeit;
   //private LocalDate datum ;
  // private LocalTime time;
   private final LocalDateTime ldt;
   
   DateTimeFormatter formatter1;
   DateTimeFormatter formatter2;

    public Wetterwert(LocalDateTime ldt, int temperatur, int luftfeuchtigkeit) {
        this.temperatur = temperatur;
        this.luftfeuchtigkeit = luftfeuchtigkeit;
        this.ldt=ldt;
        formatter1= DateTimeFormatter.ofPattern("dd.MM");
        formatter2= DateTimeFormatter.ofPattern("kk:mm:ss");
        
    }

    public int getTemperatur() {
        return temperatur;
    }

    public int getLuftfeuchtigkeit() {
        return luftfeuchtigkeit;
    }

   public LocalDateTime getLdt(){
       return ldt;
   }

    @Override
    public String toString() {
       return ldt.format(formatter1) + " - " + ldt.format(formatter2) + " - " + this.temperatur + "° - " + this.luftfeuchtigkeit + "%";
    }
   
   
}
