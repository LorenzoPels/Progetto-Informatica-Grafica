
package controller;

import java.awt.Graphics;
import java.awt.Image;
import model.Cavaliere;



public interface IControllerForView {
    
    public void openStartWindow();

	public void closeStartWindow();

	public void openMainGUI();
        
        public void closeMainGUI();
        
        public void openDialog();
        
        public void closeDialog();
        
        public void openGameOverDialog(String score);
        
        public void closeGameOverDialog();

	public String getScore();

	public void incrementScore();

	public void initGame();
        
        public void Colpito(boolean b, String s);
        
       // public int getY(int i);
         
        /*public void resetIndex();
        
        public void resetY();*/
        
        public void statoCavaliere(int i);
        
        //public void pioggiaRandom();
        
        //public int getMovimento();
        
        public void logicaPaint (Graphics g );
        
        public Boolean getGiocoInEsecuzione();
        
        public void setGiocoInEsecuzione(Boolean b);
        
        public Boolean getGiocoIniziato();
        
        public void setGiocoIniziato(Boolean b);
        
        public long getT0();
        
        public void setT0();
        
        public long getT1();
              
        public void setP(long tmp);
        
        public long getP();
        
        public long getPi();
        
        public void setPi();
        
        public long getPf();
        
        public void setPf();
        
        public int getIntervalli(int i);
        
        public  void Cavalieri();
        
        public  void Pioggia();
        
        public  void Esplosi();
    
}
