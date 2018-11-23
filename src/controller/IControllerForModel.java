
package controller;


public interface IControllerForModel {
        
        public void initGame();
        
        public int getScore();
        
        public void incrementScore();
    
        public int getMovimento();
        
        public void setMovimento(int mv);
        
        public void incrementaMovimento();
        
        public void resetOndata();
        
        public void aggiornaMovimento(int a);
        
        public void pioggiaRandom();
        
        public void resetIndex();
                
        public int getY(int i);
        
        public void resetY();
}