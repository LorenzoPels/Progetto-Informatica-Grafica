
package view;

import controller.ControllerForView;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.Timer;
import model.Cavaliere;
import static model.Cavaliere.Loader;
import static view.RightPanel.scorelabel;
import static view.GameOverDialog.finalscorelabel;





public class MainGUI extends JFrame implements ActionListener  {
public static BoardPanel panel;
private final static int larghezza = 750;
private final static int altezza = 730;
private RightPanel rightpanel;
private static Timer timer;
public static int x, y1,y2,y3,y4,y5;
private final int PAUSE = 10;
public static  int MOVIMENTO = 1;
private boolean motionControl1,motionControl2,motionControl3,motionControl4,motionControl5;

public static Boolean giocoiniziato = false;
public static Image[] pioggia = new Image[5];
public static Cavaliere[] cavalieri = new Cavaliere[5];
private int tempo;
private int variabile;
public static long t0,t1,P,Pi,Pf;
public static long diff;
public static int int1=1000;
public static int int2=1500;
public static int int3=2000;
public static int int4=2500;
public static int int5=3500;
public static int int6=4000;
public static ClipPlayer scoppio;
public static ClipPlayer gameover;

//public static Boolean integro1,integro2,integro3,integro4,integro5 = true;
//public  Image cavaliere;

MainGUI(String audioScoppio,String audioGO) throws FileNotFoundException, UnsupportedAudioFileException, IOException {
 
    super("Magic Touch Game");
//MainGUI maingui = new MainGUI();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(larghezza,altezza));
    this.createPanel();
    panel = new BoardPanel();
    add(panel);
    setResizable(true);
    pack();
    setLocationRelativeTo(null);
    x = 200;
    y1 = -100;
    y2 = -100;
    y3 = -100;
    y4 = -100;
    y5 = -100;

    timer = new Timer(PAUSE, this);
    scoppio = new ClipPlayer(audioScoppio);
    gameover = new ClipPlayer(audioGO);
    //timer.start();
    //Cavalieri();
    //Pioggia();
    //t0 = System.currentTimeMillis();
    variabile = (int)(Math.random() * pioggia.length) % pioggia.length;
    //setFocusable(true);
           



}
public static Cavaliere[] Cavalieri(){
   cavalieri[0] = Cavaliere.nextFallingPiece();
   cavalieri[1] = Cavaliere.nextFallingPiece();
   cavalieri[2] = Cavaliere.nextFallingPiece();
   cavalieri[3] = Cavaliere.nextFallingPiece();
   cavalieri[4] = Cavaliere.nextFallingPiece();
   return cavalieri;
}


 public static Image[] Pioggia(){
    for(int i=0; i<cavalieri.length;i++)  
        pioggia[i] = Loader(cavalieri[i]);
    return pioggia;
    }
        
public static Boolean InizioGioco(){
        Cavalieri();
        Pioggia();
        timer.start();
        giocoiniziato = true;
        t0 = System.currentTimeMillis();
        return giocoiniziato;
        
        
        
    }
public static Boolean  PausaGioco(){
            timer.stop();
            giocoiniziato = false;
            Pi = System.currentTimeMillis();
            
            return giocoiniziato;
        } 
public static Boolean  RiprendiGioco(){
            Pf = System.currentTimeMillis();
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
        
       if(diff>=int1){
            y1 += (motionControl1) ? MOVIMENTO: /*-MOVIMENTO*/0;
            if(y1 >= -101) motionControl1 = true;
            if(y1 >= getHeight()-220) motionControl1 = false;
            if((y1 >= getHeight()-220) &&(pioggia[0]!= null) ){
                gameover.play();
                timer.stop();
                try {
                    sleep(1900);
                    //PausaGioco();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
                
            }
        }
       
        if(diff>=int2){
            y2 += (motionControl2) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y2 >= -101) motionControl2 = true;
            if(y2 >= getHeight()-220) motionControl2 = false;
           if((y2 >= getHeight()-220) &&(pioggia[1]!= null) ){
                timer.stop();
                gameover.play();
                try {
                    sleep(1900);
                    //PausaGioco();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               // PausaGioco();
                
                ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
                
            }
        }
        
        if(diff>=int3){
            y3 += (motionControl3) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y3 >= -101) motionControl3 = true;
            if(y3 >= getHeight()-220) motionControl3 = false;
            if((y3 >= getHeight()-220) &&(pioggia[2]!= null) ){
                timer.stop();
                gameover.play();
                try {
                    sleep(1900);
                    //PausaGioco();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               // PausaGioco();
                
                ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
                
            }
        }
        
        if(diff>=int4){
            y4 += (motionControl4) ? MOVIMENTO:/* MOVIMENTO*/0;
            if(y4 >= -101) motionControl4 = true;
            if(y4 >= getHeight()-220) motionControl4 = false;
            if((y4 >= getHeight()-220) &&(pioggia[3]!= null) ){
                timer.stop();
                gameover.play();
                try {
                    sleep(1900);
                    //PausaGioco();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               // PausaGioco();
                
                ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
                
            }
        }
        
        if(diff>=int5){
            y5 += (motionControl5) ? MOVIMENTO: /*MOVIMENTO*/0;
            if(y5 >= -101) motionControl5 = true;
            if(y5 >= getHeight()-220) motionControl5 = false;
            if((y5 >= getHeight()-220) &&(pioggia[4]!= null) ){
                timer.stop();
                gameover.play();
                try {
                    sleep(1900);
                    //PausaGioco();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ControllerForView.getInstance().openGameOverDialog(scorelabel.getText());
            }
        }
         this.panel.repaint();       
        //repaint();
    }


    public static void main(String[] args) {
         final String audioScoppio = "audio/scoppio.wav";
         final String audioGO = "audio/gameover.wav";
         try {
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 try {
                    new MainGUI(audioScoppio,audioGO).setVisible(true);
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