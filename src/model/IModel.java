
package model;

import java.awt.Image;

public interface IModel {
   
	public int getScore();
        
                                                                                //public int getY(int i);
        
        public int getMovimento();
        
        public void setMovimento(int m);
        
                                                                                //public void incrementaMovimento();
        
                                                                                //public void resetIndex();
        
                                                                                //public void resetY();
        
                                                                                //public void resetOndata();

	public  void incrementScore();
	
	public void initGame();
        
                                                                                //public void Colpito(boolean b, String s);
        
                                                                                //public void statoCavaliere(int i);
        
        public void caricaAnimazioni();
        
        public Image effettuaAnimazione(String colore, int indice);
        
                                                                                //public void pioggiaRandom();ù
        // manca   public static IModel getInstance();    perchè?    

}
