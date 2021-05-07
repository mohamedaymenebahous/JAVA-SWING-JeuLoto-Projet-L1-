package Jeu;

import java.util.ArrayList;

public class Lots {
    
    private ArrayList<Lot> lots; //liste de Lot de type ArrayList
    
    public void ajouteLot(Lot l) { //methode qui permet d'ajouter un lot a la liste
        this.lots.add(l);
    }
     
    public Lot getLot(int i) { //methode qui permet de restituer un lot specifique
        return this.lots.get(i);
    }
    
    public Lots() { //constructeur qui permet l'instanciation de l'ArrayList
        lots = new ArrayList<Lot>();
    }

}
