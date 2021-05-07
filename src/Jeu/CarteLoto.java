package Jeu;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CarteLoto { 
    //declaration des attributs de la carte loto qui seront utilisés
    public int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private final int valMax = 90;
    private final int prix = 5;
    
    //accesseurs
    public int getNbCol() {
        return this.nbCol;
    }
    
    public int getNbLig() {
        return this.nbLig;
    }
    
    public void setNbNumeros(int nb) {
        if(this.nbNumeros < 15) {
            this.nbNumeros = nb;
        }
    }
    
    public int getNbNumeros() {
        return this.nbNumeros;
    }
    
    public int getPrix() {
        return this.prix;
    }
    
    //methodes qui permet de restituer la valeur de la case en donnant ses coordonnées i, j
    public int getValCase(int i, int j) {
        if(i >= 0 && i < this.nbLig && j >= 0 && j < this.nbCol) {
            return tab[i][j];
        }
        else {
            return -1;
      }
    }
    
    //constructeur par defaut
    public CarteLoto() {
        this.nbNumeros = 15;
        this.nbCol = 5;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        initMaCarte();
    }
    
    //constructeur standard
    public CarteLoto(int nbc, int nbVal) {
        this. nbNumeros = nbVal;
        this.nbCol = nbc;
        this.nbLig = 3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        initMaCarte();
    }
    
    //methode toString() qui retourne une chaine de caractere qui sera affiché dans chaque carte de la carte loto, comportant son numero
    public String toString() {
        String res = ""; //initialisation de la String vide
        for(int i = 0; i < this.nbLig; i++) {
            for(int j = 0; j < this.nbCol; j++){
                //on parcourt toutes les cartes, on parcourant les lignes ainsi que les colonnes pour restituer les cartes qui ne sont pas vides
                if(tab[i][j] < 10) {
                    res += "  " + tab[i][j];
                }
                else {
                    res += " " + tab[i][j];
                }
            }
            res += "\n";
        }
        return res;
    }
    
    //methode qui initialise les valeurs de la carte en donnant à chaque carte une valeur sans qu'elle soit repetée
    public void initValeursCarte() { 
        for(int i = 0; i < nbLig; i++) {
            for(int j = 0; j < nbCol; j++) {
                //parcours de la carte pour initialiser toutes les valeurs a 0 avant de leur donner des valeurs
                tab[i][j] = 0;
                jetons[i][j] = -1;
            }
        }
        
        //initialisations des valeurs des cartes avec des tests pour voir si la carte ne contient pas de repetitons
        int n, i = 0, j;
        for(int k = 0; k < this.nbNumeros; k++) {
            do {
                j = (int)(Math.random() * this.nbCol); 
            } while(tab[i][j] != 0);
            do {
                n = (int)(1 + Math.random() * this.valMax); 
            } while(estDans(n));
            tab[i][j] = n;
            i = (i + 1) % this.nbLig;
        }
    }
    
    //methode permettant de faire le test pour voir si une valeur existe deja dans la carte loto
    public boolean estDans(int val){
        boolean res=false; //initialisation du boolean res sur false
        for(int i=0; i<this.nbLig; i++){
            for(int j=0; j<this.nbCol; j++){
                //parcours de toute la carte pour effectuer le test sur toutes les valeurs de la carte loto
                if (tab[i][j]==val){
                    res=true;
                }
            }
        }
        return res; 
    }
    
    public void initMaCarte() {
        for(int i = 0; i <= this.nbNumeros; i++) {
            int a = (int)(Math.random() * 3);
            int b = (int)(Math.random() * this.nbCol);
            int c = (int)(this.valMax * Math.random() + 1);
            this.tab[a][b] = c;
        }
    }
    
    public void effaceCarte() {  //initialisation des valeurs de la carte
        for(int i = 0; i < this.nbLig; i++){
            for(int j = 0; j < this.nbCol; j++){
                this.tab[i][j] = 0;
            }
        }    
    }
    
    public void dessineCarte(JPanel jp, Color col) { //methode de dessin de la carte
        jp.removeAll();
        jp.setLayout(new GridLayout(this.getNbLig(), this.getNbCol()));
        for(int i = 0; i < this.getNbLig(); i++) {
            for(int j = 0; j < this.getNbCol(); j++) {
                JButton jb = new JButton();
                int val = this.getValCase(i, j);
                if(val == 0) {
                    jb.setText("");
                } else {
                    jb.setText(val + "");
                }
                if(this.tab[i][j] == this.jetons[i][j]) {
                    jb.setBackground(Color.white);
                } else {
                    jb.setBackground(col);
                }
                //jb.setBackground(col);
                jp.add(jb);
            }
        }
    }
    
//    public void placePion(int val){
//        for(int i = 0; i < this.nbLig; i++) { //boucle parcourant les lignes
//            for(int j = 0; j < this.nbCol; j++) { //boucle parcourant les colonnes
//                if (tab[i][j] == val) {  //test pour voir si la val entrée correspond a la case (i, j)
//                    jetons[i][j] = val; //on affect cette valeur au jeton (i, j)
//                }
//            }
//        }
//    } 
    
    public boolean placePion(int val){
        boolean res = false;  // initialisation de la var res a false
        for(int i = 0; i < this.nbLig; i++) { //boucle parcourant les lignes
            for(int j = 0; j < this.nbCol; j++) { //boucle parcourant les colonnes
                if (tab[i][j] == val) {  //test pour voir si la val entrée correspond a la case (i, j)
                    res = true;  //si oui, res prend la valeur booleene true
                    jetons[i][j] = val; //on affect cette valeur au jeton (i, j)
                }
            }
        }
        return res; //on retourne res
    } 
    
    // renvoie vrai si la ligne lig est recouverte de pions
    // modif private
     private boolean estLignePleine(int lig) { 
        boolean res = true;
        for(int j = 0; j < this.nbCol; j++){
            if (jetons[lig][j] != tab[lig][j]) {
                res=false;
            }
        }
        return res;        
    }
    
    // renvoie le nbre de lignes qui sont recouvertes de pions
    private int getNbLignesPleines() { 
        int res=0;
        for(int i = 0; i < this.nbLig; i++) {
            if (estLignePleine(i)) {
                res++;
            }
        }
        return res;
    }
    
    public boolean cartonGagnant(int option) {  
        boolean res=false;
        switch (option) {
            case 1 : 
                res = getNbLignesPleines()== 1;
                break;
            case 2 : 
                res = getNbLignesPleines()== 2;
                break;
            case 3 : 
                res = getNbLignesPleines()== 3;
        }
        return res;
    }

}
//    public void initMaCarte() {
//        this.tab[1][4] = (int)(1 + 90 * Math.random());
//        this.tab[1][2] = (int)(1 + 90 * Math.random());
//        this.tab[2][3] = (int)(1 + 90 * Math.random());
//        this.tab[0][4] = (int)(1 + 90 * Math.random());
//        this.tab[2][2] = (int)(1 + 90 * Math.random());
//    }
    
//    public void initAutreCarte() {
//        this.tab[1][1] = (int)(1 + 90 * Math.random());
//        this.tab[1][3] = (int)(1 + 90 * Math.random());
//        this.tab[2][4] = (int)(1 + 90 * Math.random());
//        this.tab[0][3] = (int)(1 + 90 * Math.random());
//        this.tab[2][1] = (int)(1 + 90 * Math.random());
//    }
    
       
        
//for(int a = 0; a < this.getNbLig(); a++) {
//                    for(int b = 0; b < this.getNbCol(); b++) {
//                        
//                            
//                        }
//                    }
//                }