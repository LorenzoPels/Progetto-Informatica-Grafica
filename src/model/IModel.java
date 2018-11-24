
package model;

import java.awt.Image;

public interface IModel {
   
	public int getScore();

	public  void incrementScore();
	
	public void initGame();
        
        public void caricaAnimazioni();
        
        public Image effettuaAnimazione(String colore, int indice);
        
        public int getAltezzaterreno();
        
        public int getIndex(int i);
        
        public void resetIndex();
        
        public void setIndex(int i, int a);
        
        public boolean getControlloreMovimento(int i);
        
        public void setControlloreMovimento(int i,Boolean b);
        
        public int[] getYArray();
        
        public void resetY();
        
        public void setY(int i,int a);
        
        public int getMovimento();
        
        //public void setMovimento(int mv);
        
        public void incrementaMovimento();
        
        public  Cavaliere[] Cavalieri();
        
        public  Cavaliere getCavalieri(int i);
        
        public  Cavaliere[] getCavalieri();
        
        public  void setCavalieri(int i,Cavaliere cv);
        
        public  Image[] Pioggia();
        
        public  Image getPioggia(int i);
        
        public  void setPioggia(int i, Image img);
        
        public Image[] getPioggia();
      
        public  void Esplosi();
        
        public  Boolean getEsplosi(int i);
        
        public  Boolean[] getEsplosi();
        
        public  void setEsplosi(int i, Boolean b);
        
        public int getIntervalli(int i);
        
        public void setIntervallo(int i, int val);
        
        public void pioggiaRandom();

        public void setT0(long tmp);

        public void setP(long tmp);
}
