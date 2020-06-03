package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;
    private int taille;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = new Stack<T>();
        this.capacite = taille;
        this.taille=0;
        // à compléter
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
        // à compléter
    }

    public void empiler(T o) throws PilePleineException{
        if(!estPleine()){
            stk.push(o);
            taille++;
        }
        else throw new PilePleineException();
        // à compléter
    }

    public T depiler() throws PileVideException{
        // à compléter
        if(!estVide()){
            taille--;
            return stk.pop();
        }
        else throw new PileVideException();
    }

    public T sommet() throws PileVideException{
        // à compléter
        if(!estVide()){
            return stk.peek();
        }
        else throw new PileVideException();
    }
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
        remplirPile(pileTemp, this);
        return s + "]";
    }
    
    private void remplirPile(PileI p1, PileI p2){
        while(!p1.estVide()){
            try{
                p2.empiler(p1.depiler());
            } catch (PileVideException pve){pve.printStackTrace();}
            catch (PilePleineException ppe){ppe.printStackTrace();}
        }
    }
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


    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile

} // Pile2