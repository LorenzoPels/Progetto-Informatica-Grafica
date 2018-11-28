
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static view.BoardPanel.larghezza;
import static view.BoardPanel.x;
//import static view.MainGUI.t1;


public class MagoDefault implements MagoInterface {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------  
    public static BufferedImage[] arrayMago = new BufferedImage[3];;
    public static BufferedImage mago;
    public static int xMago ;
    public static int xMagoMax;
    public static int xMagoMin;
    private static long tmago;
    
    //---------------------------------------------------------------
    // VARIABILI PRIVATE
    //--------------------------------------------------------------- 
    
    public static int direzioneMago; /////// PRIMA ERA "int direzioneMago" MA COSI ALMENO CAMBIA DIREZIONE QUANDO DEVE
    
    
    private static MagoDefault instance = null;

    public MagoDefault(/*BufferedImage a, BufferedImage b, BufferedImage c*/) {
        
            arrayMago =  new BufferedImage[3];
            
        try {
            BufferedImage a = ImageIO.read(getClass().getResource("/immagini/Mago.png"));
            BufferedImage b = ImageIO.read(getClass().getResource("/immagini/MagoDx.png"));
            BufferedImage c = ImageIO.read(getClass().getResource("/immagini/MagoSx.png"));
            
            arrayMago[0] = a;
            arrayMago[1] = b;
            arrayMago[2] = c;
            
        } catch (IOException ex) {
            Logger.getLogger(MagoDefault.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
            mago = arrayMago[0];
            
            xMago = larghezza/2;
            xMagoMax= 500;
            xMagoMin = 100;
            direzioneMago= 1;
    
            tmago= 0 ;
    }
    
    
    //---------------------------------------------------------------
    //  METODI PUBBLICI
    //--------------------------------------------------------------- 
       
    public BufferedImage magoImg(){
        return this.mago;
    }
    
    public void stampaMago(){
        if (xMago == xMagoMax ){
            System.out.print("arrivato al limite ");
            direzioneMago = -1;
            System.out.println("DESTRO");
            mago = arrayMago[0];
        }
        if (xMago == xMagoMin){
            System.out.print("arrivato al limite ");
            direzioneMago = +1;
            System.out.println("SINISTRO");
            mago = arrayMago[0];
        }                                                                        
        xMago += direzioneMago;
    }              
        
    public void movimentoBraccia(){
        if((Model.getInstance().getT1()-tmago)>= 500)
                mago = arrayMago[0];
    }
    
     public void gestisciMago(int c){
        //System.out.println("gestisci mago funziona");
        int i;
        i= movimentoMago(c);
        mago = arrayMago[i];
    }
    
     public int movimentoMago(int i){
        //System.out.println("movimento mago funziona");
        int imgMago = 0;
        if(xMago < Model.getInstance().getXArray()[i] ){
            imgMago = 1;
            xMagoMax = Model.getInstance().getXArray()[i]+50;
            //System.out.print("PRIMO   ");
            direzioneMago = +1;
            //System.out.println("direzioneMago=+1");
        }
        if(xMago > Model.getInstance().getXArray()[i] ){
            imgMago = 2;
            xMagoMin=Model.getInstance().getXArray()[i]-50;
            //System.out.print("SECONDO    ");
            direzioneMago = -1;
            //System.out.println("direzioneMago=-1");
        }
        tmago =  System.currentTimeMillis();
        return imgMago;       
    }
     
    public int getXMago(){
        return this.xMago;
    }
    
    
    public void resetMago(){
        mago = arrayMago[0];
    }
    
    public void setXMagoMax(int x){
        xMagoMax = x;
    }
    
    public void setXMagoMin(int x){
        xMagoMin = x;
   }
    
    public static MagoInterface getInstance() {
    /*    BufferedImage a = arrayMago[0];
        BufferedImage b = arrayMago[1];
        BufferedImage c = arrayMago[2];                                         */
            if (instance == null)
                   instance = new MagoDefault(/*a,b,c*/);
            return instance;
    }
    
}
