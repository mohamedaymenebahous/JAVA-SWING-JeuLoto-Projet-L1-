package Jeu;

//imports necessaires
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Aymene
 */

public class LeJeuLoto extends javax.swing.JFrame {

    //attribut lstJ de type Objet LesJoueurs
    private LesJoueurs lstJ;
    //attributs qui vont gerer l'option du jeux , le nombre de colonnes et le nombre de numéros
    private int option;
    private String optionName = "Quine";
    private boolean optionChoisie = false;
    private int nbCol;
    private int nbNum;
    //attribut ArrayList de lots qui vas servir pour afficher les lots
    private Lots lots;
    //atribut qui permet de fixer un lots sur toute la partie;
    private Lot l;
    //attribut qui va aider a savoir si une carte est achetée ou pas pour commencer le jeux
    private boolean carteAchetée; //boolean qui sera mis a true si une carte est achetée
    private boolean demarre = false; //boolean mis sur false qui va servir lors du clique de la sous option demarrer pour demarrer la partie et deverouiller quelques boutons
    private final int MAX = 90; //valeur constante de la valeur maxiamle a generer
    private int[] boules;
    private LesJoueurs Gagnants; //liste des joueurs gagnants
    
    //constructeur
    public LeJeuLoto() {
        initComponents(); //lancement de la initComponent qui lance l'interface visuelle
        this.lstJ = new LesJoueurs(); //instanciation de la classe de l'attribut lstJ declaré
        this.option = 1; //on initialise l'option sur la premiere occurence qui est LA QUINE
        //on initialise le nombre de colonne a 5, et celui des numeros a 10;
        this.nbCol = 5; 
        this.nbNum = 5;
        this.lots = new Lots();
        this.initJoueurs(); //appel à la methode qui initialise les joueurs
        this.initBoules();
        this.Gagnants = new LesJoueurs(); //instanciation de la classe de l'attribut Gagnants declaré
    }

