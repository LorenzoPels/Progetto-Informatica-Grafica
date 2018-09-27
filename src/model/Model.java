
package model;

import view.MainGUI;
import static view.MainGUI.P;
import static view.RightPanel.scorelabel;
import static view.MainGUI.cavalieri;
import static view.MainGUI.pioggia;
import static view.MainGUI.t0;
import static view.MainGUI.t1;
import static view.MainGUI.Pi;
import static view.MainGUI.Pf;
import static view.MainGUI.giocoiniziato;
import static view.MainGUI.MOVIMENTO;
import static view.RightPanel.isGameRunning;
import static view.RightPanel.isGameStarted;
import static view.RightPanel.jButton1;
import static view.RightPanel.jButton2;
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
    
   /* public void Init(){
        scorelabel.setText("0");
        for(int i=0; i<cavalieri.length;i++){
            cavalieri[i]=null;
            pioggia[i]=null;
            
        }
        //t0=urentTimeMillis();    
        
    }*/
    
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
                int0=1000;
                int1=3000;
                int2=4000;
                int3=7000;
                int4=8000;
                int5=10000;
                y0 = y1 = y2 = y3 = y4 = -100;
      
                t0=t1=P=Pi=Pf=0;
                MOVIMENTO=1;
                //jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
		//jButton2.setEnabled(true);
                
		//this.initBoardArray(DEFAULT_NUM_ROWS, DEFAULT_NUM_COLUMNS);
		//this.iIndex = I_INDEX_INIT;
		//this.jIndex = J_INDEX_INIT;
		//this.previewPiece = Piece.randomPreviewPiece();
		//this.fallingPiece = Cavaliere.nextFallingPiece();
		//this.previewPiece = Piece.randomPreviewPiece();
	}
        
    public int getScore() {
		return this.score;
	}
    public  void incrementScore(/*int increment*/) {
		this.score ++;
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

