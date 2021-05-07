package Jeu;

import java.awt.*;
import javax.swing.*;

public class CarteLotoCopy {
    //attributs
    private int tab[][];
    private int jetons[][];
    private int nbCol;
    private int nbLig;
    private int nbNumeros;
    private double prix;
    private final int valMax=90;
    //constructeur par defaut
    public CarteLotoCopy()
    {
        this.nbNumeros = 15; // modif
        this.nbCol = 9;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix=5;
        this.initMaCarte();
        initValeursCarte();
        
    }
    //constructeur avec en parametre
    public CarteLotoCopy(int nbc, int nbVal)
    {
        this.nbNumeros=nbVal;     // modif
        setNbNumeros(nbVal);
        this.nbCol = nbc;
        this.nbLig=3;
        this.tab = new int[nbLig][nbCol];
        this.jetons = new int[nbLig][nbCol];
        this.prix=5;
        this.initMaCarte();
        initValeursCarte();
    }
    // utile uniquement pour les tests
    // création d'une carte avec valeurs passées en paramètres
    public void CarteLotoAvant(int... v)
    {
        nbLig=3;
        nbNumeros=nbCol=v.length;
        System.out.println("carte avec "+nbLig+" et "+nbCol);
        tab = new int[nbLig][nbCol];
        jetons = new int[nbLig][nbCol];
        prix=5;
        int lig=0, col=0;
        for(int elt:v) 
        {  
            tab[lig][col]=elt; 
            if (lig<tab.length-1) lig++;
            col++;
        }
    }

    public double getPrix() { return this.prix; }
    public int getNbNumeros() { return this.nbNumeros;}
    public int getNbColonnes() { return this.nbCol; }
    public int getNbLignes() { return this.nbLig; }
    
    public void setNbNumeros(int nb)
    { if (nb >=0 && nb < this.nbLig*this.nbCol)
            this.nbNumeros=nb;
    }
       
    public int getCase(int i, int j)
    {
        if (i>=0 && i<this.nbLig && 0<=j && j<nbCol)
            return tab[i][j];
        else
            return -1;
    }
    
    public String toString()
    { String res="";
        for(int i=0; i<this.nbLig; i++)
        {
            for(int j=0; j<this.nbCol; j++)
                  res+="  "+tab[i][j];
            res+="\n";
        }
        return res;
    }
    
    public void initMaCarte()
     {
       for(int i=0; i<this.nbLig; i++)
            for(int j=0; j<this.nbCol; j++)
                 tab[i][j]=0;
       tab[0][1]=15;
       tab[0][4]=85;
       tab[1][3]=55;
       tab[2][0]=5;
       tab[2][2]=35;
     }
    
    public void initAutreCarte()
     {
         for(int i=0; i<this.nbLig; i++)
            for(int j=0; j<this.nbCol; j++)
                 tab[i][j]=0;
       tab[0][0]=10;
       tab[0][3]=90;
       tab[1][2]=30;
       tab[1][4]=60;
       tab[2][1]=20;
     }
    
    // retourne vrai si val est dans la carte
    //  et faux sinon  
    public boolean estDans(int val)
    { boolean res=false;
      int i=0;
      do
      {   int j=0;
          while(j<this.nbCol && tab[i][j]!=val)    
                    j++;
          if (j<this.nbCol) res=true;
          else i++;
      } while(i<nbLig && !res);
      return res;
    }
    
  
    // verifie si pion dans carte
     public boolean verifie(int val)
     {   boolean res=true;
         if (estDans(val))
               placePion(val); 
         else
             res=false;
         return res;
     }
     
    // met le pion dans la ligne et la colonne de val
   // modif private
     private boolean placePion(int val)
    { boolean res=false;
      for(int i=0; i<this.nbLig; i++)
            for(int j=0; j<this.nbCol; j++)
                  if (tab[i][j]==val) 
                  { res=true; jetons[i][j]=val;}
      return res;
    }
    
    // renvoie vrai si la ligne lig est recouverte de pions
    // modif private
     private boolean estLignePleine(int lig)
    { boolean res=true;
      for(int j=0; j<this.nbCol; j++)
              if (jetons[lig][j]!=tab[lig][j]) res=false;
        //System.out.println("estQuineLigne de "+lig+" renvoie "+res);
      return res;        
    }
    
