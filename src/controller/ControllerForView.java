
package controller;

import model.Model;
import view.View;


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
        
        public void initGame() {
		Model.getInstance().initGame();
	}
        public String getScore() {
		return String.valueOf(Model.getInstance().getScore());
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
