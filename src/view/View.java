
package view;


public class View implements IView {
        //---------------------------------------------------------------
	// STATIC FIELDS
	//---------------------------------------------------------------
	private static View instance = null;
        
        //---------------------------------------------------------------
	// INSTANCE ATTRIBUTES
	//---------------------------------------------------------------
	protected StartWindow startWindow = null;
        protected MainGUI mainGUI = null;
        protected Dialog dialog = null;
        protected GameOverDialog gameover = null;
        protected RightPanel rightpanel = null;
        protected BoardPanel boardpanel = null;
        
        private View() {
		//TO-DO
	}

	//---------------------------------------------------------------
	// INSTANCE METHODS
	//---------------------------------------------------------------
        
        public void openStartWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (startWindow == null)
					startWindow = new StartWindow();
				startWindow.setVisible(true);
			}
		});
	}

	public void closeStartWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (startWindow != null)
					startWindow.setVisible(false);
			}
		});
	}
        
        public void openMainGUI() {
            
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    
			public void run() {
				if (mainGUI == null)
					mainGUI = new MainGUI();
				mainGUI.setVisible(true);
			}
		});
	}
        public void closeMainGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (mainGUI != null)
                                    mainGUI.setVisible(false);
			}
		});
	}
        public void openDialog() {
            
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    
			public void run() {
				if (dialog == null)
					dialog = new Dialog();
				dialog.setVisible(true);
			}
		});
	}
        public void closeDialog() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (dialog != null)
                                    dialog.setVisible(false);
			}
		});
	}
         public void openGameOverDialog() {
            
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    
			public void run() {
				if (gameover == null)
					gameover = new GameOverDialog();
				gameover.setVisible(true);
			}
		});
	}
        public void closeGameOverDialog() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				if (gameover != null)
                                    gameover.setVisible(false);
			}
		});
	}
        public void updateScoreLabel(int score) {
		this.rightpanel.updateScoreLabel(score);
	}
        //---------------------------------------------------------------
	// STATIC METHODS
	//---------------------------------------------------------------
	public static IView getInstance() {
		if (instance == null)
			instance = new View();
		return instance;
	}
}
