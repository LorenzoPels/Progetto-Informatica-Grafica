
package view;

import controller.ControllerForView;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import static view.RightPanel.scorelabel;





public class MainGUI extends JFrame implements ActionListener  {
    public static BoardPanel panel;
    private final static int LARGHEZZA = 750;
    private final static int ALTEZZA = 730;
    private RightPanel rightpanel;
    private static Timer timer;
    public static int x, y0,y1,y2,y3,y4;
    private final int PAUSE = 10;
    public static  int MOVIMENTO0,MOVIMENTO1,MOVIMENTO2,MOVIMENTO3,MOVIMENTO4;
    private boolean motionControl0,motionControl1,motionControl2,motionControl3,motionControl4;

    public static Boolean giocoiniziato = false;
    public static Image[] pioggia = new Image[5];
    public static Cavaliere[] cavalieri = new Cavaliere[5];
    public static Boolean[] esplosi = new Boolean[5];

    public static long t0,t1,P,Pi,Pf;
    public static long diff;
    public static int int0=500;
    public static int int1=1000;
    public static int int2=1500;
    public static int int3=2000;
    public static int int4=2500;
    public static int int5=3000;
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

    static int index0,index1,index2,index3,index4;
//int index;


    MainGUI(/*String audioScoppio,String audioGO*/) throws FileNotFoundException, UnsupportedAudioFileException, IOException {

        super("Magic Touch Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(LARGHEZZA,ALTEZZA));
        this.createPanel();
        panel = new BoardPanel();
        add(panel);
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        x = 200;
        y0 = -100;
        y1 = -100;
        y2 = -100;
        y3 = -100;
        y4 = -100;


        timer = new Timer(PAUSE, this);
        final String audioScoppio = "audio/scoppio.wav";
        final String audioGO = "audio/gameover.wav";

        scoppio = new ClipPlayer(audioScoppio);
        gameover = new ClipPlayer(audioGO);


        initBackgroundSound();   
        caricaAnimazioni();



    }

    public void caricaAnimazioni(){
        CaricatoreImmagine loader = new CaricatoreImmagine();
        for(int i =0;i<=13;i++){
            Arancio[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereArancio/cavaliereArancio"+i+ ".png");
            Blu[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereBlu/cavaliereBlu"+i+ ".png");
            Giallo[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereGiallo/cavaliereGiallo"+i+ ".png");
            Grigio[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereGrigio/cavaliereGrigio"+i+ ".png");
            Rosa[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereRosa/cavaliereRosa"+i+ ".png");
            Rosso[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereRosso/cavaliereRosso"+i+ ".png");
            Verde[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereVerde/cavaliereVerde"+i+ ".png");
            Viola[i]= loader.caricaImmagine("/Cavalieri/Animazioni/cavaliereViola/cavaliereViola"+i+ ".png");
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
                    //this.addComponentListener(this);
                    //this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
                    //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    //this.setPreferredSize(new Dimension(WINDOW_PREFERRED_WIDTH, WINDOW_PREFERRED_HEIGHT));
                    this.rightpanel = new RightPanel();
                    //this.setRightPanel();
                    Container contPane = this.getContentPane();
                    contPane.setLayout(new BorderLayout());
                    contPane.add(this.rightpanel,BorderLayout.EAST);
                    //contPane.add(rightpanel, BorderLayout.EAST);
                    //this.pack();
            }


      @Override
        public void actionPerformed(ActionEvent e) {

           if(diff>=int0){
               //System.out.println(MOVIMENTO0);
                y0 += (motionControl0) ? MOVIMENTO0: /*-MOVIMENTO*/0;
                if(y0 >= -101) motionControl0 = true;
                if(y0 >= getHeight()-220) motionControl0 = false;
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
                        sleep(1900);
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


                    //try {
                    if(coloreC0=="Arancio")
                        pioggia[0]=Arancio[index0];
                    if(coloreC0=="Blu")
                        pioggia[0]=Blu[index0];
                    if(coloreC0=="Giallo")
                        pioggia[0]=Giallo[index0];
                    if(coloreC0=="Grigio")
                        pioggia[0]=Grigio[index0];
                    if(coloreC0=="Rosa")
                        pioggia[0]=Rosa[index0];
                    if(coloreC0=="Rosso")
                        pioggia[0]=Rosso[index0];
                    if(coloreC0=="Verde")
                        pioggia[0]=Verde[index0];
                    if(coloreC0=="Viola")
                        pioggia[0]=Viola[index0];
                        // pioggia[0] = ImageIO.read(getClass().getResource("/Cavalieri/Animazioni/cavaliere"+ coloreC0 +"/cavaliere"+ coloreC0+index0+ ".png"));
                   /* } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                    //MainGUI.getPanel().repaint();
                    index0 ++;
                   if((esplosi[0]==true) &&(exp0==false)){
                    MOVIMENTO0 +=2;
                    exp0=true;
                    }

                    /*if((index0==0) &&(exp0==true)){
                        MOVIMENTO0 = MOVIMENTO0-4;
                        exp0=false;

                    }*/


                }
            }

            if(diff>=int1){
                y1 += (motionControl1) ? MOVIMENTO1: /*MOVIMENTO*/0;
                if(y1 >= -101) motionControl1 = true;
                if(y1 >= getHeight()-220) motionControl1 = false;
               if((y1 >= getHeight()-220) &&(esplosi[1] == true)){
                    pioggia[1]= null;
                    index1=0;
                }
                   // esplosi[0] = true;
                if((y1 >= getHeight()-220) &&(esplosi[1] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1900);
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


                   /* try {
                        pioggia[1] = ImageIO.read(getClass().getResource("/Cavalieri/Animazioni/cavaliere"+ coloreC1 +"/cavaliere"+ coloreC1+index1+ ".png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //MainGUI.getPanel().repaint();*/
                    if(coloreC1=="Arancio")
                        pioggia[1]=Arancio[index1];
                    if(coloreC1=="Blu")
                        pioggia[1]=Blu[index1];
                    if(coloreC1=="Giallo")
                        pioggia[1]=Giallo[index1];
                    if(coloreC1=="Grigio")
                        pioggia[1]=Grigio[index1];
                    if(coloreC1=="Rosa")
                        pioggia[1]=Rosa[index1];
                    if(coloreC1=="Rosso")
                        pioggia[1]=Rosso[index1];
                    if(coloreC1=="Verde")
                        pioggia[1]=Verde[index1];
                    if(coloreC1=="Viola")
                        pioggia[1]=Viola[index1];
                    index1 ++;
                }
            }

            if(diff>=int2){
                y2 += (motionControl2) ? MOVIMENTO2: /*MOVIMENTO*/0;
                if(y2 >= -101) motionControl2 = true;
                if(y2 >= getHeight()-220) motionControl2 = false;
                if((y2 >= getHeight()-220) &&(esplosi[2] == true)){
                    pioggia[2]= null;
                    index2=0;
                }
                   // esplosi[0] = true;
                if((y2 >= getHeight()-220) &&(esplosi[2] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1900);
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


                   /* try {
                        pioggia[2] = ImageIO.read(getClass().getResource("/Cavalieri/Animazioni/cavaliere"+ coloreC2 +"/cavaliere"+ coloreC2+index2+ ".png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //MainGUI.getPanel().repaint();*/
                    if(coloreC2=="Arancio")
                        pioggia[2]=Arancio[index2];
                    if(coloreC2=="Blu")
                        pioggia[2]=Blu[index2];
                    if(coloreC2=="Giallo")
                        pioggia[2]=Giallo[index2];
                    if(coloreC2=="Grigio")
                        pioggia[2]=Grigio[index2];
                    if(coloreC2=="Rosa")
                        pioggia[2]=Rosa[index2];
                    if(coloreC2=="Rosso")
                        pioggia[2]=Rosso[index2];
                    if(coloreC2=="Verde")
                        pioggia[2]=Verde[index2];
                    if(coloreC2=="Viola")
                        pioggia[2]=Viola[index2];
                    index2 ++;
                }
            }

            if(diff>=int3){
                y3 += (motionControl3) ? MOVIMENTO3:/* MOVIMENTO*/0;
                if(y3 >= -101) motionControl3 = true;
                if(y3 >= getHeight()-220) motionControl3 = false;
                if((y3 >= getHeight()-220) &&(esplosi[3] == true)){
                    pioggia[3]= null;
                    index3=0;
                }
                   // esplosi[0] = true;
                if((y3 >= getHeight()-220) &&(esplosi[3] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1900);
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


                   /* try {
                        pioggia[3] = ImageIO.read(getClass().getResource("/Cavalieri/Animazioni/cavaliere"+ coloreC3 +"/cavaliere"+ coloreC3+index3+ ".png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   // MainGUI.getPanel().repaint();*/
                    if(coloreC3=="Arancio")
                        pioggia[3]=Arancio[index3];
                    if(coloreC3=="Blu")
                        pioggia[3]=Blu[index3];
                    if(coloreC3=="Giallo")
                        pioggia[3]=Giallo[index3];
                    if(coloreC3=="Grigio")
                        pioggia[3]=Grigio[index3];
                    if(coloreC3=="Rosa")
                        pioggia[3]=Rosa[index3];
                    if(coloreC3=="Rosso")
                        pioggia[3]=Rosso[index3];
                    if(coloreC3=="Verde")
                        pioggia[3]=Verde[index3];
                    if(coloreC3=="Viola")
                        pioggia[3]=Viola[index3];
                    index3 ++;
                }
            }

            if(diff>=int4){
                y4 += (motionControl4) ? MOVIMENTO4: /*MOVIMENTO*/0;
                if(y4 >= -101) motionControl4 = true;
                if(y4 >= getHeight()-220) motionControl4 = false;
                if((y4 >= getHeight()-220) &&(esplosi[4] == true)){
                    pioggia[4]= null;
                    index4=0;
                }
                   // esplosi[0] = true;
                if((y4 >= getHeight()-220) &&(esplosi[4] == false) ){
                    gameover.play();
                    timer.stop();
                    try {
                        sleep(1900);
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


                    /*try {
                        pioggia[4] = ImageIO.read(getClass().getResource("/Cavalieri/Animazioni/cavaliere"+ coloreC4 +"/cavaliere"+ coloreC4+index4+ ".png"));
                    } catch (IOException ex) {
                        Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   //MainGUI.getPanel().repaint();*/
                    if(coloreC4=="Arancio")
                        pioggia[4]=Arancio[index4];
                    if(coloreC4=="Blu")
                        pioggia[4]=Blu[index4];
                    if(coloreC4=="Giallo")
                        pioggia[4]=Giallo[index4];
                    if(coloreC4=="Grigio")
                        pioggia[4]=Grigio[index4];
                    if(coloreC4=="Rosa")
                        pioggia[4]=Rosa[index4];
                    if(coloreC4=="Rosso")
                        pioggia[4]=Rosso[index4];
                    if(coloreC4=="Verde")
                        pioggia[4]=Verde[index4];
                    if(coloreC4=="Viola")
                        pioggia[4]=Viola[index4];
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

             //final String audioScoppio = "audio/scoppio.wav";
             //final String audioGO = "audio/gameover.wav";
            // final String audioSot = "audio/sottofondo.wav";
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
