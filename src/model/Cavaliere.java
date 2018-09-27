
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import view.CaricatoreImmagine;


public class Cavaliere {
	final static Cavaliere[] FALLING_PIECE_ARRAY = new Cavaliere[9];
	//final static Piece[] PREVIEW_PIECE_ARRAY = new Piece[7];
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
                

		
		for (int i = 0; i < FALLING_PIECE_ARRAY.length; i++)
			mapStringNameToFallingPieceObj.put((FALLING_PIECE_ARRAY[i]).getName(), FALLING_PIECE_ARRAY[i]);
	}

	//protected int[][] shapeArray;
	public  String nomeCavaliere;
        public String coloreCavaliere;
       public static Image cavaliere;
	protected Cavaliere() {
		//do nothing
	}


	public String getName() {
		return this.nomeCavaliere;
	}
        public String getColore() {
		return this.coloreCavaliere;
	}
        

	public static Cavaliere nextCavaliere() {
		Cavaliere fallingPiece = null;
		int pieceIndex = (int)(Math.random() * FALLING_PIECE_ARRAY.length) % FALLING_PIECE_ARRAY.length;
		
		fallingPiece = FALLING_PIECE_ARRAY[pieceIndex];
		            
		return fallingPiece;
	}
        
        public static Image Loader(Cavaliere cv){
            CaricatoreImmagine loader = new CaricatoreImmagine();
       
            cavaliere = loader.caricaImmagine("/Cavalieri/cavaliere"+cv.getName()+".png");
       
         return cavaliere;
        }
        
        

	 

} // end class