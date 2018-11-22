
package controller;


public interface IControllerForModel {
    
        public int getMovimento();
        
        public void setMovimento(int mv);
        
        public void incrementaMovimento();
        
        public void resetOndata();
        
        public void aggiornaMovimento(int a);
        
        public void pioggiaRandom();
        
        public void resetIndex();
        
        public void resetY();
}