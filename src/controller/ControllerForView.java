
package controller;

import model.Model;
import view.View;
import java.lang.String;
import model.Cavaliere;
import static view.MainGUI.cavalieri;
import static view.MainGUI.esplosi;
import static view.MainGUI.pioggia;
import static view.MainGUI.scoppio;
import static view.RightPanel.updateScoreLabel;


public class ControllerForView implements IControllerForView {
        //---------------------------------------------------------------
	// STATIC FIELDS
	//---------------------------------------------------------------
	private final static int SCORE_FACTOR = 10;
	private static ControllerForView instance = null;

	private ControllerForView() {
		//to-do
	}
         
	
        //---------------------------------------------------------------
	// PUBLIC INSTANCE METHODS
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

        public void incrementScore(/*int increment*/) {
		Model.getInstance().incrementScore(/*increment*/);
	}
        
        public void Colpito(boolean b, String s){
           Model.getInstance().Colpito(b, s);
            
        }
       

        //---------------------------------------------------------------
	// STATIC METHODS
	//---------------------------------------------------------------
	public static IControllerForView getInstance() {
		if (instance == null)
			instance = new ControllerForView();
		return instance;
	}
}
