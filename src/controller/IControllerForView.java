
package controller;


public interface IControllerForView {
    public void openStartWindow();

	public void closeStartWindow();

	/*public void openNewGameWindow();

	public void loadPreviouslySavedGame(String file);

	public void closeNewGameWindow();*/

	public void openMainGUI();
        public void closeMainGUI();
        public void openDialog();
        public void closeDialog();
        public void openGameOverDialog();
        public void closeGameOverDialog();

	/*public int getNumColumnsOfBoard();

	public int getNumRowsOfBoard();

	public String getPlayerName();

	public void setPlayerName(String playerName);*/

	public String getScore();

	public void incrementScore(/*int increment*/);

	/*public int numBlocksOfPreviewPiece();

	public int iRelOfPreviewPiece(int blockLabel);

	public int jRelOfPreviewPiece(int blockLabel);

	public int numBlocksOfFallingPiece();

	public int iRelOfFallingPiece(int blockLabel);

	public int jRelOfFallingPiece(int blockLabel);

	public String getNameOfFallingPiece();

	public String getNameOfPreviewPiece();*/
	
	public void initGame();

	/*public int iIndex();

	public int jIndex();
	
	public boolean isEmptyCell(int i, int j);
	
	public String getNameOfPieceAtCell(int i, int j);

	public void down();
	
	public void left();
	
	public void right();
	
	public void rotate();
	
	public void next();*/
    
}