    public void initJoueurs() {
        //comme indiqué dans l'énoncé le jeu commence avec deux joueurs prédéfinis
        //on initialise un premier Joueur Ellis
//        Joueur j1 = new Joueur("Ellis");
//        j1.setCouleur(Color.red); 
//        //on lui donne une couleur rouge
//        this.lstJ.ajouteJoueur(j1); 
//        //on ajoute ce Joueur a la lstJ
//        
//        //on initialise un deuxieme Joueur Bob
//        Joueur j2 = new Joueur("Bob");
//        j2.setCouleur(Color.blue);  
//        //on lui donne une couleur bleue
//        this.lstJ.ajouteJoueur(j2);
//        
//        Joueur j3 = new Joueur("Aymene");
//        j3.setCouleur(Color.green); 
//        //on lui donne une couleur rouge
//        this.lstJ.ajouteJoueur(j3); 
//        //on ajoute ce Joueur a la lstJ
//        
//        //on initialise un deuxieme Joueur Bob
//        Joueur j4 = new Joueur("Josh");
//        j4.setCouleur(Color.yellow);  
//        //on lui donne une couleur bleue
//        this.lstJ.ajouteJoueur(j4);
        
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
    
    private void afficheCartes() { //methode qui permet l'affichage des cartes dans les panneaux dédiés
        int compte = 0; //compteur pour recuperer les panneaux dans lesquels s'affichent les cartes
        for(int i = 0; i < this.lstJ.getNbJoueur(); i++) {
            Joueur jr = this.lstJ.getJoueur(i);
            int nbCartes = jr.getMesCartes().getTaille();
            switch(nbCartes) {
                case 0 : 
                    compte += 2;
                    break;
                case 1 : 
                    JPanel jp1 = (JPanel)jPanel2.getComponent(compte);
                    compte += 1;
                    jr.getMesCartes().getCarte(0).dessineCarte(jp1, jr.getCouleur());
                    compte += 1;
                    break;
                case 2 : 
                    JPanel jp2 = (JPanel)jPanel2.getComponent(compte);
                    jr.getMesCartes().getCarte(0).dessineCarte(jp2, jr.getCouleur());
                    compte += 1;
                    JPanel jp3 = (JPanel)jPanel2.getComponent(compte);
                    jr.getMesCartes().getCarte(1).dessineCarte(jp3, jr.getCouleur());
                    compte += 1;
                    break;
            }
        }
    }
     
    
    public void test() { //methode qui fait le test pour voir si les conditions sont remplies pour activer la sous option Démarrer le jeu
        if(this.lstJ.getNbJoueur() != 0 && this.carteAchetée == true) {
            jMenuItem4.setEnabled(true);
        }
    }
    
    
    public void initBoules() { //initialisation du tableau des boules a tirer en donnant a toutes les boules la valeur 0
        this.boules = new int[this.MAX];
        for(int i = 0; i < this.MAX; i++) {
            this.boules[i] = 0;
        }
    }
    
    public void Gagnant() { //methode pour donner un gagnant a la partie et arret de la partie avec afficahge des infos sur le gagnant sur la jTextArea1
        int nbJ = this.Gagnants.getNbJoueur();
        switch(nbJ) {
            case 1 : 
                Joueur jr = this.Gagnants.getJoueur(0);
                jTextArea1.append("\n*" + jr.getPseudo() + " " + this.optionName + "* ");
                jTextArea1.append("\n*Lot gagné: " + this.l.getDescip() + "*"); 
                jTextArea1.append("\n*Partie terminée*");
                //et arrêt de la partie
                this.demarre = false;
                jButton5.setEnabled(demarre);
                break;
            case 2 :
                Joueur jr1;
                for(int i = 0; i < 2; i++) {
                    jr1 = this.Gagnants.getJoueur(i);
                    jTextArea1.append("\n*" + jr1.getPseudo() + " " + this.optionName + "* ");
                }
                jTextArea1.append("\nEx aequo");
                int aleat = (int)(Math.random() * 2);
                jr1 = this.Gagnants.getJoueur(aleat);
                jTextArea1.append("\n* C'est " + jr1.getPseudo() + " qui gagne* ");
                jTextArea1.append("\n*Lot gagné: " + this.l.getDescip() + "*");
                jTextArea1.append("\n*Partie terminée*\n");
                //et arrêt de la partie
                this.demarre = false;
                jButton5.setEnabled(demarre);
                break;
            case 3 : 
                Joueur jr2;
                for(int i = 0; i < 3; i++) {
                    jr2 = this.Gagnants.getJoueur(i);
                    jTextArea1.append("\n*" + jr2.getPseudo() + " " + this.optionName + "* ");
                }
                jTextArea1.append("\nEx aequo");
                int aleat1 = (int)(Math.random() * 3);
                jr2 = this.Gagnants.getJoueur(aleat1);
                jTextArea1.append("\n* C'est " + jr2.getPseudo() + " qui gagne* ");
                jTextArea1.append("\n*Lot gagné: " + this.l.getDescip() + "*");
                jTextArea1.append("\n*Partie terminée*\n");
                //et arrêt de la partie
                this.demarre = false;
                jButton5.setEnabled(demarre);
                break;
            case 4 : 
                Joueur jr3;
                for(int i = 0; i < 4; i++) {
                    jr3 = this.Gagnants.getJoueur(i);
                    jTextArea1.append("\n*" + jr3.getPseudo() + " " + this.optionName + "* ");
                }
                jTextArea1.append("\nEx aequo");
                int aleat2 = (int)(Math.random() * 4);
                jr3 = this.Gagnants.getJoueur(aleat2);
                jTextArea1.append("\n C'est " + jr3.getPseudo() + " qui gagne* ");
                jTextArea1.append("\n*Lot gagné: " + this.l.getDescip() + "*");
                jTextArea1.append("\n*Partie terminée*\n");
                //et arrêt de la partie
                this.demarre = false;
                jButton5.setEnabled(demarre);
                break;
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
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
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
        jButton8 = new javax.swing.JButton();
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
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Le Jeu Loto");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Voici les cartes dont vous disposez");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setLayout(new java.awt.GridLayout(4, 2));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel14);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel15);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel16);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel18);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel19);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel20);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 111, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel21);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(4, 0));

        jButton1.setText("Joueur 1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setText("Joueur 2");
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
        jLabel2.setText("Cadeau:");
        jPanel5.add(jLabel2);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel9.add(jScrollPane1);

        jButton8.setText("Photo du cadeau");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton8);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText("Historique du tirage des boules");
        jPanel10.add(jLabel3);

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel7);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.GridLayout(1, 3));

        jButton5.setText("Tirage");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
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

        jLabel4.setText(" Option choisie: ");
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
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem5.setText("Acheter cartes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem4.setText("Démarrer jeu");
        jMenuItem4.setEnabled(false);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Continuer");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Recommencer");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            Joueur j = this.lstJ.getJoueur(0); //acces au premier joueur de la liste de Joueur(s)
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
            diag.setSize(900, 500); //specification de la taille de la jDialog
            diag.setLocation(100, 100); //specification de la localisation de la jDialog
            diag.setVisible(true); //definition de la visibilité du jDialog sur true ===> jDialog visible lors du clique
        } catch(IndexOutOfBoundsException e) {
            AucunJoueurDlg diag = new AucunJoueurDlg(this, true); //try catch pour manipuler une exception lorsqu'aucun joueur n'est ajouté à la partie
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize(); //JDialog implementée pour mettre en valeur la liste de joueurs vide
            int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
            diag.setLocation(x, y);
            diag.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.demarre = false;
        jButton5.setEnabled(demarre);
        jTextArea1.append("\n*Partie terminée*");
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
            
            this.test(); //appel a la methode qui fait un test pour voir si les conditions sont remplies pour activer la sous option Démarrer le jeu
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Joueur j = this.lstJ.getJoueur(1); //acces au deuxieme joueur de la liste de Joueur(s)
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
            diag.setLocation(100, 100);
            diag.setVisible(true); 
        } catch(IndexOutOfBoundsException e) { //try catch pour manipuler une exception lorsqu'aucun joueur n'est ajouté à la partie
            AucunJoueurDlg diag = new AucunJoueurDlg(this, true); //JDialog implementée pour mettre en valeur la liste de joueurs vide 
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
            diag.setLocation(x, y);
            diag.setVisible(true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            Joueur j = this.lstJ.getJoueur(2); //acces au troisieme joueur de la liste de Joueur(s)
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
            diag.setSize(900, 500);
            diag.setLocation(100, 100);
            diag.setVisible(true);
        } catch(IndexOutOfBoundsException e) { //try catch pour manipuler une exception lorsqu'aucun joueur n'est ajouté à la partie
            AucunJoueurDlg diag = new AucunJoueurDlg(this, true); //JDialog implementée pour mettre en valeur la liste de joueurs vide 
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
            diag.setLocation(x, y);
            diag.setVisible(true);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            Joueur j = this.lstJ.getJoueur(3); //acces au quatrieme joueur de la liste de Joueur(s)
            VisuJoueurDlg diag = new VisuJoueurDlg(this, true, j); //initialisation de la jDialog avec un parametre additionnel Joueur j
            diag.setSize(900, 500);
            diag.setLocation(100, 100);
            diag.setVisible(true);
        } catch(IndexOutOfBoundsException e) { //try catch pour manipuler une exception lorsqu'aucun joueur n'est ajouté à la partie
            AucunJoueurDlg diag = new AucunJoueurDlg(this, true); //JDialog implementée pour mettre en valeur la liste de joueurs vide 
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
            diag.setLocation(x, y);
            diag.setVisible(true);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        //ouverture de la jdialog qui permet le choix de l'option du jeu
        OptionDlg diag = new OptionDlg(this, true, false, nbCol, nbNum);
        diag.setSize(900, 500);
        diag.setLocation(100, 100);
        diag.setVisible(true); 
        
        if(diag.getOk() == true) { //à la fermeture on restitue les parametres qu'on veut changer dans l'appli principale
            this.option = diag.getChoix();
            this.optionName = diag.getchoixOptNom();
            this.optionChoisie = true;
            this.nbCol = diag.getNbCol();
            this.nbNum = diag.getNbNum();
            this.l = diag.getLot();
            jMenuItem5.setEnabled(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        try {
            AchatCarteDlg diag = new AchatCarteDlg(this, true, this.lstJ, 3, nbCol, nbNum); //initialisation de la jDialog avec des parametres 
            //lstJ(Liste des joueurs), 3 (nbLignes), nbCol, et nbNum
            diag.setSize(900, 500);
            diag.setLocation(100, 100);
            diag.setVisible(true);
            if(diag.getAchat() == true) { //test pour voir si une carte est achetée et mise de l'attribut carteAchetée a true
                for(int i = 0; i < this.lstJ.getNbJoueur(); i++) {
                    Joueur j = this.lstJ.getJoueur(i);
                    if(j.getMesCartes().getTaille() != 0) {
                        this.carteAchetée = true;
                        this.afficheCartes(); //affichage des cartes achetées
                    } else {
                        this.carteAchetée = false;
                    }
                }
            }
            this.test(); //appel a la methode qui fait un test pour voir si les conditions sont remplies pour activer la sous option Démarrer le jeu
        } catch(IndexOutOfBoundsException e) { //try catch pour manipuler une exception lorsqu'aucun joueur n'est ajouté à la partie
            AucunJoueurDlg diag = new AucunJoueurDlg(this, true); //JDialog implementée pour mettre en valeur la liste de joueurs vide
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
            diag.setLocation(x, y);
            diag.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //apres clique sur demarrer les cartes s'affiche et les infos sur l'option et le lot a gagner avec son image sur le bouton dédié
        Image img = this.l.getPhoto().getImage();
        Image newImg = img.getScaledInstance(70, 70, java.awt.Image.SCALE_SMOOTH);
        jButton8.setText("");
        jButton8.setIcon(new ImageIcon(newImg));
        jLabel2.setText("Cadeau: " + this.l.getDescip() + " ");
        jLabel4.setText("Option choisie: " + this.optionName);
        this.demarre = true;
        jButton5.setEnabled(demarre);
        jMenuItem5.setEnabled(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int num = 0; //initialisation du num a 0;
        try {
            //generation d'un nombre num aleatoire unique
            do {
                num = (int)(1 + Math.random() * 90);
            } while(this.boules[num] == 1);
            this.boules[num] = 1; 
            
        } catch(ArrayIndexOutOfBoundsException e) { //try catch pour manipuler la fin de nombre de boules a tirer
            jTextArea1.append(" ");
        }
        
        jLabel5.setText("" + num);
        jTextArea1.append(num + " * ");
        
        //c'est sensé demarrer le jeu en fonction de l'option choisie
//        for(int i = 0; i < this.lstJ.getNbJoueur(); i++) {
//            Joueur jr = this.lstJ.getJoueur(i);
//            for(int j = 0; j < jr.getMesCartes().getTaille(); j++) {
//                CarteLoto cl = jr.getMesCartes().getCarte(j);
//                if(cl.estDans(num)) {
//                    cl.placePion(num); //si la valeur existe on la place dans la carte
//                    this.afficheCartes();
//                    if(cl.cartonGagnant(this.option) == true) {
//                        this.Gagnants.ajouteJoueur(jr);
//                    }
//                }
//            }
//        }
//        this.Gagnant();
        
        //boucles pour essayer de touver si la valeur du numero tiré aleatoirement existe parmi les cartes des joueurs achetées
        for(int i = 0; i < this.lstJ.getNbJoueur(); i++) {
            Joueur jr = this.lstJ.getJoueur(i);
            for(int j = 0; j < jr.getMesCartes().getTaille(); j++) {
                CarteLoto cl = jr.getMesCartes().getCarte(j);
                if(cl.estDans(num)) { 
                    cl.placePion(num); //si la valeur existe on la place dans la carte
                    this.afficheCartes(); //on réaffiche les cartes mise a jour avec la valeur trouvée 
                    this.Gagnants.ajouteJoueur(jr); //on ajoute chaque joueur ayant cette valeur dans ça carte a la liste des gagnants
                }
            }
        }
        this.Gagnant(); //appel a la methode pour afficher le gagnant
    }//GEN-LAST:event_jButton5ActionPerformed
    
    
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //reinitialisation des tous les attributs a des valeurs par défaut
        this.option = 1;
        this.optionChoisie = false;
        this.demarre = false;
        jButton5.setEnabled(this.demarre);
        this.nbCol = 5;
        this.nbNum = 5;
        
        for(int i = 0; i < this.lstJ.getNbJoueur(); i++) {
            this.lstJ.getJoueur(i).getMesCartes().effacerTout();
        }
        
        for(int i = 0; i < this.Gagnants.getNbJoueur(); i++) {
            Joueur j = this.Gagnants.getJoueur(i);
            this.Gagnants.supprimeJoueur(j);
        }
        
        //suppression des jbutton initelement affichés dans la premiere partie
        for(int i = 0; i < 8; i++) {
            JPanel jp1 = (JPanel)jPanel2.getComponent(i);
            Component[] components = jp1.getComponents();
            for (Component component : components) {
                jp1.remove(component);  
            }
            jp1.revalidate();
            jp1.repaint();
        }
        
        //renitialisation des labels et boutton avec ecritures et supression des images
        jLabel5.setText("");
        jButton8.setIcon(null);
        jButton8.setText("Photo du cadeau");
        jTextArea1.setText("");
        jLabel2.setText("Cadeau:");
        jLabel4.setText("Option choisie: ");
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(this.option == 1) {
            this.option = 2;
            for(int i = 0; i < this.Gagnants.getNbJoueur(); i++) {
                Joueur j = this.Gagnants.getJoueur(i);
                this.Gagnants.supprimeJoueur(j);
            }
            this.demarre = true;
            jButton5.setEnabled(demarre);
            jMenuItem4.setEnabled(false);
        } else if(this.option == 2) {
            this.option = 2;
            for(int i = 0; i < this.Gagnants.getNbJoueur(); i++) {
                Joueur j = this.Gagnants.getJoueur(i);
                this.Gagnants.supprimeJoueur(j);
            }
            this.demarre = true;
            jButton5.setEnabled(demarre);
            jMenuItem4.setEnabled(false);
        } else {
            this.demarre = false;
            jButton5.setEnabled(demarre);
            jTextArea1.append("Niveau Carton Plein atteint");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

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
    private javax.swing.JButton jButton8;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
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


//comme indiqué dans l'énoncé le jeu commence avec deux joueurs prédéfinis
//        //on initialise un premier Joueur Ellis
//        Joueur j1 = new Joueur("Ellis");
//        j1.setCouleur(Color.red); 
//        //on lui donne une couleur rouge
//        this.lstJ.ajouteJoueur(j1); 
//        //on ajoute ce Joueur a la lstJ
//        
//        //on initialise un deuxieme Joueur Bob
//        Joueur j2 = new Joueur("Bob");
//        j2.setCouleur(Color.blue);  
//        //on lui donne une couleur bleue
//        this.lstJ.ajouteJoueur(j2);
//        
//        Joueur j3 = new Joueur("Aymene");
//        j3.setCouleur(Color.green); 
//        //on lui donne une couleur rouge
//        this.lstJ.ajouteJoueur(j3); 
//        //on ajoute ce Joueur a la lstJ
//        
//        //on initialise un deuxieme Joueur Bob
//        Joueur j4 = new Joueur("Josh");
//        j4.setCouleur(Color.yellow);  
//        //on lui donne une couleur bleue
//        this.lstJ.ajouteJoueur(j4);