/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SimonPackage;

import java.awt.Color;

/**
 *
 * @author Leo
 */
public class SimonWelcome extends javax.swing.JFrame {

    /**
     * Creates new form SimonWelcome
     */
    
    private SimonGamePanel gamePanel;
    
    public SimonWelcome() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sLabel = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        simonDescriptionScollPane = new javax.swing.JScrollPane();
        simonDescriptionTextArea = new javax.swing.JTextArea();
        iLabel = new javax.swing.JLabel();
        mLabel = new javax.swing.JLabel();
        oLabel = new javax.swing.JLabel();
        nLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcom to S I M O N");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(600, 600));
        setName("SimonWelcome"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);

        sLabel.setFont(new java.awt.Font("Gulim", 0, 24)); // NOI18N
        sLabel.setForeground(new java.awt.Color(255, 255, 255));
        sLabel.setText("S");

        playButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        playButton.setText("Play");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        exitButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        simonDescriptionScollPane.setBackground(new java.awt.Color(0, 0, 0));
        simonDescriptionScollPane.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        simonDescriptionScollPane.setOpaque(false);

        simonDescriptionTextArea.setEditable(false);
        simonDescriptionTextArea.setBackground(new java.awt.Color(204, 204, 204));
        simonDescriptionTextArea.setColumns(20);
        simonDescriptionTextArea.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        simonDescriptionTextArea.setLineWrap(true);
        simonDescriptionTextArea.setRows(5);
        simonDescriptionTextArea.setText("    Do what SIMON says...\n\n Follow the pattern of lights\n   and sounds for as long as\n                  you can...");
        simonDescriptionTextArea.setWrapStyleWord(true);
        simonDescriptionTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        simonDescriptionTextArea.setOpaque(false);
        simonDescriptionScollPane.setViewportView(simonDescriptionTextArea);

        iLabel.setFont(new java.awt.Font("Gulim", 0, 24)); // NOI18N
        iLabel.setForeground(new java.awt.Color(255, 255, 255));
        iLabel.setText("I");

        mLabel.setFont(new java.awt.Font("Gulim", 0, 24)); // NOI18N
        mLabel.setForeground(new java.awt.Color(255, 255, 255));
        mLabel.setText("M");

        oLabel.setFont(new java.awt.Font("Gulim", 0, 24)); // NOI18N
        oLabel.setForeground(new java.awt.Color(255, 255, 255));
        oLabel.setText("O");

        nLabel.setFont(new java.awt.Font("Gulim", 0, 24)); // NOI18N
        nLabel.setForeground(new java.awt.Color(255, 255, 255));
        nLabel.setText("N");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(sLabel)
                        .addGap(18, 18, 18)
                        .addComponent(iLabel)
                        .addGap(18, 18, 18)
                        .addComponent(mLabel)
                        .addGap(18, 18, 18)
                        .addComponent(oLabel)
                        .addGap(18, 18, 18)
                        .addComponent(nLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playButton)
                            .addComponent(exitButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(simonDescriptionScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sLabel)
                    .addComponent(iLabel)
                    .addComponent(mLabel)
                    .addComponent(oLabel)
                    .addComponent(nLabel))
                .addGap(37, 37, 37)
                .addComponent(simonDescriptionScollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(playButton)
                .addGap(75, 75, 75)
                .addComponent(exitButton)
                .addGap(115, 115, 115))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("You have pressed the play button");
        gamePanel = new SimonGamePanel();
        add(gamePanel);
        gamePanel.setSize(600, 600);
        this.remove(playButton);
        this.remove(exitButton);
        this.remove(simonDescriptionTextArea);
        this.remove(simonDescriptionScollPane);
        this.remove(sLabel);
        this.remove(iLabel);
        this.remove(mLabel);
        this.remove(oLabel);
        this.remove(nLabel);
        super.setBackground(Color.BLACK);
        gamePanel.setUI(null);
    }//GEN-LAST:event_playButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0); 
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SimonWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimonWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimonWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimonWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimonWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel iLabel;
    private javax.swing.JLabel mLabel;
    private javax.swing.JLabel nLabel;
    private javax.swing.JLabel oLabel;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel sLabel;
    private javax.swing.JScrollPane simonDescriptionScollPane;
    private javax.swing.JTextArea simonDescriptionTextArea;
    // End of variables declaration//GEN-END:variables
}