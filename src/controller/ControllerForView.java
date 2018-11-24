
package controller;


import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cavaliere;
import model.MagoDefault;
import model.Model;
import view.MainGUI;
import static view.MainGUI.ALTEZZA;
import static view.RightPanel.updateScoreLabel;
import static view.MainGUI.gameover;
import static view.MainGUI.player;
import static view.MainGUI.scoppio;
import static view.MainGUI.timer;
import view.View;



public class ControllerForView implements IControllerForView {
                                                                                
    private static ControllerForView instance = null;

    private ControllerForView() {
            
    }

    public void openStartWindow() {
            View.getInstance().openStartWindow();
    }

    public void closeStartWindow() {
            View.getInstance().closeStartWindow();
    }

    public void openMainGUI() {
            closeStartWindow();
            View.getInstance().openMainGUI();
    }
    public void closeMainGUI() {
            View.getInstance().closeMainGUI();
    }
    public void openDialog() {
            View.getInstance().openDialog();
    }

    public void closeDialog() {
            View.getInstance().closeDialog();
    }
    public void openGameOverDialog(String score) {
            View.getInstance().openGameOverDialog( score);
    }

    public void closeGameOverDialog() {
            View.getInstance().closeGameOverDialog();
    }
    public void initGame() {
            Model.getInstance().initGame();
    }
    public String getScore() {
            return String.valueOf(ControllerForModel.getInstance().getScore());
    }

    public void incrementScore() {
            Model.getInstance().incrementScore();
    }
                                                                                

   /* public int getY(int i) {
        return ControllerForModel.getInstance().getY(i);
    }*/

    /*public void resetIndex(){
        ControllerForModel.getInstance().resetIndex();
                                                                                //    for (int i=0; i<index.length;i++)
                                                                                //       index[i]=0;
    }*/

   /* public void resetY(){
        ControllerForModel.getInstance().resetY();
                                                                                //    for (int i=0; i<y.length;i++)
                                                                                //        y[i]=-150;  
    }*/
    
    
    public void statoCavaliere(int i){
        // non si sa colore[i] da dove nasceva fuori, perciò lo richiamo qui come
        // unica variabile.
        String colore=null;
        int y=ControllerForModel.getInstance().getY(i);
        Boolean esplosi = ControllerForModel.getInstance().getEsplosi(i);
        int altezzaterreno = ControllerForModel.getInstance().getAltezzaterreno();
        int movimento = ControllerForModel.getInstance().getMovimento();
        int index = ControllerForModel.getInstance().getIndex(i);
        if(ControllerForModel.getInstance().getControlloreMovimento(i)) 
            
            y+= ControllerForModel.getInstance().getMovimento();
            if(esplosi)
                y+=movimento+1;
                Model.getInstance().setY(i, y);
            if(index > 12)
                y+=2*movimento+1;
                Model.getInstance().setY(i, y);
        if(y >= -1000) Model.getInstance().setControlloreMovimento(i, true);
        if(y >= altezzaterreno) Model.getInstance().setControlloreMovimento(i, false);        
        if((y >= altezzaterreno) &&(esplosi == true)){
            Model.getInstance().setPioggia(i, null);
            index=0;
            Model.getInstance().setIndex(i, index);
        }        
        if((y >= altezzaterreno) &&(esplosi == false) ){
            gameover.play();
            timer.stop();
            try {
                sleep(1500);

            } catch (InterruptedException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            player.stop();
            ControllerForView.getInstance().openGameOverDialog(/*scorelabel.getText()*/getScore());

        }
        if(esplosi == false){
             colore = ControllerForModel.getInstance().getCavalieri(i).getColore();
        }

        if(esplosi==true  && index <= 13 && y <= altezzaterreno-1){
             Model.getInstance().setPioggia(i,Model.getInstance().effettuaAnimazione(colore, index));
            index ++;
            Model.getInstance().setIndex(i, index);
        }
    }
       /* public void pioggiaRandom(){   
            for(int i=0;i<pioggia.length;i++){
                x[i] = (int)(Math.random() * (larghezza-295)) % (larghezza-295);
                if(x[i]<148)
                    x[i]+=148;
                if(i>0){
                    if((x[i] > (x[i-1]-148)) && (x[i]<= x[i-1]))
                        x[i] = x[i-1]-148;
                    if((x[i] < (x[i-1]+148)) && (x[i]>= x[i-1]))
                        x[i] = x[i-1]+148;
                } 
            }               
        }*/
        public void Colpito(boolean b, String s){
            Cavaliere[] cavalieri = ControllerForModel.getInstance().getCavalieri();
            int[] y = ControllerForModel.getInstance().getYArray();
            Boolean[] esplosi = ControllerForModel.getInstance().getEsplosi();
            for(int i =0;(i<cavalieri.length)&&(b==false);i++){
                if((cavalieri[i].getName()== s) && (esplosi[i]==false)&&(y[i]>-150)){
                    //pioggia[i] = null;
                    Model.getInstance().setPioggia(i, null);
                    cavalieri[i] = null;
                    Model.getInstance().setCavalieri(i, cavalieri[i]);
                    esplosi[i] = true;
                    Model.getInstance().setEsplosi(i, esplosi[i]);
                    cavalieri[i]=Cavaliere.nextCavaliere();
                    Model.getInstance().setCavalieri(i, cavalieri[i]);
                    scoppio.play();                
                    MagoDefault.getInstance().gestisciMago(i);
                    incrementScore();
                    updateScoreLabel(ControllerForModel.getInstance().getScore());
                    b = true;
                }
            }
        }
        
        
        
       /* public int getMovimento(){
            return movimento;    
        }*/
        
        
        

    //---------------------------------------------------------------
    // METODI STATICI
    //---------------------------------------------------------------
    public static IControllerForView getInstance() {
            if (instance == null)
                    instance = new ControllerForView();
            return instance;
    }
}
