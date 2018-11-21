
package controller;

import model.Model;
import view.MainGUI;
import static view.MainGUI.P;
import static view.MainGUI.int0;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.StartWindow.insane;


public class ControllerForModel implements IControllerForModel {

	private static ControllerForModel instance = null;
        public int rallentaMov=0;

	private ControllerForModel() {
		//to-do
	}
        
        public int getMovimento(){
            return Model.getInstance().getMovimento();
            
        }
    
        public void incrementaMovimento(){
            //Model.getInstance().incrementaMovimento();
            int mv = Model.getInstance().getMovimento();
            mv++;
            Model.getInstance().setMovimento(mv);
        }
        
        public void resetOndata(){
        if(pioggia[0]== null && pioggia[1]== null && pioggia[2]== null && pioggia[3]== null && pioggia[4]== null  ){    
            t0=System.currentTimeMillis();
            P=0;
            MainGUI.Cavalieri();
            MainGUI.Pioggia();
            MainGUI.Esplosi();
            ControllerForView.getInstance().pioggiaRandom();
            ControllerForView.getInstance().resetY();
            //pioggiaRandom();
            //resetIndex();
            //resetY();
            if(int0>100)
                int0-=100;
            if( (int1-int0) > 500 )
                int1-=200;
            if( (int2-int1) > 500 )
                int2-=200;
            if( (int3-int2) > 500 )
                int3-=200;
            if( (int4-int3) > 500 )
                int4-=200;
              
              aggiornaMovimento(rallentaMov);
            //aggiornaMovimento(a);
        }
    }
        public void aggiornaMovimento(int a){
            if(insane == true){                        
                if( getMovimento() < 6 ){
                    if( (getMovimento() + a)%2 == 0)
                        a++;
                    incrementaMovimento();
                }
            }else{
                if( getMovimento() < 4 ){
                    if( (getMovimento() + a)%2 == 0)
                        a++;
                    else incrementaMovimento();               
                }
            }               
        }
        
    /*    public void Colpito(boolean b, String s){
        for(int i =0;(i<cavalieri.length)&&(b==false);i++){
            if((cavalieri[i].getName()== s) && (esplosi[i]==false)&&(y[i]>-150)){
                pioggia[i] = null;
                cavalieri[i] = null;
                esplosi[i] = true;
                cavalieri[i]=Cavaliere.nextCavaliere();
                scoppio.play();                
                mago.gestisciMago(i);
                incrementScore();
                updateScoreLabel(getScore());
                b = true;
            }
        }
    }                                                                           */  //spostato su CFV
        
	public static IControllerForModel getInstance() {
		if (instance == null)
			instance = new ControllerForModel();
		return instance;
	}
}