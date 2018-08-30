
package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;


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
               // FALLING_PIECE_ARRAY[] = new PieceZ();

		/*PREVIEW_PIECE_ARRAY[0] = new PieceI();
		PREVIEW_PIECE_ARRAY[1] = new PieceJ();
		PREVIEW_PIECE_ARRAY[2] = new PieceL();
		PREVIEW_PIECE_ARRAY[3] = new PieceO();
		PREVIEW_PIECE_ARRAY[4] = new PieceS();
		PREVIEW_PIECE_ARRAY[5] = new PieceT();
		PREVIEW_PIECE_ARRAY[6] = new PieceZ();*/
		
		for (int i = 0; i < FALLING_PIECE_ARRAY.length; i++)
			mapStringNameToFallingPieceObj.put((FALLING_PIECE_ARRAY[i]).getName(), FALLING_PIECE_ARRAY[i]);
	}

	//protected int[][] shapeArray;
	public  String pieceName;
        public static Image cavaliere;
	protected Cavaliere() {
		//do nothing
	}

	/*protected int numBlocks() {
		return shapeArray.length;
	}

	protected int iRel(int blockLabel) {
		return shapeArray[blockLabel][0];
	}

	protected int jRel(int blockLabel) {
		return shapeArray[blockLabel][1];
	}*/

   /**
	 * Performs a 90 degree clockwise rotation of this piece.
	 * This method must be overridden in case it does not produce a good effect.
	 * A clockwise 90 degree rotation is given by the following formula:
	 *    x' = - y
	 *    y' = x
	 * Namely, for a given block, the new abscissa x' is the opposite of the previous ordinate;
	 * while the new ordinate y' coincides with the previous abscissa.
	 */
	

	
	/*protected void update(Piece piece) {
		for (int k = 1; k < shapeArray.length; k++) {
			shapeArray[k][0] = piece.iRel(k);
			shapeArray[k][1] = piece.jRel(k);
		}
	}*/

	public String getName() {
		return this.pieceName;
	}

	//---------------------------------------------------------------
	// STATIC METHODS
	//---------------------------------------------------------------
	
	static Cavaliere getFallingPieceByName(String fallingPieceName) {
		return mapStringNameToFallingPieceObj.get(fallingPieceName);
	}

	public static Cavaliere nextFallingPiece() {
		Cavaliere fallingPiece = null;
		int pieceIndex = (int)(Math.random() * FALLING_PIECE_ARRAY.length) % FALLING_PIECE_ARRAY.length;
		/*for (int k = 0; k < PREVIEW_PIECE_ARRAY.length; k++)
			if (previewPiece == PREVIEW_PIECE_ARRAY[k])
				pieceIndex = k;*/
		fallingPiece = FALLING_PIECE_ARRAY[pieceIndex];
		//fallingPiece.update(previewPiece);
            
		return fallingPiece;
	}
        
        public static Image Loader(Cavaliere cv){
         try {
            cavaliere = ImageIO.read(new File("src/Cavalieri/cavaliereProvvisorio"+cv.getName()+".png"));
        }catch (IOException ex) {}
         return cavaliere;
        }
        
        

	/*static Piece randomPreviewPiece() {
		Piece previewPiece = null;
		int pieceIndex = (int)(Math.random() * PREVIEW_PIECE_ARRAY.length) % PREVIEW_PIECE_ARRAY.length;
		previewPiece = PREVIEW_PIECE_ARRAY[pieceIndex];
		previewPiece.randomRotation();
		return previewPiece;
	}*/

} // end class