
package view;

import config.Config;
import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import model.Model;
import static view.GameOverDialog.centinaia;
import static view.GameOverDialog.decine;
import static view.GameOverDialog.recordlabel;
import static view.GameOverDialog.unità;


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
        protected String finalscore;
        private String cifre;
        private char cifreU;
        private char cifreD;
        private char cifreH;
        
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
                    //final String audioScoppio = "audio/scoppio.wav";
                   // final String audioGO = "audio/gameover.wav";
                    
			public void run() {
				if (mainGUI == null)
                                try {
                                    mainGUI = new MainGUI(/*audioScoppio,audioGO*/);
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
                        //decine.setText(ControllerForView.getInstance().getScore());
                        cifre = ControllerForView.getInstance().getScore();
                        centinaia.setIcon(/*new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreH+".jpg"))*/null);
                        decine.setIcon(/*new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreD+".jpg"))*/null);
                        unità.setIcon(/*new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg"))*/null);
                        centinaia.setBounds(20, 170, 70, 110);
                        decine.setBounds(90, 170, 70, 110);
                        unità.setBounds(160, 170, 70, 110);
                        
                        if(cifre.length() ==3){
                            cifreH = cifre.charAt(0);
                            cifreD = cifre.charAt(1);
                            cifreU = cifre.charAt(2);
                            centinaia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreH+".jpg")));
                            decine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreD+".jpg")));
                            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
                            centinaia.setBounds(90, 170, 70, 110);
                            unità.setBounds(230, 170, 70, 110);
                            decine.setBounds(160, 170, 70, 110);
                        }

                        if(cifre.length() ==2){
                            cifreD = cifre.charAt(0);
                            cifreU = cifre.charAt(1);
                            //cifreH = cifre.charAt(2);
                            decine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreD+".jpg")));
                            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
                            unità.setBounds(200, 170, 70, 110);
                            decine.setBounds(130, 170, 70, 110);

                        }
                        if(cifre.length() ==1){
                            cifreU = cifre.charAt(0);
                            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
                            //cifreD = cifre.charAt(1);
                           // cifreU = cifre.charAt(2);
                        }
                        finalscore=ControllerForView.getInstance().getScore();
                       if(Integer.parseInt(/*decine.getText()*/finalscore) > Integer.parseInt(recordlabel.getText())){
                            try {
                                Config.Write(decine.getText());
                                recordlabel.setText(decine.getText());
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
