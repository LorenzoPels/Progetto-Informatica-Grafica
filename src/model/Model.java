
package model;

import view.BoardPanel;
import view.MainGUI;
import static view.MainGUI.P;
import static view.RightPanel.scorelabel;
import static view.MainGUI.cavalieri;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.Pi;
import static view.MainGUI.Pf;
import static view.MainGUI.cavalieri;
import static view.MainGUI.esplosi;
import static view.MainGUI.giocoiniziato;
import static view.MainGUI.isGameRunning;
import static view.MainGUI.isGameStarted;
import static view.MainGUI.y0;
import static view.MainGUI.y1;
import static view.MainGUI.y2;
import static view.MainGUI.y3;
import static view.MainGUI.y4;
import static view.MainGUI.int0;
import static view.MainGUI.int1;
import static view.MainGUI.int2;
import static view.MainGUI.int3;
import static view.MainGUI.int4;
import static view.MainGUI.int5;
import static view.MainGUI.index0;
import static view.MainGUI.index1;
import static view.MainGUI.index2;
import static view.MainGUI.index3;
import static view.MainGUI.index4;
import static view.MainGUI.timer;


import static view.MainGUI.movimento;
import static view.MainGUI.pioggia;
import static view.MainGUI.player;
import static view.MainGUI.scoppio;
import static view.RightPanel.updateScoreLabel;
import static view.StartWindow.insane;
import view.View;


public class Model implements IModel {
    
    //---------------------------------------------------------------
    // STATIC FIELDS
    //---------------------------------------------------------------
    private static Model instance = null;
    private Cavaliere fallingPiece;
    
    //---------------------------------------------------------------
    // INSTANCE ATTRIBUTES
    //---------------------------------------------------------------
    public  int score;
    private Model() {
		//this.boardArray = new int[DEFAULT_NUM_ROWS][DEFAULT_NUM_COLUMNS];
		this.initGame();
	}
    
    //---------------------------------------------------------------
    // PUBLIC INSTANCE METHODS
    //---------------------------------------------------------------
    public void initGame() {
                isGameRunning = false;
                isGameStarted = false;
                giocoiniziato = false;
		this.score= 0;
		//scorelabel.setText("0");
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
                //int5=5400;
                index0=index1=index2=index3=index4=0;
                y0 = y1 = y2 = y3 = y4 = -150;
      
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
    public  void incrementScore(/*int increment*/) {
		this.score ++;
	}
    
    public void Colpito(boolean b, String s){
            //b = false;
            for(int i =0;(i<cavalieri.length)&&(b==false);i++){
                            if((cavalieri[i].getName()== s) && (esplosi[i]==false)){
                  /*              try {
                                    animazione(cavalieri[i], i );
                                } catch (IOException ex) {
                                    Logger.getLogger(BoardPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }                   */
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
    //---------------------------------------------------------------
    // STATIC METHODS
    //---------------------------------------------------------------
    public static IModel getInstance() {
            if (instance == null)
                    instance = new Model();
            return instance;
    }

}

