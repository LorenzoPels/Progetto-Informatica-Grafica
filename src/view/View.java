
package view;

import config.Config;
import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import model.Model;
import static view.GameOverDialog.finalscorelabel;
import static view.GameOverDialog.recordlabel;


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
                    final String audioScoppio = "audio/scoppio.wav";
                    final String audioGO = "audio/gameover.wav";
                    
			public void run() {
				if (mainGUI == null)
                                try {
                                    mainGUI = new MainGUI(audioScoppio,audioGO);
                                } catch (UnsupportedAudioFileException ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (IOException ex) {
                                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
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
         public void openGameOverDialog(String score) {
            
            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                    public void run() {
                        if (gameover == null)
                                try {
                                    gameover = new GameOverDialog();
                                    Config.Read();
                        } catch (IOException ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        gameover.setVisible(true);
                        finalscorelabel.setText(ControllerForView.getInstance().getScore());
                       if(Integer.parseInt(finalscorelabel.getText()) > Integer.parseInt(recordlabel.getText())){
                            try {
                                Config.Write(finalscorelabel.getText());
                                recordlabel.setText(finalscorelabel.getText());
                        } catch (IOException ex) {
                            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                          }
                        }
                       //System.out.println(recordlabel.getText());

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
