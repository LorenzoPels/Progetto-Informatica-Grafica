
package model;

import controller.ControllerForView;
import java.awt.Image;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.BoardPanel;
import view.CaricatoreImmagine;
import view.MainGUI;
import static view.MainGUI.ALTEZZA;
import static view.MainGUI.P;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.Pi;
import static view.MainGUI.Pf;
import static view.MainGUI.cavalieri;
import static view.MainGUI.esplosi;
import static view.MainGUI.gameover;
import static view.MainGUI.isGameRunning;
import static view.MainGUI.isGameStarted;
import static view.MainGUI.int0;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.movimento;
import static view.MainGUI.pioggia;
import static view.MainGUI.player;
import static view.MainGUI.scoppio;
import static view.MainGUI.timer;
import static view.RightPanel.scorelabel;
import static view.RightPanel.updateScoreLabel;
import static view.StartWindow.insane;
import view.View;


public class Model implements IModel {
    
    //---------------------------------------------------------------
    // STATIC FIELDS
    //---------------------------------------------------------------
    private static Model instance = null;
    private Cavaliere fallingPiece;
    private Image[] Arancio = new Image[14];
    private Image[] Blu = new Image[14];
    private Image[] Giallo = new Image[14];
    private Image[] Grigio = new Image[14];
    private Image[] Rosa = new Image[14];
    private Image[] Rosso = new Image[14];
    private Image[] Verde = new Image[14];
    private Image[] Viola = new Image[14];
    private boolean controlloreMovimento[]= new boolean[5];
    //---------------------------------------------------------------
    // INSTANCE ATTRIBUTES
    //---------------------------------------------------------------
    public  int score;
    public  int y[] = new int[5];
    public  int index[] = new int[5];
    public  String[] colore = new String[5];
    private Model() {		
        this.initGame();
    }
    
    //---------------------------------------------------------------
    // PUBLIC INSTANCE METHODS
    //---------------------------------------------------------------
    public void initGame() {
        isGameRunning = false;
        isGameStarted = false;
        this.score= 0;
        for(int i=0; i<cavalieri.length;i++){
            cavalieri[i]=null;
              pioggia[i]=null;
         }
        P=0;
        MainGUI.Cavalieri();
        MainGUI.Pioggia();
        BoardPanel.pioggiaRandom();
        int0=900;
        int1=1800;
        int2=2700;
        int3=3600;
        int4=4500;
        resetIndex();
        resetY();
        for (int i=0; i<y.length;i++)
            y[i]=-150;

        t0=t1=P=Pi=Pf=0;
        if(insane==true){
            movimento=2;
            int0=700;
            int1=1400;
            int2=2100;
            int3=2800;
            int4=3500;               
        }else{ 
            movimento =1;
            int0=900;
            int1=1800;
            int2=2700;
            int3=3600;
            int4=4500;
        }
    }
        
    public int getScore() {
        return this.score;
    }
    
    public int getY(int i) {
        return this.y[i];
    }
    
    public void resetIndex(){
        for (int i=0; i<index.length;i++)
            index[i]=0;
    }
    
    public void resetY(){
        for (int i=0; i<y.length;i++)
            y[i]=-150;  
    }
    
    public  void incrementScore() {
        this.score ++;
    }
    
    public void Colpito(boolean b, String s){
        //b = false;
        for(int i =0;(i<cavalieri.length)&&(b==false);i++){
            if((cavalieri[i].getName()== s) && (esplosi[i]==false)&&(y[i]>-150)){
                pioggia[i] = null;
                cavalieri[i] = null;
                esplosi[i] = true;
                cavalieri[i]=Cavaliere.nextCavaliere();
                scoppio.play();

                View.getInstance().gestisciMago(i);


                Model.getInstance().incrementScore();
                updateScoreLabel(Model.getInstance().getScore());
                b = true;
            }
        }
    }

    public void statoCavaliere(int i){
        if(controlloreMovimento[i]) 
                y[i]+=movimento;
            if(esplosi[i])
                y[i]+=movimento+1;
            if(index[i] > 12)
                y[i]+=2*movimento+1;
        if(y[i] >= -1000) controlloreMovimento[i] = true;
        if(y[i] >= ALTEZZA-220) controlloreMovimento[i] = false;
        
        if((y[i] >= ALTEZZA-220) &&(esplosi[i] == true)){
            pioggia[i]= null;
            index[i]=0;
        }
           
        if((y[i] >= ALTEZZA-220) &&(esplosi[i] == false) ){
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

        if(esplosi[i]==true  && index[i] <= 13 && y[i] <= ALTEZZA-221){
            pioggia[i]= effettuaAnimazione(colore[i], index[i]);
            index[i] ++;
        }
    }
    public void caricaAnimazioni(){
        CaricatoreImmagine loader = new CaricatoreImmagine();
            for(int i =0;i<=13;i++){
                Arancio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
                Blu[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
                Giallo[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
                Grigio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
                Rosa[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
                Rosso[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
                Verde[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
                Viola[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
            }
    
    }
    
    public Image effettuaAnimazione(String colore, int indice){
                Image frameAnimazione = null;
                
                    if(colore=="Arancio")
                       frameAnimazione = Arancio[indice]; 
                    if(colore=="Blu")
                       frameAnimazione = Blu[indice]; 
                    
                    if(colore=="Giallo")
                        frameAnimazione = Giallo[indice]; 
                        
                    if(colore=="Grigio")
                        frameAnimazione = Grigio[indice]; 
                        
                    if(colore=="Rosa")
                        frameAnimazione = Rosa[indice]; 
                        
                    if(colore=="Rosso")
                        frameAnimazione = Rosso[indice]; 
                        
                    if(colore=="Verde")
                        frameAnimazione = Verde[indice]; 
                        
                    if(colore=="Viola")
                        frameAnimazione = Viola[indice]; 
                    
                    return frameAnimazione;
                        
        }
        
        public int gestisciMovimento(boolean controlloreMov, boolean esploso, int index ){
            int a=0;
            if(controlloreMov) 
                a=movimento;
            if(esploso)
                a=movimento+1;
            if(index > 12)
                a=2*movimento+1;
            return a;
            
        }
        
        
    
    //---------------------------------------------------------------
    // STATIC METHODS
    //---------------------------------------------------------------
    public static IModel getInstance() {
            if (instance == null)
                    instance = new Model();
            return instance;
    }

}

