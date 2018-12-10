
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
        
        public int[] getXArray();
        
        public void resetY();
        
        public void setY(int i,int a);
        
        public int getMovimento();
     
        public void incrementaMovimento();
        
        public void Cavalieri();
        
        public Cavaliere getCavalieri(int i);
        
        public Cavaliere[] getCavalieri();
        
        public void setCavalieri(int i,Cavaliere cv);
        
        public void Pioggia();
        
        public Image getPioggia(int i);
        
        public void setPioggia(int i, Image img);
        
        public Image[] getPioggia();
      
        public void Esplosi();
        
        public Boolean getEsplosi(int i);
        
        public Boolean[] getEsplosi();
        
        public void setEsplosi(int i, Boolean b);
        
        public int getIntervalli(int i);
        
        public void setIntervallo(int i, int val);
        
        public void pioggiaRandom();
        
        public long getT0();
        
        public void setT0();
        
        public long getT1();
        
        public void setT1();
        
        public void setP(long tmp);
        
        public long getP();
        
        public long getPi();
        
        public void setPi();
        
        public long getPf();
        
        public void setPf();
        
        public Boolean getGiocoInEsecuzione();
         
        public void setGiocoInEsecuzione(Boolean b);
     
        public Boolean getGiocoIniziato();
    
        public void setGiocoIniziato(Boolean b);
    
        public MagoInterface getMago();
        
        public String getColore(int i);
        
        public void setColore(int i, String s);
        
        public int getRallentaMov();
        
        public void incrementRallentaMov();
}
