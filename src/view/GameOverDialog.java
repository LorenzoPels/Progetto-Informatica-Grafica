
package view;

import config.Config;
import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.Dialog.resetLabel;
import static view.RightPanel.jButton1;
import static view.RightPanel.jButton2;
import static view.RightPanel.musicbutton;
import static view.RightPanel.audiobutton;
import static view.RightPanel.scorelabel;


public class GameOverDialog extends javax.swing.JFrame {
    /*private String cifre;
    private char cifreU;
    private char cifreD;
    private char cifreH;*/
    
    public GameOverDialog() throws IOException {
        initComponents();
        setLocationRelativeTo(null);
        //Punteggio();
        //Config.Write(scorelabel.getText());
       /* if(scorelabel.getText().compareTo(recordlabel.getText())>0)
            recordlabel.setText(scorelabel.getText());*/
    }
    
    /*public void Punteggio(){
        //cifre = String.valueOf(scorelabel);
        
        cifre = ControllerForView.getInstance().getScore();
        System.out.println(cifre.length());
        if(cifre.length() ==3){
            cifreH = cifre.charAt(0);
            cifreD = cifre.charAt(1);
            cifreU = cifre.charAt(2);
            centinaia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreH+".jpg")));
            decine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreD+".jpg")));
            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
            centinaia.setBounds(90, 170, 70, 110);
            unità.setBounds(230, 170, 70, 110);
            decine.setBounds(160, 170, 70, 110);
        }
            
        if(cifre.length() ==2){
            cifreD = cifre.charAt(0);
            cifreU = cifre.charAt(1);
            //cifreH = cifre.charAt(2);
            decine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreD+".jpg")));
            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
            unità.setBounds(200, 170, 70, 110);
            decine.setBounds(130, 170, 70, 110);
            
        }
        if(cifre.length() ==1){
            cifreU = cifre.charAt(0);
            unità.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/"+cifreU+".jpg")));
            //cifreD = cifre.charAt(1);
           // cifreU = cifre.charAt(2);
        }   
            
    }*/
    
    private void resetBottoni(){
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
        jButton2.setEnabled(true);
        musicbutton.setEnabled(true);
        audiobutton.setEnabled(true);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        recordlabel = new javax.swing.JLabel();
        unità = new javax.swing.JLabel();
        centinaia = new javax.swing.JLabel();
        decine = new javax.swing.JLabel();
        playbutton = new javax.swing.JButton();
        exitbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setLayout(null);

        recordlabel.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 36)); // NOI18N
        recordlabel.setForeground(new java.awt.Color(0, 153, 255));
        recordlabel.setText("0");
        jPanel1.add(recordlabel);
        recordlabel.setBounds(190, 120, 90, 50);

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
    public static javax.swing.JLabel recordlabel;
    public static javax.swing.JLabel unità;
    // End of variables declaration//GEN-END:variables
}
