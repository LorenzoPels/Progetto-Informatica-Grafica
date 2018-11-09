
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
import static java.lang.Thread.sleep;      
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Cavaliere;
import static model.Cavaliere.Loader;
import model.Model;
import static view.BoardPanel.larghezza;
//import static view.BoardPanel.mago;
//import static view.BoardPanel.arrayMago;
import static view.RightPanel.audiobutton;
import static view.RightPanel.escbutton;
import static view.RightPanel.musicbutton;
import static view.RightPanel.pausebutton;
import static view.RightPanel.scorelabel;
//import static model.Model.xMagoMax;
//import static model.Model.xMagoMin;

import model.Mago;
import static view.BoardPanel.maggo;


public class MainGUI extends JFrame implements ActionListener  {
    public static BoardPanel panel;
    public final static int LARGHEZZA = 750;
    public final static int ALTEZZA = 730;
    private RightPanel rightpanel;
    public static Timer timer;
    private final int PAUSE = 10;
    public static  int movimento;
    public static Image[] pioggia = new Image[5];
    public static Cavaliere[] cavalieri = new Cavaliere[5];
    public static Boolean[] esplosi = new Boolean[5];
    public static long t0,t1,P,Pi,Pf;
    public static long diff;
    public static int int0;
    public static int int1;
    public static int int2;
    public static int int3;
    public static int int4;
    public static int int5;
    public static ClipPlayer scoppio;
    public static ClipPlayer gameover;
    public static ClipPlayer sottofondo;
    public static MediaPlayer player;
    private Boolean exp0 = false;
    public static boolean isGameStarted; // a game can start only once at the beginning
    public static boolean isGameRunning; // a started game can be running or in pause
    


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
        Model.getInstance().caricaAnimazioni();


    }

    

    public static Cavaliere[] Cavalieri(){

        for(int i=0; i<cavalieri.length;i++)  
            cavalieri[i] = Cavaliere.nextCavaliere();

       return cavalieri;
    }


     public static Image[] Pioggia(){
        for(int i=0; i<cavalieri.length;i++)  
            pioggia[i] = Loader(cavalieri[i]);
        return pioggia;
        }

     public static void Esplosi(){
        for(int i=0; i<cavalieri.length;i++)  
            esplosi[i] = false;
        //return esplosi;
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

    public void pausaGioco(){
                    isGameRunning = false;
                    timer.stop();
                    //giocoiniziato = false;
                    player.pause();
                    Pi = System.currentTimeMillis();
                    pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
                    escbutton.setEnabled(true);
                    musicbutton.setEnabled(true);
                    audiobutton.setEnabled(true);
    }
    
    public static void startPauseEvent() {
        if (!isGameStarted) {
                isGameStarted = true;
                isGameRunning = true;
                Cavalieri();
                Pioggia();
                Esplosi();
                player.play();
                timer.start();
                //giocoiniziato = true;
                t0 = System.currentTimeMillis();
            /*    xMagoMax = larghezza-150 ;        
                xMagoMin = 50;
                mago = arrayMago[0];        */
            
                maggo.setXMagoMax(larghezza-150);
                maggo.setXMagoMin(50);
                maggo.resetMago();
            
                panel.requestFocusInWindow();
        }
        else if (!isGameRunning) {
                isGameRunning = true;
                Pf = System.currentTimeMillis();
                panel.requestFocusInWindow();
                player.play();
                P += Pf-Pi;
                timer.start();
                //giocoiniziato = true;
        }
        else {
                isGameRunning = false;
                timer.stop();
               // giocoiniziato = false;
                player.pause();
                Pi = System.currentTimeMillis();
                
        }
    } // end methos startStopEvent()

    private void createPanel() {
                 
        this.rightpanel = new RightPanel();
        Container contPane = this.getContentPane();
        contPane.setLayout(new BorderLayout());
        contPane.add(this.rightpanel,BorderLayout.EAST);

    }


      @Override
        public void actionPerformed(ActionEvent e) {

            if(diff>=int0){
               Model.getInstance().statoCavaliere( 0);
               
            }

            if(diff>=int1){
               Model.getInstance().statoCavaliere( 1);
                
            }

            if(diff>=int2){
               
              Model.getInstance().statoCavaliere( 2);
            }

            if(diff>=int3){
                
             Model.getInstance().statoCavaliere( 3);
            }

            if(diff>=int4){
               Model.getInstance().statoCavaliere( 4);
                
            }

             this.panel.repaint();       
            //repaint();
        }

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
