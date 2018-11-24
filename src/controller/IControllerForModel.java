
package controller;

import java.awt.Image;
import model.Cavaliere;


public interface IControllerForModel {
        
        public int getMovimento();
        
        public void resetOndata();
        
        public void aggiornaMovimento(int a); 
        
        public int getAltezzaterreno();
        
        public int getIndex(int i);
         
        public boolean getControlloreMovimento(int i);
        
        public int[] getYArray();
        
        public int getY(int i);
        
        public int getScore();
        
        public int getIntervalli(int i);
        
        public int diffIntervallo(int i);
        
        public  Boolean[] getEsplosi();
        
        public Boolean getEsplosi(int i);
        
        public  Image getPioggia(int i);
        
        public  Cavaliere getCavalieri(int i);
        
        public  Cavaliere[] getCavalieri();
        
        
}