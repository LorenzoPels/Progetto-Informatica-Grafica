
package view;

import config.Config;
import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.Dialog.resetLabel;
import static view.RightPanel.jButton1;
import static view.RightPanel.jButton2;
import static view.RightPanel.scorelabel;


public class GameOverDialog extends javax.swing.JFrame {

    
    public GameOverDialog() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        //Config.Write(scorelabel.getText());
       /* if(scorelabel.getText().compareTo(recordlabel.getText())>0)
            recordlabel.setText(scorelabel.getText());*/
    }
private void resetBottoni(){
    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
    jButton2.setEnabled(true);
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recordlabel = new javax.swing.JLabel();
        finalscorelabel = new javax.swing.JLabel();
        playbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(null);

        recordlabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        recordlabel.setForeground(new java.awt.Color(0, 153, 255));
        recordlabel.setText("0");
        jPanel1.add(recordlabel);
        recordlabel.setBounds(190, 100, 130, 80);

        finalscorelabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jPanel1.add(finalscorelabel);
        finalscorelabel.setBounds(160, 170, 260, 90);

        playbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/play.png"))); // NOI18N
        playbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(playbutton);
        playbutton.setBounds(100, 350, 200, 70);

        exitbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/bottone.png"))); // NOI18N
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(exitbutton);
        exitbutton.setBounds(150, 440, 100, 47);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/Gameover.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playbuttonActionPerformed
       ControllerForView.getInstance().closeGameOverDialog();
       ControllerForView.getInstance().closeMainGUI();
       
       ControllerForView.getInstance().openMainGUI();
       resetBottoni();
       ControllerForView.getInstance().initGame();
       resetLabel();
    }//GEN-LAST:event_playbuttonActionPerformed

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbuttonActionPerformed
      ControllerForView.getInstance().closeMainGUI();
       ControllerForView.getInstance().closeGameOverDialog();
       ControllerForView.getInstance().openStartWindow();
       resetBottoni();
       resetLabel();
    }//GEN-LAST:event_exitbuttonActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameOverDialog().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GameOverDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbutton;
    public static javax.swing.JLabel finalscorelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton playbutton;
    public static javax.swing.JLabel recordlabel;
    // End of variables declaration//GEN-END:variables
}
