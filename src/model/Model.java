
package model;

public class Model implements IModel {
    
    //---------------------------------------------------------------
    // STATIC FIELDS
    //---------------------------------------------------------------
    private static Model instance = null;
    
    //---------------------------------------------------------------
    // INSTANCE ATTRIBUTES
    //---------------------------------------------------------------
    private int score;
    private Model() {
		//this.boardArray = new int[DEFAULT_NUM_ROWS][DEFAULT_NUM_COLUMNS];
		this.initGame();
	}
    
    //---------------------------------------------------------------
    // PUBLIC INSTANCE METHODS
    //---------------------------------------------------------------
    public void initGame() {
		 this.score= 0;
		
		//this.initBoardArray(DEFAULT_NUM_ROWS, DEFAULT_NUM_COLUMNS);
		//this.iIndex = I_INDEX_INIT;
		//this.jIndex = J_INDEX_INIT;
		//this.previewPiece = Piece.randomPreviewPiece();
		//this.fallingPiece = Piece.nextFallingPiece(this.previewPiece);
		//this.previewPiece = Piece.randomPreviewPiece();
	}
        

    //---------------------------------------------------------------
    // STATIC METHODS
    //---------------------------------------------------------------
    public static IModel getInstance() {
            if (instance == null)
                    instance = new Model();
            return instance;
    }

}

