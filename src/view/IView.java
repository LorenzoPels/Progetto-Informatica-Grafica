
package view;

public interface IView {
    public void openStartWindow();

	public void closeStartWindow();

	/*public void openNewGameWindow();

	public void closeNewGameWindow();*/

	public void openMainGUI();
	public void closeMainGUI();
        public void openDialog();
	public void closeDialog();
        public void openGameOverDialog();
	public void closeGameOverDialog();
	public void updateScoreLabel(int score);
	
	/*public void gameOverDialog();
        */
}
