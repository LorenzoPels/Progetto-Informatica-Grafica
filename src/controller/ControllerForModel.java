
package controller;

import java.awt.Image;
import model.Model;
import static view.StartWindow.insane;


public class ControllerForModel implements IControllerForModel {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------
    private static ControllerForModel instance = null;      

    private ControllerForModel() {
            //to-do
    }
    
    //---------------------------------------------------------------
    // METODI PUBBLICI
    //---------------------------------------------------------------

    public void resetOndata(){
        Image[] pioggia = Model.getInstance().getPioggia();
        if(pioggia[0]== null && pioggia[1]== null && pioggia[2]== null && pioggia[3]== null && pioggia[4]== null ){  

            Model.getInstance().setT0();
            Model.getInstance().setP(0);
            Model.getInstance().Cavalieri();
            Model.getInstance().Pioggia();
            Model.getInstance().Esplosi();
            Model.getInstance().pioggiaRandom();
            Model.getInstance().resetY();

            Model .getInstance().setColore(0, null);
            Model .getInstance().setColore(1, null);
            Model .getInstance().setColore(2, null);
            Model .getInstance().setColore(3, null);
            Model .getInstance().setColore(4, null);

            if( diffIntervallo(0) > 100 )
                Model.getInstance().setIntervallo(0, Model.getInstance().getIntervalli(0) - 100);
            if( diffIntervallo(1) > 500 )
                Model.getInstance().setIntervallo(1, Model.getInstance().getIntervalli(1) - 200);
            if( diffIntervallo(2) > 500 )
                 Model.getInstance().setIntervallo(2, Model.getInstance().getIntervalli(2) - 200);
            if( diffIntervallo(3) > 500 )
                 Model.getInstance().setIntervallo(3, Model.getInstance().getIntervalli(3) - 200);
            if( diffIntervallo(4) > 500 )
                 Model.getInstance().setIntervallo(4, Model.getInstance().getIntervalli(4) - 200);

            aggiornaMovimento( Model.getInstance().getRallentaMov());    

        }
    }

    public void aggiornaMovimento(int a){
        if(insane == true){                        
            if( Model.getInstance().getMovimento() < 6 ){
                if( ( Model.getInstance().getMovimento() + a)%2 == 0)
                    Model.getInstance().incrementRallentaMov();
                Model.getInstance().incrementaMovimento();
            }
        }else{
            if(  Model.getInstance().getMovimento() < 4 ){
                if( ( Model.getInstance().getMovimento() + a)%2 == 0)
                    Model.getInstance().incrementRallentaMov();
                else Model.getInstance().incrementaMovimento();               
            }
        }               
    }


    public int diffIntervallo(int i){
            int diff = Model.getInstance().getIntervalli(i);
        if(i != 0)
            diff = Model.getInstance().getIntervalli(i) - Model.getInstance().getIntervalli(i-1);  
        return diff;
    }

    //---------------------------------------------------------------
    // METODI STATICI
    //---------------------------------------------------------------
    public static IControllerForModel getInstance() {
            if (instance == null)
                    instance = new ControllerForModel();
            return instance;
    }
               
}