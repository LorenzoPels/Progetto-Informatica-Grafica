
package view;

import controller.ControllerForView;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;

                                                                                /* 26/11
import model.Cavaliere;
import static model.Cavaliere.Loader;
import model.Model;                                                             */


import static view.BoardPanel.larghezza;
import static view.RightPanel.audiobutton;
import static view.RightPanel.escbutton;
import static view.RightPanel.musicbutton;
import static view.RightPanel.pausebutton;
import static view.BoardPanel.mago;


public class MainGUI extends JFrame implements ActionListener  {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //--------------------------------------------------------------- 
    public static BoardPanel panel;
    public final static int LARGHEZZA = 750;
    public final static int ALTEZZA = 730;
    public static Timer timer;
                                                                                
    
    public static ClipPlayer scoppio;
    public static ClipPlayer gameover;
    public static ClipPlayer sottofondo;
    public static MediaPlayer player;
    
    /*public static boolean giocoIniziato; 
    public static boolean giocoInEsecuzione;                                    */
    //---------------------------------------------------------------
    // VARIABILI PRIVATE
    //--------------------------------------------------------------- 
    private final int PAUSE = 10;
    private RightPanel rightpanel;


    MainGUI() throws FileNotFoundException, UnsupportedAudioFileException, IOException {

        super("Magic Touch Game");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
               ControllerForView.getInstance().openDialog();
               pausaGioco();
            }
             
        });
            
        setPreferredSize(new Dimension(LARGHEZZA,ALTEZZA));
        this.createPanel();
        panel = new BoardPanel();
        add(panel);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        timer = new Timer(PAUSE, this);
        final String audioScoppio = "audio/scoppio.wav";
        final String audioGO = "audio/gameover.wav";
        scoppio = new ClipPlayer(audioScoppio);
        gameover = new ClipPlayer(audioGO);
        initBackgroundSound();   
        //Model.getInstance().caricaAnimazioni();         questa cosa è molto pericolosa


    }

    //---------------------------------------------------------------
    // METODI PUBBLICI
    //---------------------------------------------------------------
    
    public void pausaGioco(){
        ControllerForView.getInstance().setGiocoInEsecuzione(false);
        timer.stop();
        //giocoiniziato = false;
        player.pause();
        ControllerForView.getInstance().setPi();
        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
        escbutton.setEnabled(true);
        musicbutton.setEnabled(true);
        audiobutton.setEnabled(true);
    }
    
@Override
    public void actionPerformed(ActionEvent e) {                                //va nel CFV? 26/11
        
        long diff = ControllerForView.getInstance().getT1() - ControllerForView.getInstance().getT0();
        
        if(diff>= ControllerForView.getInstance().getIntervalli(0)){
           ControllerForView.getInstance().statoCavaliere( 0);

        }

        if(diff>= ControllerForView.getInstance().getIntervalli(1)){
          ControllerForView.getInstance().statoCavaliere( 1);

        }

        if(diff>= ControllerForView.getInstance().getIntervalli(2)){

          ControllerForView.getInstance().statoCavaliere( 2);
        }

        if(diff>= ControllerForView.getInstance().getIntervalli(3)){

         ControllerForView.getInstance().statoCavaliere( 3);
        }

        if(diff>= ControllerForView.getInstance().getIntervalli(4)){
           ControllerForView.getInstance().statoCavaliere( 4);

        }

         this.panel.repaint();       
        //repaint();
    }
        
    //---------------------------------------------------------------
    // METODI PRIVATI
    //---------------------------------------------------------------
    
    private void createPanel() {
                 
        this.rightpanel = new RightPanel();
        Container contPane = this.getContentPane();
        contPane.setLayout(new BorderLayout());
        contPane.add(this.rightpanel,BorderLayout.EAST);

    }   
        
    

    public static void initBackgroundSound() {
        final JFXPanel fxPanel = new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override public void run() {  

                Media audioFile = new Media(new File("audio/sottofondo.mp3").toURI().toString());
                player = new MediaPlayer(audioFile);
               player.setCycleCount(MediaPlayer.INDEFINITE);
               player.setVolume(0.7);

            }
        });
    }

    public static void startPauseEvent() {
   
        if (!ControllerForView.getInstance().getGiocoIniziato()) {
                ControllerForView.getInstance().setGiocoIniziato(true);
                ControllerForView.getInstance().setGiocoInEsecuzione(true);
                ControllerForView.getInstance().Cavalieri();
                ControllerForView.getInstance().Pioggia();
                ControllerForView.getInstance().Esplosi();
                player.play();
                timer.start();
                ControllerForView.getInstance().setT0();
                mago.setXMagoMax(larghezza-150);
                mago.setXMagoMin(50);
                mago.resetMago();
                panel.requestFocusInWindow();
        }
        else if (!ControllerForView.getInstance().getGiocoInEsecuzione()) {
                ControllerForView.getInstance().setGiocoInEsecuzione(true);
                ControllerForView.getInstance().setPf();
                panel.requestFocusInWindow();
                player.play();
                long P = ControllerForView.getInstance().getP();
                 P += ControllerForView.getInstance().getPf()- ControllerForView.getInstance().getPi();
                 ControllerForView.getInstance().setP(P);
                timer.start();
                
        }
        else {
                ControllerForView.getInstance().setGiocoInEsecuzione(false);
                timer.stop();             
                player.pause();
                ControllerForView.getInstance().setPi();               
        }
    } // end methos startStopEvent()

    
    public static BoardPanel getPanel(){
        return panel;    
    }


    public static void main(String[] args) {

         try {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 try {
                    new MainGUI(/*audioScoppio,audioGO*/).setVisible(true);

                }
                catch(FileNotFoundException fnfe) {

                }
                catch(UnsupportedAudioFileException uafe) {

                }
                catch(IOException ioe) {

                }
            }
            });
        } catch(Exception e) {}
    }
  
}
