package Jeu;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Lot {
    
    //attributs
    private String description; //description du lot, sa nature
    private int niveau; //niveau du lot, 1, 2 ou 3
    private ImageIcon photo; //image du lot
    private Image img; //image du lot
    
    //accesseurs necessaires
    public void setDescrip(String s) {
        this.description = s;
    }
    
    public void setNiv(int i) {
        this.niveau = i;
    }
    
    public void setPhoto(ImageIcon i) {
        this.photo = i;
    }
    
    public void setImage(Image i) {
        this.img = i;
    }
    
    public String getDescip() {
        return this.description;
    }
    
    public int getNiv() {
        return this.niveau;
    }
    
    public ImageIcon getPhoto() {
        return this.photo;
    }
    
    public Image getImage() {
        return this.img;
    }
    
    //constructeur par défaut
    public Lot() {
        this.description = "";
        this.niveau = 1;
    }
    
    //constructeur avec parametre entier i
    public Lot(int i) {
        this.setNiv(i);
    }
    
    //constructeur avec parametre chaine de caractere
    public Lot(String des) {
        this.setDescrip(des);
    }
    
}
