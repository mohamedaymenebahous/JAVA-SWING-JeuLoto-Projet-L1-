package Jeu;

//imports necessaires
import java.util.ArrayList;

public class LesJoueurs {

    //attribut ArrayList de type Joueur
    private ArrayList<Joueur> lstJ;
    
    //constructeur par defaut
    public LesJoueurs() {
        lstJ = new ArrayList<Joueur>(); //instanciation de l'ArrayList
    }
    
    //methode permettant la restitution d'un Joueur d'index i de l'ArrayList
    public Joueur getJoueur(int i) {
        return this.lstJ.get(i);
    }
    
    //methode permettant la restitution de la taille de l'ArrayList
    public int getNbJoueur() {
        return this.lstJ.size();
    }
    
    //methode permettant l'ajout d'un Joueur a l'ArrayList
    public void ajouteJoueur(Joueur j) {
        this.lstJ.add(j);
    }
    
    //methode permettant de retirer un Joueur de l'ArrayList
    public void supprimeJoueur(Joueur j) {
        int i = this.lstJ.indexOf(j);
        if(i != -1) {
            this.lstJ.remove(i);
        }
    }
    
    //methode permettant de rechercher un Joueur avec son pseudos et l'ajouter a une liste de Joueur contenue dans LesJoueurs
    public Joueur rechJoueur(String ps) {
        LesJoueurs lj = new LesJoueurs(); //instanciation de la classe LesJoueurs
        int size = lj.lstJ.size();
        for(int i = 0; i < size; i++) { //parcours de toute l'ArrayList
            Joueur j = lj.lstJ.get(i);
            if(j.getPseudo().equals(ps)) { //test pour savoir si le pseudo du Joueur est egal a celui donné en parametre
                lj.ajouteJoueur(j);
            }
        }
        return lj.getJoueur(0);
    }
    
    //methode permettant de donner les informations d'un Joueur sous forme de String
    public String toString() {
        Joueur j = new Joueur(); //instanciation de la classe Joueur
        String str = "";
        str += "Pseudo: " + j.getPseudo() + "\n";
        str += "Couleur" + j.getCouleur() + "\n";
        str += "Solde" + j.getSolde()+ "\n";
        return str;
    }
    
}
