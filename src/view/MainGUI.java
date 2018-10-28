
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
import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Cavaliere;
import static model.Cavaliere.Loader;
import model.Model;


import static view.BoardPanel.larghezza;
import static view.BoardPanel.xMagoMax;
import static view.BoardPanel.xMagoMin;
import static view.BoardPanel.mago;
import static view.BoardPanel.arrayMago;

import static view.RightPanel.scorelabel;






public class MainGUI extends JFrame implements ActionListener  {
    public static BoardPanel panel;
    private final static int LARGHEZZA = 750;
    private final static int ALTEZZA = 730;
    private RightPanel rightpanel;
    private static Timer timer;
    public static int  y0,y1,y2,y3,y4;
    private final int PAUSE = 10;
    public static  int movimento;
    private boolean controlloreMovimento0,controlloreMovimento1,controlloreMovimento2,controlloreMovimento3,controlloreMovimento4;

    public static Boolean giocoiniziato = false;
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
    
    
   private Image[] Arancio = new Image[14];
    private Image[] Blu = new Image[14];
    private Image[] Giallo = new Image[14];
    private Image[] Grigio = new Image[14];
    private Image[] Rosa = new Image[14];
    private Image[] Rosso = new Image[14];
    private Image[] Verde = new Image[14];
    private Image[] Viola = new Image[14];          

    public static int index0,index1,index2,index3,index4;
//int index;


