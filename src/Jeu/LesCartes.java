package Jeu;

//imports necessaires
import java.util.ArrayList;

public class LesCartes {

    //attribut ArrayList de type CarteLoto
    private ArrayList<CarteLoto> lst;
    
    //constructeur par defaut
    public LesCartes() {
        lst = new ArrayList<CarteLoto>(); //instanciation de l'ArrayList
    }
    
    //methode permettant la restitution de la taille de l'ArrayList
    public int getTaille() {
        return this.lst.size();
    }
    
    //methode pour effacer le contenu de l'ArrayList
    public void effacerTout() {
        this.lst.removeAll(lst);
    }
    
    //methode permettant la restitution d'une CarteLoto d'index i de l'ArrayList
    public CarteLoto getCarte(int i) {
        return this.lst.get(i);
    }
    
    //methode permettant l'ajout d'une CarteLoto a l'ArrayList
    public void ajouteCarte(CarteLoto c) {
        this.lst.add(c);
    }
    
    //methode permettant de retirer une CarteLoto de l'ArrayList
    public void retireCarte(CarteLoto c) {
        int i = this.lst.indexOf(c);
        if(i != -1) {
            this.lst.remove(i);
        }
    } 
    
    //methode permettant de retirer totues les CarteLoto(s) de l'ArrayList
    public void retireCartes() {
        this.lst.clear();
    }
    
    //methode permettant d'initialiser un nombre n de CarteLoto avec un nb de colonnes et valeurs précis
    public void initLesCartes(int n, int nbCol, int nbVal) {
        for(int i = 0; i < n; i++) {
            CarteLoto cl = new CarteLoto(nbCol, nbVal);
            this.lst.add(cl);
        }
    }
    
    //methode permettant de rechercher toutes les CarteLoto(s) contenant une valeurs n et l'ajouter a une liste de CarteLoto contenue dans LesCartes
    public LesCartes rechCartes(int n) {
        LesCartes lc = new LesCartes(); //instanciation de la classe LesCartes
        int size = lc.lst.size();
        for(int i = 0; i < size; i++) { //parcours de toute l'ArrayList
            CarteLoto c = lc.lst.get(i);
            if(c.estDans(n)) { //test pour savoir si la valeur est dans la CarteLoto
                lc.ajouteCarte(c);
            }
        }
        return lc;
    }
    
    //methode permettant de donner les informations de toutes les CartesLoto(s) contenues dans une ArrayList de LesCartes sous forme de String
    public String toString() {
        String str = "";
        int size = this.lst.size();
        for(int i = 0; i < size; i++) {
            CarteLoto c = this.lst.get(i);
            str += "Carte n°" + (i + 1);
            str += "\n";
            str += c.toString();
        }
        return str;
    }
    
}
