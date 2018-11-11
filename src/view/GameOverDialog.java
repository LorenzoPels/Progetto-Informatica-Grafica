
package view;


import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.Dialog.resetLabel;
import static view.RightPanel.musicbutton;
import static view.RightPanel.audiobutton;
import static view.RightPanel.escbutton;
import static view.RightPanel.pausebutton;


public class GameOverDialog extends javax.swing.JFrame {
    
    
    public GameOverDialog() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        
    }       
    
    private void resetBottoni(){
        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
        escbutton.setEnabled(true);
        musicbutton.setEnabled(true);
        audiobutton.setEnabled(true);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recordUnit = new javax.swing.JLabel();
        recordDec = new javax.swing.JLabel();
        recordCent = new javax.swing.JLabel();
        unità = new javax.swing.JLabel();
        centinaia = new javax.swing.JLabel();
        decine = new javax.swing.JLabel();
        playbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(null);

        recordUnit.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        recordUnit.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.add(recordUnit);
        recordUnit.setBounds(190, 110, 30, 50);

        recordDec.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        recordDec.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.add(recordDec);
        recordDec.setBounds(160, 110, 30, 50);

        recordCent.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        recordCent.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.add(recordCent);
        recordCent.setBounds(130, 110, 30, 50);

        unità.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jPanel1.add(unità);
        unità.setBounds(160, 170, 70, 110);

        centinaia.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jPanel1.add(centinaia);
        centinaia.setBounds(20, 170, 70, 110);

        decine.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jPanel1.add(decine);
        decine.setBounds(90, 170, 70, 110);

        playbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/play.png"))); // NOI18N
        playbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(playbutton);
        playbutton.setBounds(100, 350, 200, 73);

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
    public static javax.swing.JLabel centinaia;
    public static javax.swing.JLabel decine;
    private javax.swing.JButton exitbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton playbutton;
    public static javax.swing.JLabel recordCent;
    public static javax.swing.JLabel recordDec;
    public static javax.swing.JLabel recordUnit;
    public static javax.swing.JLabel unità;
    // End of variables declaration//GEN-END:variables
}
