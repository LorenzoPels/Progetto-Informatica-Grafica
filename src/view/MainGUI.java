
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
import static view.View.xMagoMax;
import static view.View.xMagoMin;
import static view.BoardPanel.mago;
import static view.BoardPanel.arrayMago;
import static view.RightPanel.audiobutton;
import static view.RightPanel.escbutton;
import static view.RightPanel.musicbutton;
import static view.RightPanel.pausebutton;
import static view.RightPanel.scorelabel;


public class MainGUI extends JFrame implements ActionListener  {
    public static BoardPanel panel;
    public final static int LARGHEZZA = 750;
    public final static int ALTEZZA = 730;
    private int altezza;
    private RightPanel rightpanel;
    public static Timer timer;
    public static int  y0,y1,y2,y3,y4;
    private final int PAUSE = 10;
    public static  int movimento;
    private boolean controlloreMovimento0,controlloreMovimento1,controlloreMovimento2,controlloreMovimento3,controlloreMovimento4;
    //public static Boolean giocoiniziato = false;
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
    private String coloreC0,coloreC1,coloreC2,coloreC3,coloreC4;
    private Boolean exp0 = false;
    /*private Image[] Arancio = new Image[14];
    private Image[] Blu = new Image[14];
    private Image[] Giallo = new Image[14];
    private Image[] Grigio = new Image[14];
    private Image[] Rosa = new Image[14];
    private Image[] Rosso = new Image[14];
    private Image[] Verde = new Image[14];
    private Image[] Viola = new Image[14];  */        
    public static int index0,index1,index2,index3,index4;
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
         
        y0 = -150;
        y1 = -150;
        y2 = -150;
        y3 = -150;
        y4 = -150;
        
       

        timer = new Timer(PAUSE, this);
        final String audioScoppio = "audio/scoppio.wav";
        final String audioGO = "audio/gameover.wav";

        scoppio = new ClipPlayer(audioScoppio);
        gameover = new ClipPlayer(audioGO);

        initBackgroundSound();   
        altezza = getHeight();
        /*CaricatoreImmagine loader = new CaricatoreImmagine();
            for(int i =0;i<=13;i++){
                Arancio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
                Blu[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
                Giallo[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
                Grigio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
                Rosa[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
                Rosso[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
                Verde[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
                Viola[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
            }*/
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
                //MediaPlayer player;
                //ContinuousAudioDaataStream
                Media audioFile = new Media(new File("audio/sottofondo.mp3").toURI().toString());
                player = new MediaPlayer(audioFile);
               player.setCycleCount(MediaPlayer.INDEFINITE);
               player.setVolume(0.7);


               // player.play();
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
                xMagoMax = larghezza-150 ;        
                xMagoMin = 50;
                mago = arrayMago[0];
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
        /*public Image effettuaAnimazione(String colore, int indice){
                Image frameAnimazione = null;
                
                    if(colore=="Arancio")
                       frameAnimazione = Arancio[indice]; 
                    if(colore=="Blu")
                       frameAnimazione = Blu[indice]; 
                    
                    if(colore=="Giallo")
                        frameAnimazione = Giallo[indice]; 
                        
                    if(colore=="Grigio")
                        frameAnimazione = Grigio[indice]; 
                        
                    if(colore=="Rosa")
                        frameAnimazione = Rosa[indice]; 
                        
                    if(colore=="Rosso")
                        frameAnimazione = Rosso[indice]; 
                        
                    if(colore=="Verde")
                        frameAnimazione = Verde[indice]; 
                        
                    if(colore=="Viola")
                        frameAnimazione = Viola[indice]; 
                    
                    return frameAnimazione;
                        
        }
        
        public int gestisciMovimento(boolean controlloreMov, boolean esploso, int index ){
            int a=0;
            if(controlloreMov) 
                a=movimento;
            if(esploso)
                a=movimento+1;
            if(index > 12)
                a=2*movimento+1;
            return a;
            
        }*/
        

   
}
