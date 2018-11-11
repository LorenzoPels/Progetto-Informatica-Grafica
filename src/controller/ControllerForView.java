
package controller;

import model.Model;
import view.View;



public class ControllerForView implements IControllerForView {
        //---------------------------------------------------------------
	// VARIABILI STATICHE
	//---------------------------------------------------------------
	private static ControllerForView instance = null;

	private ControllerForView() {
		//to-do
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
        
        public void Colpito(boolean b, String s){
           Model.getInstance().Colpito(b, s);
            
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
