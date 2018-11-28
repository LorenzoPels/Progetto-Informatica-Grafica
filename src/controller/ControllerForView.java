
package controller;


import java.awt.Graphics;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cavaliere;
import model.MagoDefault;
import model.MagoInterface;


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
        String colore= ControllerForModel.getInstance().getColore(i);
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
        if(colore == null){
             colore = ControllerForModel.getInstance().getCavalieri(i).getColore();
             Model.getInstance().setColore(i, colore);
             
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
        
    public void logicaPaint(Graphics g){
        
          MagoInterface mago = ControllerForModel.getInstance().getMago();
          //mago.stampaMago();
              
       
        g.drawImage(mago.magoImg() ,mago.getXMago() ,ALTEZZA-190,100,108,null);
        if(getGiocoIniziato()==true) {

            Model.getInstance().setT1();
            
            long diff =  Model.getInstance().getT1() -  Model.getInstance().getT0();
            
            
            if(diff >= Model.getInstance().getIntervalli(0) )
                g.drawImage(ControllerForModel.getInstance().getPioggia(0),ControllerForModel.getInstance().getX(0),ControllerForModel.getInstance().getY(0),150,180,null);
            if(diff >= Model.getInstance().getIntervalli(1) )
                g.drawImage(ControllerForModel.getInstance().getPioggia(1),ControllerForModel.getInstance().getX(1),ControllerForModel.getInstance().getY(1),150,180,null);
            if(diff >= Model.getInstance().getIntervalli(2) )
                g.drawImage(ControllerForModel.getInstance().getPioggia(2),ControllerForModel.getInstance().getX(2),ControllerForModel.getInstance().getY(2),150,180,null);
            if(diff >= Model.getInstance().getIntervalli(3) )
                g.drawImage(ControllerForModel.getInstance().getPioggia(3),ControllerForModel.getInstance().getX(3),ControllerForModel.getInstance().getY(3),150,180,null);
            if(diff >= Model.getInstance().getIntervalli(4) )
                g.drawImage(ControllerForModel.getInstance().getPioggia(4),ControllerForModel.getInstance().getX(4),ControllerForModel.getInstance().getY(4),150,180,null);
           
            ControllerForModel.getInstance().resetOndata();           
            mago.movimentoBraccia(); 
            mago.stampaMago();
        }
        
    }

    public Boolean getGiocoInEsecuzione(){
        return Model.getInstance().getGiocoInEsecuzione();
    }
    public void setGiocoInEsecuzione(Boolean b){
        Model.getInstance().setGiocoInEsecuzione(b);
    }
    public Boolean getGiocoIniziato(){
        return Model.getInstance().getGiocoIniziato();
    }
    public void setGiocoIniziato(Boolean b){
        Model.getInstance().setGiocoIniziato(b);
    }
    
    public long getT0(){
        return Model.getInstance().getT0();
    }
        
    public void setT0(){
        Model.getInstance().setT0();
    }

    public long getT1(){
        return Model.getInstance().getT1();
    }

    public void setP(long tmp){
        Model.getInstance().setP(tmp);
    }
    
    public long getP(){
        return Model.getInstance().getP();
    }

    public long getPi(){
        return Model.getInstance().getPi();
    }

    public void setPi(){
        Model.getInstance().setPi();
    }

    public long getPf(){
        return Model.getInstance().getPf();
    }

    public void setPf(){
        Model.getInstance().setPf();
    }

    public int getIntervalli(int i){
        return Model.getInstance().getIntervalli(i);
    }
    
    public  void Cavalieri(){
        Model.getInstance().Cavalieri();
    }
        
    public  void Pioggia(){
        Model.getInstance().Pioggia();
    }
        
    public  void Esplosi(){
        Model.getInstance().Esplosi();
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
