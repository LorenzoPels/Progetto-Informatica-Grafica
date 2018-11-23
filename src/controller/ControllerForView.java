
package controller;


import static view.MainGUI.ALTEZZA;
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
            ControllerForModel.getInstance().initGame();
    }
    public String getScore() {
            return String.valueOf(ControllerForModel.getInstance().getScore());
    }

    public void incrementScore() {
            ControllerForModel.getInstance().incrementScore();
    }
                                                                                

    public int getY(int i) {
        return ControllerForModel.getInstance().getY(i);
    }

    public void resetIndex(){
        ControllerForModel.getInstance().resetIndex();
                                                                                //    for (int i=0; i<index.length;i++)
                                                                                //       index[i]=0;
    }

    public void resetY(){
        ControllerForModel.getInstance().resetY();
                                                                                //    for (int i=0; i<y.length;i++)
                                                                                //        y[i]=-150;  
    }
    
    public void statoCavaliere(int i){
        if(controlloreMovimento[i]) 
            y[i]+= ControllerForModel.getInstance().getMovimento();
            if(esplosi[i])
                y[i]+=movimento+1;
            if(index[i] > 12)
                y[i]+=2*movimento+1;
        if(y[i] >= -1000) controlloreMovimento[i] = true;
        if(y[i] >= altezzaterreno) controlloreMovimento[i] = false;        
        if((y[i] >= altezzaterreno) &&(esplosi[i] == true)){
            pioggia[i]= null;
            index[i]=0;
        }        
        if((y[i] >= altezzaterreno) &&(esplosi[i] == false) ){
            gameover.play();
            timer.stop();
            try {
                sleep(1500);

            } catch (InterruptedException ex) {
                Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            player.stop();
            ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());

        }
        if(esplosi[i] == false){
             colore[i] = cavalieri[i].getColore();
        }

        if(esplosi[i]==true  && index[i] <= 13 && y[i] <= altezzaterreno-1){
            pioggia[i]= effettuaAnimazione(colore[i], index[i]);
            index[i] ++;
        }
    }
        public void pioggiaRandom(){   
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
        }
        public void Colpito(boolean b, String s){
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
        }
        
        public int getMovimento(){
            return movimento;    
        }
        
        
        

    //---------------------------------------------------------------
    // METODI STATICI
    //---------------------------------------------------------------
    public static IControllerForView getInstance() {
            if (instance == null)
                    instance = new ControllerForView();
            return instance;
    }
}
