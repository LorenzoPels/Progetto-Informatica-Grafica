
package model;

import java.awt.Image;
import java.util.HashMap;
import view.CaricatoreImmagine;
import static view.StartWindow.insane;



public class Cavaliere {
    //---------------------------------------------------------------
    // VARIABILI STATICHE
    //---------------------------------------------------------------
    private static int length =9;
    final static Cavaliere[] FALLING_PIECE_ARRAY = new Cavaliere[15];
    final static HashMap<String, Cavaliere> mapStringNameToFallingPieceObj= new HashMap<String, Cavaliere>();

    static {
            FALLING_PIECE_ARRAY[0] = new CavaliereA();
            FALLING_PIECE_ARRAY[1] = new CavaliereB();
            FALLING_PIECE_ARRAY[2] = new CavaliereF();
            FALLING_PIECE_ARRAY[3] = new CavaliereH();
            FALLING_PIECE_ARRAY[4] = new CavaliereJ();
            FALLING_PIECE_ARRAY[5] = new CavaliereK();
            FALLING_PIECE_ARRAY[6] = new CavaliereL();
            FALLING_PIECE_ARRAY[7] = new CavaliereM();
            FALLING_PIECE_ARRAY[8] = new CavaliereP();           
            FALLING_PIECE_ARRAY[9] = new CavaliereQ();
            FALLING_PIECE_ARRAY[10] = new CavaliereR();
            FALLING_PIECE_ARRAY[11] = new CavaliereU();
            FALLING_PIECE_ARRAY[12] = new CavaliereV();
            FALLING_PIECE_ARRAY[13] = new CavaliereW();
            FALLING_PIECE_ARRAY[14] = new CavaliereY();
            


            for (int i = 0; i < FALLING_PIECE_ARRAY.length; i++)
                    mapStringNameToFallingPieceObj.put((FALLING_PIECE_ARRAY[i]).getName(), FALLING_PIECE_ARRAY[i]);
    }
    public static Image cavaliere;
    
    //---------------------------------------------------------------
    // VARIABILI PUBBLICHE
    //--------------------------------------------------------------- 
    public  String nomeCavaliere;
    public String coloreCavaliere;
    
    
    protected Cavaliere() {
            //do nothing
    }
    
    //---------------------------------------------------------------
    // METODI PUBBLICI
    //---------------------------------------------------------------
    
    public String getName() {
            return this.nomeCavaliere;
    }
    public String getColore() {
            return this.coloreCavaliere;
    }
   
    //---------------------------------------------------------------
    // METODI STATICI
    //---------------------------------------------------------------
    
    public static Cavaliere nextCavaliere() {
            Cavaliere fallingPiece = null;
            if(insane == true)
                length=15;
            else length=9;
            int pieceIndex = (int)(Math.random() * length) % length;

            fallingPiece = FALLING_PIECE_ARRAY[pieceIndex];

            return fallingPiece;
    }

    public static Image Loader(Cavaliere cv){
        CaricatoreImmagine loader = new CaricatoreImmagine();
        cavaliere = loader.caricaImmagine("/immagini/Cavalieri/cavaliere"+cv.getName()+".png");

     return cavaliere;
    }
	 

} // end class