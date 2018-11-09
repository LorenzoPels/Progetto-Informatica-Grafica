
package view;

import java.awt.image.BufferedImage;

public interface IView {
    
    public void openStartWindow();

    public void closeStartWindow();

    public void openMainGUI();

    public void closeMainGUI();

    public void openDialog();

    public void closeDialog();

    public void openGameOverDialog(String score);

    public void closeGameOverDialog();

    public void updateScoreLabel(int score);

}
