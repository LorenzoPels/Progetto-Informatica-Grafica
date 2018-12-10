
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
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------
    private static ControllerForView instance = null;

    private ControllerForView() {
            
    }
    
    //---------------------------------------------------------------
    // METODI PUBBLICI
    //---------------------------------------------------------------

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
            return String.valueOf(Model.getInstance().getScore());
    }

    public void incrementScore() {
            Model.getInstance().incrementScore();
    }
                                                                                

    public void statoCavaliere(int i){

        String colore= Model.getInstance().getColore(i);
        int y=Model.getInstance().getYArray()[i];
        Boolean esplosi = Model.getInstance().getEsplosi(i);
        int altezzaterreno = Model.getInstance().getAltezzaterreno();
        int movimento = Model.getInstance().getMovimento();
        int index = Model.getInstance().getIndex(i);
        if(Model.getInstance().getControlloreMovimento(i)) 
            
            y+= Model.getInstance().getMovimento();
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
             colore = Model.getInstance().getCavalieri(i).getColore();
             Model.getInstance().setColore(i, colore);
             
        }

        if(esplosi==true  && index <= 13 && y <= altezzaterreno-1){
            
             Model.getInstance().setPioggia(i,Model.getInstance().effettuaAnimazione(colore, index));
            index ++;
            Model.getInstance().setIndex(i, index);
        }
    }
       
    public void Colpito(boolean b, String s){

        Cavaliere[] cavalieri = Model.getInstance().getCavalieri();
        int[] y = Model.getInstance().getYArray();
        Boolean[] esplosi = Model.getInstance().getEsplosi();
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
                updateScoreLabel(Model.getInstance().getScore());
                b = true;
            }
        }
    }
        
        
        
    public void logicaPaint(Graphics g){
        
        MagoInterface mago = Model.getInstance().getMago();
        g.drawImage(MagoDefault.getInstance().magoImg() ,MagoDefault.getInstance().getXMago() ,ALTEZZA-175,100,108,null);
        if(getGiocoIniziato()==true) {

            Model.getInstance().setT1();
            
            long diff =  Model.getInstance().getT1() -  Model.getInstance().getT0();

            if(diff >= Model.getInstance().getIntervalli(0) )
                g.drawImage(Model.getInstance().getPioggia(0),Model.getInstance().getXArray()[0],Model.getInstance().getYArray()[0],150,180,null);
            if(diff >= Model.getInstance().getIntervalli(1) )
                g.drawImage(Model.getInstance().getPioggia(1),Model.getInstance().getXArray()[1],Model.getInstance().getYArray()[1],150,180,null);
            if(diff >= Model.getInstance().getIntervalli(2) )
                g.drawImage(Model.getInstance().getPioggia(2),Model.getInstance().getXArray()[2],Model.getInstance().getYArray()[2],150,180,null);
            if(diff >= Model.getInstance().getIntervalli(3) )
                g.drawImage(Model.getInstance().getPioggia(3),Model.getInstance().getXArray()[3],Model.getInstance().getYArray()[3],150,180,null);
            if(diff >= Model.getInstance().getIntervalli(4) )
                g.drawImage(Model.getInstance().getPioggia(4),Model.getInstance().getXArray()[4],Model.getInstance().getYArray()[4],150,180,null);
           
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
