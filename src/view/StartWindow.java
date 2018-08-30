
package view;

import controller.ControllerForView;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;



public class StartWindow extends javax.swing.JFrame  {
     

    
    public StartWindow() {
        initComponents();
        jButtonDx.setMnemonic(KeyEvent.VK_RIGHT);
        jButtonSx.setMnemonic(KeyEvent.VK_LEFT);
        jButtonMode.setMnemonic(KeyEvent.VK_ENTER);
        
       
        setLocationRelativeTo(null);
        
       
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonDx = new javax.swing.JButton();
        jButtonEsci = new javax.swing.JButton();
        jButtonMode = new javax.swing.JButton();
        jButtonSx = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magic Touch ");
        setResizable(false);

        jPanel1.setLayout(null);

        jButtonDx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/frdx.png"))); // NOI18N
        jButtonDx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDxActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonDx);
        jButtonDx.setBounds(350, 220, 30, 40);

        jButtonEsci.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 12)); // NOI18N
        jButtonEsci.setForeground(new java.awt.Color(255, 255, 0));
        jButtonEsci.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/bottone.png"))); // NOI18N
        jButtonEsci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsciActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEsci);
        jButtonEsci.setBounds(160, 360, 100, 47);

        jButtonMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/classic.png"))); // NOI18N
        jButtonMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonMode);
        jButtonMode.setBounds(50, 200, 290, 130);

        jButtonSx.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/frsx.png"))); // NOI18N
        jButtonSx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSxActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSx);
        jButtonSx.setBounds(10, 220, 30, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/start.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 550);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEsciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsciActionPerformed
       ControllerForView.getInstance().closeStartWindow();
       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);// TODO add your handling code here:
    }//GEN-LAST:event_jButtonEsciActionPerformed

    private void jButtonDxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDxActionPerformed
       jButtonMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/insane.png")));
    }//GEN-LAST:event_jButtonDxActionPerformed

    private void jButtonSxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSxActionPerformed
        jButtonMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/classic.png")));
    }//GEN-LAST:event_jButtonSxActionPerformed

    private void jButtonModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModeActionPerformed
        handleStartGameEvent();// TODO add your handling code here:
    }//GEN-LAST:event_jButtonModeActionPerformed
         /**
     * @param args the command line arguments
     */
   

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
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartWindow().setVisible(true);
            }
        
       
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDx;
    private javax.swing.JButton jButtonEsci;
    private javax.swing.JButton jButtonMode;
    private javax.swing.JButton jButtonSx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
private void handleStartGameEvent() {
		//System.out.println("Event start game");
                ControllerForView.getInstance().closeStartWindow();
		ControllerForView.getInstance().openMainGUI();
	}

    
   

}