    MainGUI(/*String audioScoppio,String audioGO*/) throws FileNotFoundException, UnsupportedAudioFileException, IOException {

        super("Magic Touch Game");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
               ControllerForView.getInstance().openDialog();
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
        //  caricaAnimazioni();
        CaricatoreImmagine loader = new CaricatoreImmagine();
            for(int i =0;i<=13;i++){
                Arancio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
                Blu[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
                Giallo[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
                Grigio[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
                Rosa[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
                Rosso[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
                Verde[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
                Viola[i]= loader.caricaImmagine("/immagini/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
            }



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

    public static Boolean InizioGioco(){
            Cavalieri();
            //sottofondo.play();
            player.play();
            Pioggia();
            Esplosi();
            timer.start();
            giocoiniziato = true;
            t0 = System.currentTimeMillis();
           
            
            xMagoMax = larghezza-150 ;        
            xMagoMin = 50;
            mago = arrayMago[0];
                    
            return giocoiniziato;
        }
    public static Boolean  PausaGioco(){
                timer.stop();
                giocoiniziato = false;
                player.pause();
                Pi = System.currentTimeMillis();

                return giocoiniziato;
            } 
    public static Boolean  RiprendiGioco(){
                Pf = System.currentTimeMillis();
                //sottofondo.play();
                player.play();
                P += Pf-Pi;
                timer.start();
                giocoiniziato = true;
                //t1 = System.currentTimeMillis()-P;
                return giocoiniziato;
            } 

    private void createPanel() {
                 
                    this.rightpanel = new RightPanel();
          
                    Container contPane = this.getContentPane();
                    contPane.setLayout(new BorderLayout());
                    contPane.add(this.rightpanel,BorderLayout.EAST);
                    
            }


      @Override
        public void actionPerformed(ActionEvent e) {

           if(diff>=int0){
               //System.out.println(MOVIMENTO0);
                y0 += gestisciMovimento(controlloreMovimento0, esplosi[0],index0);
                
                if(y0 >= -1000) controlloreMovimento0 = true;
                if(y0 >= getHeight()-220) controlloreMovimento0 = false;
                if((y0 >= getHeight()-220) &&(esplosi[0] == true)){
                    pioggia[0]= null;
                    index0=0;
                    
                    //exp0=false;

                }
                   // esplosi[0] = true;
                if((y0 >= getHeight()-220) &&(esplosi[0] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1500);
                        //PausaGioco();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     player.stop();
                    ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());

                }

                if(esplosi[0] == false){
                     coloreC0 = cavalieri[0].getColore();
                }

                if(esplosi[0]==true  && index0 <= 13 && y0 <= getHeight()-221){
                    
                    pioggia[0]= effettuaAnimazione(coloreC0, index0);

                 
                    index0 ++;
                 
                    
                   

                }
            }

            if(diff>=int1){
                
                y1 += gestisciMovimento(controlloreMovimento1, esplosi[1], index1);
                
                
                if(y1 >= -1000) controlloreMovimento1 = true;
                if(y1 >= getHeight()-220) controlloreMovimento1 = false;
               if((y1 >= getHeight()-220) &&(esplosi[1] == true)){
                    pioggia[1]= null;
                    index1=0;
                }
                   // esplosi[0] = true;
                if((y1 >= getHeight()-220) &&(esplosi[1] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1500);
                        //PausaGioco();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // PausaGioco();
                    player.stop();
                    ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());

                }

                if(esplosi[1] == false){
                     coloreC1 = cavalieri[1].getColore();
                }

                if(esplosi[1]==true  && index1 <= 13 && y1 <= getHeight()-221){


                  
                    pioggia[1]= effettuaAnimazione(coloreC1, index1);
                   
     
                    index1 ++;                              
                }
            }

            if(diff>=int2){
               
                y2 += gestisciMovimento(controlloreMovimento2, esplosi[2], index2);
                
                if(y2 >= -1000) controlloreMovimento2 = true;
                if(y2 >= getHeight()-220) controlloreMovimento2 = false;
                if((y2 >= getHeight()-220) &&(esplosi[2] == true)){
                    pioggia[2]= null;
                    index2=0;
                }
                   // esplosi[0] = true;
                if((y2 >= getHeight()-220) &&(esplosi[2] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1500);
                        //PausaGioco();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // PausaGioco();
                    player.stop();
                    ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());

                }

                if(esplosi[2] == false){
                     coloreC2 = cavalieri[2].getColore();
                }

                if(esplosi[2]==true  && index2 <= 13 && y2 <= getHeight()-221){


              
                    pioggia[2]= effettuaAnimazione(coloreC2, index2);
                
                    index2 ++;
                }
            }

            if(diff>=int3){
                
                y3 += gestisciMovimento(controlloreMovimento3, esplosi[3],index3);
                
                if(y3 >= -1000) controlloreMovimento3 = true;
                if(y3 >= getHeight()-220) controlloreMovimento3 = false;
                if((y3 >= getHeight()-220) &&(esplosi[3] == true)){
                    pioggia[3]= null;
                    index3=0;
                }
                   // esplosi[0] = true;
                if((y3 >= getHeight()-220) &&(esplosi[3] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1500);
                        //PausaGioco();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // PausaGioco();
                    player.stop();
                    ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());

                }
                if(esplosi[3] == false){
                     coloreC3 = cavalieri[3].getColore();
                }

                if(esplosi[3]==true  && index3 <= 13 && y3 <= getHeight()-221){


                   
                    pioggia[3]= effettuaAnimazione(coloreC3, index3);
                   
             
                    index3 ++;
                }
            }

            if(diff>=int4){
                
                y4 += gestisciMovimento(controlloreMovimento4, esplosi[4], index4);
                
                if(y4 >= -1000) controlloreMovimento4 = true;
                if(y4 >= getHeight()-220) controlloreMovimento4 = false;
                if((y4 >= getHeight()-220) &&(esplosi[4] == true)){
                    pioggia[4]= null;
                    index4=0;
                }
                   // esplosi[0] = true;
                if((y4 >= getHeight()-220) &&(esplosi[4] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1500);
                        //PausaGioco();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    player.stop();
                    ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
                }

                if(esplosi[4] == false){
                     coloreC4 = cavalieri[4].getColore();
                }

                if(esplosi[4]==true  && index4 <= 13 && y4 <= getHeight()-221){


                        pioggia[4]= effettuaAnimazione(coloreC4, index4);
       
                    index4 ++;
                }
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
        public Image effettuaAnimazione(String colore, int indice){
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
            
        }
        

   
}
