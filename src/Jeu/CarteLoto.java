package Jeu;

public class CarteLoto { 
    //declaration des attributs de la carte loto qui seront utilisés
    public int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private final int valMax = 90;
    
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
            for(int j = 0; i < nbCol; i++) {
                //parcours de la carte pour initialiser toutes les valeurs a 0 avant de leur donner des valeurs
                tab[i][j] = 0;
                jetons[i][j] = 0;
            }
        }
        
        //initialisations des valeurs des cartes avec des tests pour voir si la carte ne contient pas de repetitons
        int n, i = 0, j;
        for(int k = 0; i < this.nbNumeros; k++) {
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
        this.tab[1][4] = (int)(1 + 90 * Math.random());
        this.tab[1][2] = (int)(1 + 90 * Math.random());
        this.tab[2][3] = (int)(1 + 90 * Math.random());
        this.tab[0][4] = (int)(1 + 90 * Math.random());
        this.tab[2][2] = (int)(1 + 90 * Math.random());
    }
    
    public void initAutreCarte() {
        this.tab[1][1] = (int)(1 + 90 * Math.random());
        this.tab[1][3] = (int)(1 + 90 * Math.random());
        this.tab[2][4] = (int)(1 + 90 * Math.random());
        this.tab[0][3] = (int)(1 + 90 * Math.random());
        this.tab[2][1] = (int)(1 + 90 * Math.random());
    }
    
//    public boolean placePion(int val){
//        boolean res=false;  // initialisation de la var res a false
//        for(int i=0; i<this.nbLig; i++) { //boucle parcourant les lignes
//            for(int j=0; j<this.nbCol; j++) { //boucle parcourant les colonnes
//                if (tab[i][j]==val) {  //test pour voir si la val entrée correspond a la case (i, j)
//                    res=true;  //si oui, res prend la valeur booleene true
//                    jetons[i][j]=val; //on affect cette valeur au jeton (i, j)
//                }
//            }
//        }
//        return res; //on retourne res
//    }
}
