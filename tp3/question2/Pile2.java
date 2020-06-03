package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        if(taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.stk = new Stack<Object>();
        this.capacite = taille;
        
        // prevoir le cas <=0
        // a completer
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine()){
            throw new PilePleineException();
        }
        this.stk.push(o);
        // a completer
    }

    public Object depiler() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return this.stk.pop();
    }

    public Object sommet() throws PileVideException {
        if(estVide()){
            throw new PileVideException();
        }
        return this.stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return this.stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return this.taille() == this.capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        Pile2 pileTemp = new Pile2(capacite());
        Object tempObject = new Object();
        String s = "[";
        while (!estVide()){
            try{
                tempObject = depiler();
            } catch (PileVideException pve){pve.printStackTrace();}
            s += (tempObject==null) ? "null": tempObject.toString();
            try{
                pileTemp.empiler(tempObject);
            } catch (PilePleineException ppe){ppe.printStackTrace();}
            if(!estVide())
                s += ", ";
        }
        remplir(pileTemp, this);
        return s + "]";
    }
    
    private void remplir(PileI p1, PileI p2){
        while(!p1.estVide()){
            try{
                p2.empiler(p1.depiler());
            } catch (PileVideException pve){pve.printStackTrace();}
            catch (PilePleineException ppe){ppe.printStackTrace();}
        }
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

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        return this.stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        return this.capacite;
    }

} // Pile2.java