    // renvoie le nbre de lignes qui sont recouvertes de pions
    private int getNbLignesPleines()
    { int res=0;
      for(int i=0; i<this.nbLig; i++)
            if (estLignePleine(i)) res++;
      return res;
    }
    
    public boolean cartonGagnant(int option)
    {  boolean res=false;
        switch (option)
        {
            case 1 : res=getNbLignesPleines()==1 ;break;
            case 2 : res= getNbLignesPleines()==2;break;
            case 3 : res= getNbLignesPleines()==3;
        }
        return res;
    }
    
    public boolean cartonGagnantTD(int option)
    {  
        return getNbLignesPleines()==option;
    }

    
    // dessine ou redessine la carte dans le JPanel jp avec la couleur coul
    //  la couleur est celle du joueur si elle est achetée
    //     et une tirée au sort sinon
    // mode indique s'il faut ou non placer les jetons
    public void dessineCarte(JPanel jp, Color coul, boolean mode)
    {
        JButton jb;
        jp.setLayout(new GridLayout(this.nbLig, this.nbCol));
        //System.out.println("dessineCarte avec "+nbLig+" - "+this.getNbColonnes());
        boolean redessine=jp.getComponentCount()!=0;
        for(int i=0; i<this.nbLig; i++)
            for(int j=0; j<this.nbCol; j++)
            { if (redessine)
                jb = (JButton)jp.getComponent(i*this.nbCol+j);
              else
               {   jb = new JButton();  jp.add(jb);}
              if (tab[i][j]==0)
                  jb.setText("");
              else
                  jb.setText(""+tab[i][j]);
              if (jetons[i][j]==0)
                   jb.setBackground(coul);
              else
                   if (mode) jb.setBackground(Color.white); 
                   else jb.setBackground(coul);             
            }
    }
   
    public int getValCase(int i, int j) {
        if(i >= 0 && i < this.nbLig && j >= 0 && j < this.nbCol) {
            return tab[i][j];
        }
        else {
            return -1;
      }
    }
    // méthode qui génère les valeurs d’une carte aléatoirement
    private void initValeursCarte(){
        for(int i=0; i<this.nbLig; i++) // boucle de parcours des lignes
            {for(int j=0; j<this.nbCol; j++)// boucle de parcours des colonnes
               {tab[i][j]=0; // on initialise le tableau tab avec des 0, ici la case (i,j)
                jetons[i][j]=0; // on initialise le tableau jetons avec des 0, ici la case (i,j)
               }
            } // ici les { sont inutiles car une seule instruction for dans la 1ere boucle
        int n, i=0, j; // on initialise i à 0, le i est e numéro de ligne (ici, 1ere ligne )
        // boucle qui répète nbNumeros (nombre de numéros dans la carte à générer) fois le traitement
        // par exemple si la carte à 3 lignes et 9 colonnes, on peut placer par exemple 15 numéros, 5 par lignes
        for(int k=0; k<this.nbNumeros; k++)
           {do
             {j=(int) (Math.random()*this.nbCol); // on génère un numéro de colonne jusqu’à trouver une case vide de tab
             }
            while (tab[i][j]!=0);
            do{
               n=(int)(Math.random()*this.valMax+1);// on génère un numéro (entre 1 et valMax, jusqu’à trouver un numéro qui n’existe pas déjà dans la carte
            } while (estDans(n));
            tab[i][j]=n; // on place le numéro (n) dans la case (i,j) de tab
            i=(i+1)%this.nbLig; // % signifie modulo, reste de la division entière
           //On suppose qu’on a 3 lignes, tthis.nbLig vaut 3, i=0 => i=1%3 vaut 1, le i vaut 1, => 2%3 vaut 2, i vaut 2, => 3%3 i vaut 0
           // le % permet de repasser à la 1ère ligne, en fait pour remplir, on met un numéro sur chaque ligne et on recommence
           // Donc chaque ligne aura le même nombre sur chaque ligne

}

}
    
  
     
    
    
    
    
    
  
    
           
    

    
    
}
