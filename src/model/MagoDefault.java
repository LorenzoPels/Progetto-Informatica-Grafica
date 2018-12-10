
package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static view.BoardPanel.larghezza;



public class MagoDefault implements MagoInterface {
    
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------  
    public static BufferedImage[] arrayMago = new BufferedImage[3];;
    public static BufferedImage mago;
    public static int xMago ;
    public static int xMagoMax;
    public static int xMagoMin;
    public static int direzioneMago; 
    private static long tmago;
    
    //---------------------------------------------------------------
    // VARIABILI PRIVATE
    //--------------------------------------------------------------- 
 
    private static MagoDefault instance = null;

    public MagoDefault() {
        
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
            direzioneMago = -1;           
            mago = arrayMago[0];
        }
        if (xMago == xMagoMin){           
            direzioneMago = +1;           
            mago = arrayMago[0];
        }                                                                        
        xMago += direzioneMago;
    }              
        
    public void movimentoBraccia(){
        if((Model.getInstance().getT1()-tmago)>= 500)
                mago = arrayMago[0];
    }
    
     public void gestisciMago(int c){       
        int i;
        i= movimentoMago(c);
        mago = arrayMago[i];
    }
    
     public int movimentoMago(int i){

        int imgMago = 0;
        if(xMago < Model.getInstance().getXArray()[i] ){
            imgMago = 1;
            xMagoMax = Model.getInstance().getXArray()[i]+50;
            direzioneMago = +1;
        }
        if(xMago > Model.getInstance().getXArray()[i] ){
            imgMago = 2;
            xMagoMin=Model.getInstance().getXArray()[i]-50;
            direzioneMago = -1;
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
    
    //---------------------------------------------------------------
    //  METODI STATICI
    //--------------------------------------------------------------- 
    public static MagoInterface getInstance() {

        if (instance == null)
            instance = new MagoDefault();
        return instance;
    }
    
}
