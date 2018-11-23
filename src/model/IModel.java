
package model;

import java.awt.Image;

public interface IModel {
   
	public int getScore();

	public  void incrementScore();
	
	public void initGame();
        
        public void caricaAnimazioni();
        
        public Image effettuaAnimazione(String colore, int indice);
        
        public int getAltezzaterreno();
        
        public int[] getIndex();
        
        public boolean[] getControlloreMovimento();
        
        public int[] getYArray();
        
        public int getMovimento();
        
        public void setMovimento(int mv);
        
        public  Cavaliere[] Cavalieri();
        
        public  Image[] Pioggia();
        
        public Image[] getPioggia();
      
        public  void Esplosi();
        
        public int getIntervalli(int i);
        
        public void setIntervallo(int i, int val);
        
        
        
        
        
        public void setT0(long tmp);

        public void setP(long tmp);
}
