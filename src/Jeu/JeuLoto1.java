/*
 * 
 * 
 * 
 */
package Jeu;

import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.GREEN;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Aymene
 */
public class JeuLoto1 extends javax.swing.JFrame {
    
    private CarteLoto cl;
    private Color coul;
    private ArrayList<Color> tabCouleur = new ArrayList<Color>();
    
    
    public JeuLoto1() {
        initComponents();
        cl = new CarteLoto(5, 5);
        cl.initMaCarte();
        afficheValeurs();
    }

    public void afficheValeurs() {
        int n = 0;
        for(int i = 0; i < cl.getNbLig(); i++) {
            for(int j = 0; j < cl.getNbCol(); j++) {
                JButton jb = (JButton)PanCarte.getComponent(n);
                if(cl.getValCase(i, j) == 0) {
                    jb.setText(" ");
                }
                else {
                    String str = "" + cl.getValCase(i, j);
                    jb.setText(str);
                }
                n++;
            }
        }
    }
    
    public void colorButtons(Color c) {
        int n = 0;
        for(int i = 0; i < cl.getNbLig(); i++) {
            for(int j = 0; j < cl.getNbCol(); j++) {
                JButton jb = (JButton)PanCarte.getComponent(n);
                jb.setBackground(c);
                n++;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanCarte = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanCarte.setLayout(new java.awt.GridLayout(3, 5));

        jButton4.setBackground(new java.awt.Color(0, 255, 0));
        jButton4.setText("                         ");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        PanCarte.add(jButton4);

        jButton5.setBackground(new java.awt.Color(0, 255, 0));
        jButton5.setText("                         ");
        PanCarte.add(jButton5);

        jButton6.setBackground(new java.awt.Color(0, 255, 0));
        jButton6.setText("                         ");
        PanCarte.add(jButton6);

        jButton7.setBackground(new java.awt.Color(0, 255, 0));
        jButton7.setText("                         ");
        PanCarte.add(jButton7);

        jButton8.setBackground(new java.awt.Color(0, 255, 0));
        jButton8.setText("                         ");
        PanCarte.add(jButton8);

        jButton9.setBackground(new java.awt.Color(0, 255, 0));
        jButton9.setText("                         ");
        PanCarte.add(jButton9);

        jButton10.setBackground(new java.awt.Color(0, 255, 0));
        jButton10.setText("                         ");
        PanCarte.add(jButton10);

        jButton11.setBackground(new java.awt.Color(0, 255, 0));
        jButton11.setText("                         ");
        PanCarte.add(jButton11);

        jButton12.setBackground(new java.awt.Color(0, 255, 0));
        jButton12.setText("                         ");
        PanCarte.add(jButton12);

        jButton13.setBackground(new java.awt.Color(0, 255, 0));
        jButton13.setText("                         ");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        PanCarte.add(jButton13);

        jButton14.setBackground(new java.awt.Color(0, 255, 0));
        jButton14.setText("                         ");
        PanCarte.add(jButton14);

        jButton15.setBackground(new java.awt.Color(0, 255, 0));
        jButton15.setText("                         ");
        PanCarte.add(jButton15);

        jButton16.setBackground(new java.awt.Color(0, 255, 0));
        jButton16.setText("                         ");
        PanCarte.add(jButton16);

        jButton17.setBackground(new java.awt.Color(0, 255, 0));
        jButton17.setText("                         ");
        PanCarte.add(jButton17);

        jButton18.setBackground(new java.awt.Color(0, 255, 0));
        jButton18.setText("                         ");
        PanCarte.add(jButton18);

        getContentPane().add(PanCarte, java.awt.BorderLayout.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Carte de Loto");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("Nom Joueur");
        jPanel3.add(jLabel2);

        jTextField1.setText("Aymene");
        jPanel3.add(jTextField1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.GridLayout(2, 0));

        jButton1.setText("Informations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1);

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel5.setLayout(new java.awt.GridLayout(4, 0));

        jButton2.setText("Changer Couleur");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);

        jButton3.setText("Changer Carte");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);

        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText(cl.toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        CarteLoto cl = new CarteLoto();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        cl.initMaCarte();
        afficheValeurs();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.tabCouleur.add(RED);
        this.tabCouleur.add(BLUE);
        this.tabCouleur.add(WHITE);
        this.tabCouleur.add(GREEN);
        int x = (int)(Math.random() * 4 + 1);
        Color c = this.tabCouleur.get(x);
        colorButtons(c);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(JeuLoto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JeuLoto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JeuLoto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JeuLoto1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JeuLoto1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanCarte;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
