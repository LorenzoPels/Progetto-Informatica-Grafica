
package view;

import controller.ControllerForView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import static view.MainGUI.gameover;
import static view.MainGUI.player;
import static view.MainGUI.scoppio;




public class RightPanel extends javax.swing.JPanel {
    
    public int click;
    public int click2;
    
    public RightPanel() {
        initComponents();
        scorelabel.setText("0");    
    }
    
    public static void updateScoreLabel(int score) {
		scorelabel.setText(String.valueOf(score));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pausebutton = new javax.swing.JButton();
        escbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        scorelabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        audiobutton = new javax.swing.JButton();
        musicbutton = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("Magic");

        setBackground(new java.awt.Color(51, 51, 255));
        setPreferredSize(new java.awt.Dimension(150, 730));

        jLabel1.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Magic");

        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png"))); // NOI18N
        pausebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausebuttonActionPerformed(evt);
            }
        });

        escbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/bottone.png"))); // NOI18N
        escbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escbuttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Touch");

        scorelabel.setText(ControllerForView.getInstance().getScore());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(scorelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scorelabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        scorelabel.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Punteggio:");

        audiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/effetti.png"))); // NOI18N
        audiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audiobuttonActionPerformed(evt);
            }
        });

        musicbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/musica.png"))); // NOI18N
        musicbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                musicbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(audiobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(musicbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pausebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(170, 170, 170)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(musicbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(audiobutton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(pausebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(escbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void escbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escbuttonActionPerformed
       
       ControllerForView.getInstance().openDialog();
    }//GEN-LAST:event_escbuttonActionPerformed

    private void pausebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausebuttonActionPerformed
    
     if (!ControllerForView.getInstance().getGiocoInEsecuzione()) {
        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/pausa.png")));
        escbutton.setEnabled(false);
        musicbutton.setEnabled(false);
        audiobutton.setEnabled(false);
     }else {
        pausebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/gioca.png")));
        escbutton.setEnabled(true);
        musicbutton.setEnabled(true);
        audiobutton.setEnabled(true);
     }
     
      MainGUI.startPauseEvent();   // TODO add your handling code here:
    }//GEN-LAST:event_pausebuttonActionPerformed

    private void audiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audiobuttonActionPerformed
        click2++;
        if(click2%2 != 0){
            audiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/noeffetti.png")));
            scoppio.close();
            gameover.close();
        }else{
            audiobutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/effetti.png")));
            try {
                scoppio = new ClipPlayer("audio/scoppio.wav");
                gameover = new ClipPlayer("audio/gameover.wav");
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(RightPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RightPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_audiobuttonActionPerformed

    private void musicbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_musicbuttonActionPerformed
     click++;
        if(click%2 != 0){
            musicbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/nomusica.png")));
            player.setMute(true);
        }else{
            musicbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/immagini/musica.png")));
            player.setMute(false);
        }
    }//GEN-LAST:event_musicbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton audiobutton;
    public static javax.swing.JButton escbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JButton musicbutton;
    public static javax.swing.JButton pausebutton;
    public static javax.swing.JLabel scorelabel;
    // End of variables declaration//GEN-END:variables

   
    
}
