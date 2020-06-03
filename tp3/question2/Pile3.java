package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int capacite;
    private int taille;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if(taille <= 0) taille = CAPACITE_PAR_DEFAUT;
        v = new Vector<Object>(taille);
        this.capacite = taille;
        this.taille = 0;
        
    }

    public void empiler(Object o) throws PilePleineException {
        if(!estPleine()) {
            v.addElement(o);
            this.taille++;
        }
        else throw new PilePleineException();
    }

    public Object depiler() throws PileVideException {
        if(!estVide()){
            this.taille--;
            return v.remove(this.taille());
        }
        else throw new PileVideException();
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }else{
             return v.lastElement();
        }
    }

    public int taille() {
        // à compléter
        return this.taille;
    }

    public int capacite() {
        // à compléter
        return this.capacite;
    }

    public boolean estVide() {
        // à compléter
        return this.taille == 0;
    }

    public boolean estPleine() {
        // à compléter
        return this.taille == this.capacite;
    }

    public String toString() {
        // à compléter
        String s = "[";
        for(int i = 0; i < this.taille; i++){
            s += v.get(i);
            if(i<this.taille - 1){
                s+=", ";
            }   
        }
        s += "]";
        return s;
    }

    public boolean equals(Object o) {
        if(o == null) return false;
        PileI pile2 = (PileI)o;
        if(this.capacite() != pile2.capacite()) return false;
        if(this.taille() != pile2.taille()) return false;
        if(this.toString().equals(pile2.toString())){
            return true;
        }else{
            return false;
        }
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
