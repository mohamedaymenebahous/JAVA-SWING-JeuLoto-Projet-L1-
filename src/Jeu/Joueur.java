package Jeu;

//imports necessaires
import java.awt.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Joueur {
    
    //attributs utiles pour la classe Joueur
    private String pseudo;
    private Color couleur;
    private double solde;
    private ImageIcon photo;
    private LesCartes mesC;
    private Lots ll;
    
    //accesseurs
    public void setPseudo(String p) { 
        this.pseudo=p; 
    }
    
    public void setCouleur(Color c) { 
        this.couleur = c; 
    }
    
    public void setPhoto(ImageIcon p) { 
        this.photo = p; 
    }
    
    public void setSolde(double s) { 
        this.solde = s; 
    }
    
    public void setMesCartes(LesCartes c) {
        this.mesC = c;
    }

    public String getPseudo() { 
        return this.pseudo;  
    }
    
    public Color getCouleur() { 
        return this.couleur; 
    }
    
    public double getSolde() { 
        return this.solde; 
    }
     
    public ImageIcon getPhoto() { 
        return this.photo;
    }
    
    public LesCartes getMesCartes() {
        return this.mesC;
    }

    //constructeur par defaut
    public Joueur() {
        this.setPseudo("");
        this.setCouleur(Color.gray);
        this.setSolde(20);
        
        this.mesC = new LesCartes();
        //this.photo = new ImageIcon("/GestionJoueur/joueurDefaut.png");
        try{
            this.photo = new ImageIcon(getClass().getResource("../img/joueurDefaut.png"));
        } catch(NullPointerException e) {
            this.photo = new ImageIcon(getClass().getResource(""));
        }
    }

    //constructeur standard
    public Joueur(String p) {
        this.setPseudo(p);
        this.couleur = Color.gray;
        this.solde = 20;
        this.mesC = new LesCartes();
        //this.photo = new ImageIcon("/GestionJoueur/joueurDefaut.png");
        try{
            this.photo = new ImageIcon(getClass().getResource("../img/joueurDefaut.png"));
        } catch(NullPointerException e) {
            this.photo = new ImageIcon(getClass().getResource(""));
        }
    }

    //methode toString() permettant de retourner toutes les infos du joueur sous forme de String
    public String toString() {
        String res= "\nJoueur " + this.getPseudo();
        res+= "\nCouleur " + this.getCouleur();
        res+= "\nSolde " + this.getSolde();
        res+= "\nNombre de cartes " + this.getMesCartes().getTaille();
        return res;
    }
    
    //methode qui permet d'acheter une carte == l'ajouter a la liste des cartes du joueur
    public void acheterCarte(CarteLoto c) {
        if(this.getSolde() >= 5) {
            this.mesC.ajouteCarte(c);
            this.setSolde(this.getSolde() - 5);
        }
    }
    
}
