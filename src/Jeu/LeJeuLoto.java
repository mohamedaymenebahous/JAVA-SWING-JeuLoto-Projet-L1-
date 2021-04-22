package Jeu;

//imports necessaires
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author Aymene
 */

public class LeJeuLoto extends javax.swing.JFrame {

    //attribut lstJ de type Objet LesJoueurs
    private LesJoueurs lstJ;
    
    //constructeur
    public LeJeuLoto() {
        initComponents(); //lancement de la initComponent qui lance l'interface visuelle
        this.lstJ = new LesJoueurs(); //instanciation de la classe de l'attribut declaré
        initJoueurs(); //appel à la methode qui initialise les joueurs
    }

    public void initJoueurs() {
        //comme indiqué dans l'énoncé le jeu commence avec deux joueurs prédéfinis
        //on initialise un premier Joueur Ellis
        Joueur j1 = new Joueur("Ellis");
        j1.setCouleur(Color.red); //on lui donne une couleur rouge
        this.lstJ.ajouteJoueur(j1); //on ajoute ce Joueur a la lstJ
        
        //on initialise un deuxieme Joueur Bob
        Joueur j2 = new Joueur("Bob");
        j2.setCouleur(Color.blue); //on lui donne une couleur bleue
        this.lstJ.ajouteJoueur(j2);
        
        for(int i = 0; i < this.lstJ.getNbJoueur(); i++) { //on parcourt la liste lstJ
            JButton bout = (JButton) jPanel3.getComponent(i); 
            //on recupere tous les composantes de la panel jPanel13 qui sont des boutons par casting et on l'affecte a la variable bout
            String pseudo = this.lstJ.getJoueur(i).getPseudo(); //on affecte a pseudo le pseudo du Joueur i de la lstJ
            if(pseudo != null && !pseudo.equals("")) { //on fait un test pour voir si le Joueur a un pseudo valide
                bout.setText("      " + pseudo + "     "); //on donne au bouton un texte qui sera le pseudo du Joueur
                bout.setBackground(this.lstJ.getJoueur(i).getCouleur()); //on donne au bouton une couleur de fond qui sera la couleur du Joueur
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Le Jeu Loto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Voici les cartes dont vous disposez");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(4, 0));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jButton3.setText("Joueur 3");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jButton4.setText("Joueur 4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Cadeau: Lave Linge");
        jPanel5.add(jLabel2);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.GridLayout(1, 0));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.add(jScrollPane1);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText("Historique du tirage des boules");
        jPanel10.add(jLabel3);

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.GridLayout(1, 3));

        jButton5.setText("Tirage");
        jPanel11.add(jButton5);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel13.add(jLabel5);

        jPanel11.add(jPanel13);

        jButton6.setText("Arrêter");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton6);

        jPanel8.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText(" Option choisie: Carton plein");
        jPanel12.add(jLabel4);

        jPanel8.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel8);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        jMenu1.setText("Ajout");

        jMenuItem1.setText("Joueur");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Lot");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Action");

        jMenuItem3.setText("Option jeu");
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Démarrer jeu");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Acheter cartes");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Continuer");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Recommencer");
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Joueur j = this.lstJ.getJoueur(0); //acces au premier joueur de la liste de Joueur(s)
        VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
        diag.setSize(900, 500); //specification de la taille de la jDialog
        diag.setLocation(100, 100); //specification de la localisation de la jDialog
        diag.setVisible(true); //definition de la visibilité du jDialog sur true ===> jDialog visible lors du clique
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        AjoutJoueurDlg diag = new AjoutJoueurDlg(this, true); //initialisation de la jDialog
        diag.setSize(700, 300); //specification de la taille de la jDialog
        diag.setLocation(100, 100); //specification de la localisation de la jDialog
        diag.setVisible(true);  //definition de la visibilité du jDialog sur true ===> jDialog visible lors du clique
        
        if(diag.getOk() == true) { //test pour restituer le Joueur et ses valeurs apres clique sur verifier du jDialog de la premiere option du menu
            Joueur j = diag.getJoueur(); //recuperation du joueur et son affectation a j
            this.lstJ.ajouteJoueur(j); //ajout du joueur a la liste lstJ 
            
            for(int i = 0; i < this.lstJ.getNbJoueur(); i++) { //parcours de tous les elements de la liste
                JButton bout = (JButton) jPanel3.getComponent(i); 
                //on recupere tous les composantes de la panel jPanel13 qui sont des boutons par casting et on l'affecte a la variable bout
                String pseudo = this.lstJ.getJoueur(i).getPseudo(); //on affecte a pseudo le pseudo du Joueur i de la lstJ
                bout.setText("      " + pseudo + "     "); //on donne au bouton un texte qui sera le pseudo du Joueur
                bout.setBackground(this.lstJ.getJoueur(i).getCouleur()); //on donne au bouton une couleur de fond qui sera la couleur du Joueur
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Joueur j = this.lstJ.getJoueur(1); //acces au deuxieme joueur de la liste de Joueur(s)
        VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
        diag.setSize(900, 500);
        diag.setLocation(100, 100);
        diag.setVisible(true); 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Joueur j = this.lstJ.getJoueur(2); //acces au troisieme joueur de la liste de Joueur(s)
        VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
        diag.setSize(900, 500);
        diag.setLocation(100, 100);
        diag.setVisible(true); 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Joueur j = this.lstJ.getJoueur(3); //acces au quatrieme joueur de la liste de Joueur(s)
        VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
        diag.setSize(900, 500);
        diag.setLocation(100, 100);
        diag.setVisible(true); 
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeJeuLoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeJeuLoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
