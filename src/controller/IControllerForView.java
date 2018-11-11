
package controller;


public interface IControllerForView {
    
    public void openStartWindow();

	public void closeStartWindow();

	public void openMainGUI();
        
        public void closeMainGUI();
        
        public void openDialog();
        
        public void closeDialog();
        
        public void openGameOverDialog(String score);
        
        public void closeGameOverDialog();

	public String getScore();

	public void incrementScore();

	public void initGame();
        
        public void Colpito(boolean b, String s);
       
    
}
