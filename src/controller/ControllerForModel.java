
package controller;

import java.awt.Image;
import model.Cavaliere;
import model.MagoInterface;
import model.Model;
import static view.StartWindow.insane;


public class ControllerForModel implements IControllerForModel {

	private static ControllerForModel instance = null;
        public int rallentaMov=0;

	private ControllerForModel() {
		//to-do
	}
       /* public void initGame(){
            Model.getInstance().initGame();
        }*/
        
        public int getMovimento(){
            return Model.getInstance().getMovimento();   
        }
       /* public void setMovimento(int mv){
            Model.getInstance().setMovimento(mv);    
        }*/
    
       /* public void incrementaMovimento(){
            //Model.getInstance().incrementaMovimento();
            int mv = ControllerForView.getInstance().getMovimento();
            mv++;
            ControllerForView.getInstance().setMovimento(mv);
        }*/
        
        public void resetOndata(){
            Image[] pioggia = Model.getInstance().getPioggia();
            // provare pioggia[]==null
            if(pioggia[0]== null && pioggia[1]== null && pioggia[2]== null && pioggia[3]== null && pioggia[4]== null  ){  
                
                                                                                //    Model.t0=System.currentTimeMillis();
                                                                                  //  Model.P=0;
                
                Model.getInstance().setT0();
                Model.getInstance().setP(0);
                Model.getInstance().Cavalieri();
                Model.getInstance().Pioggia();
                Model.getInstance().Esplosi();
                Model.getInstance().pioggiaRandom();
                Model.getInstance().resetY();
                
                
                if( diffIntervallo(0) > 100 )
                    Model.getInstance().setIntervallo(0, Model.getInstance().getIntervalli(0) - 100);
                if( diffIntervallo(1) > 500 )
                    Model.getInstance().setIntervallo(1, Model.getInstance().getIntervalli(0) - 200);
                if( diffIntervallo(2) > 500 )
                     Model.getInstance().setIntervallo(2, Model.getInstance().getIntervalli(0) - 200);
                if( diffIntervallo(3) > 500 )
                     Model.getInstance().setIntervallo(3, Model.getInstance().getIntervalli(0) - 200);
                if( diffIntervallo(4) > 500 )
                     Model.getInstance().setIntervallo(4, Model.getInstance().getIntervalli(0) - 200);

                aggiornaMovimento(rallentaMov);
                
            }
    }
        public void aggiornaMovimento(int a){
            if(insane == true){                        
                if( getMovimento() < 6 ){
                    if( (getMovimento() + a)%2 == 0)
                        a++;
                    Model.getInstance().incrementaMovimento();
                }
            }else{
                if( getMovimento() < 4 ){
                    if( (getMovimento() + a)%2 == 0)
                        a++;
                    else Model.getInstance().incrementaMovimento();               
                }
            }               
        }
        
        public int getAltezzaterreno(){
            return Model.getInstance().getAltezzaterreno();
        }
        
        public int getIndex(int i){
            return Model.getInstance().getIndex(i);
        }
        
        public boolean getControlloreMovimento(int i){
            return Model.getInstance().getControlloreMovimento(i);
        }
        
      /*  public void pioggiaRandom(){
            ControllerForView.getInstance().pioggiaRandom();
        }*/
       /*public void resetIndex(){
            ControllerForView.getInstance().resetIndex();
        }*/
         public int[] getYArray(){
             return Model.getInstance().getYArray();
         }
        
        public int getY(int i){
            return Model.getInstance().getYArray()[i];
        }
        public int getX(int i){
            return Model.getInstance().getXArray()[i];
        }
        
        /*public void resetY(){
            ControllerForView.getInstance().resetY();
        } */   
        
        public int getScore(){
            return Model.getInstance().getScore();
        }
        
        public int getIntervalli(int i){
            return Model.getInstance().getIntervalli(i);
        }
        
       /* public void incrementScore(){
            Model.getInstance().incrementScore();
        }*/
        
        public int diffIntervallo(int i){
                int diff = Model.getInstance().getIntervalli(i);
            if(i != 0)
                diff = Model.getInstance().getIntervalli(i) - Model.getInstance().getIntervalli(i-1);  
            return diff;
        }
        
        public Boolean[] getEsplosi(){
            return Model.getInstance().getEsplosi();
        }
        
        public Boolean getEsplosi(int i){
            return Model.getInstance().getEsplosi(i);
        }
        
        public  Image getPioggia(int i){
            return Model.getInstance().getPioggia(i);
        }
        
        public  Cavaliere getCavalieri(int i){
            return Model.getInstance().getCavalieri(i);
        }
        
        public  Cavaliere[] getCavalieri(){
            return Model.getInstance().getCavalieri();
        }
        
	public static IControllerForModel getInstance() {
		if (instance == null)
			instance = new ControllerForModel();
		return instance;
	}
        
        public MagoInterface getMago(){
            return Model.getInstance().getMago();
        }
        
        

}