/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice3;

/**
 *
 * @author Jaber
 */
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/********* Partie II **************************************/
 class Ensemble<T> extends LinkedList<T>
        implements Comparable<Ensemble<T>> {

    private int cardinal;

    public Ensemble() {
    }
    

    public int getCardinal() {
        return cardinal;
    }

    @Override
    public boolean add(T e) { //2 : Redéfinir (MAJ cardinal)
        cardinal++;
        return super.add(e);

    }

    @Override
    public boolean remove(Object o) {//3 : Redéfinir (MAJ cardinal)
        cardinal--;
        return super.remove((T) o);
    }

    public void union(Ensemble<T> e) {
        // calcule la réunion dans l'instance courante
        //4 : utiliser les itérateurs pour le parcours
        Iterator<T> it = e.iterator();
        while (it.hasNext()) {
            T x = it.next();
            if (this.isEmpty()) {
                this.add(x);

            }
            if (!this.contains(x)) {
                this.add(x);

            }
        }
    }

    public void inter(Ensemble<T> e) {
        //calcule l'intersection  dans l'instance courante
        //5 : utiliser les entiers pour le parcours
        for (int i = 0; i < cardinal; i++) {
            T x = this.get(i);
            if (!e.contains(x)) {
                this.remove(x);
            }
        }
    }

    public Ensemble(T[] t) {
        //6 : crée une instance à partir de "t", le tableau peut contenir
        // des répétitions
        for (T x : t) {
            if (this.isEmpty()) {
                this.add(x);

            }
            if (!this.contains(x)) {
                this.add(x);

            }
        }
    }

    public Ensemble<T> scinder() {
        //7:  partage l'instance courante en deux sous-ensembles de taille
        // agales à un près
        //l'un des sous-ensembles devient la valeur de l'instance courante
        int taille = (int) (this.cardinal / 2) + 1;
        Ensemble<T> ens = new Ensemble<T>();
        //Ensemble<T> t= new Ensemble<T>(); correct
        for (int i = taille; i < cardinal; i++) {
            T x = this.get(i);
            ens.add(x);
            this.remove(x);
        }
        return ens;
    }
    // 8: Définir la relation d'ordre naturel relativement à la taille

    public int compareTo(Ensemble<T> e) {
        Integer x = cardinal; //autoboxed int to Integer
        Integer y = e.cardinal;
        return x.compareTo(y);
    }
}

/********* Partie II **************************************/
class Part extends LinkedList<Ensemble<Integer>> {

    private int seuil;

    public Part(int seuil) {
        this.seuil = seuil;
    }

    public Part() {
    }

    public void ajouter(int x) { // 9 : définir
        Collections.sort((List) this);//ordonne la liste (this)
        this.getFirst().add(x);// ajout dans l'ensemble le plus petit(l'entête)
        if (this.getFirst().size() >= seuil) {
            Ensemble<Integer> ens = this.getFirst().scinder();
            this.addLast(ens);
        }
    }

    public void ajouer(int[] t) {
        //ajouter à la structure tous les éléments de "t"
        // 10 : définir en utilisant "for-each"
        for (int x : t) {
            this.ajouter(x);
        }

    }

    public Set<Integer> enSet() {
        // retourne un ensemble ordonné de tous les entiers contenus dans
        // la liste courante
        // 11 : Définir en utulisant les itérateurs pour le parcours
        Set<Integer> ensord = new TreeSet<Integer>();
        Iterator<Ensemble<Integer>> it = this.iterator();
        while (it.hasNext()) {
            Ensemble<Integer> tr = it.next();
            Iterator<Integer> it1 = tr.iterator();
            while (it1.hasNext()) {
                Integer x = it1.next();
                ensord.add(x);
            }
        }
        return ensord;
    }
}

 class Test {

    public static void main(String[] args) {
        Ensemble<Integer> e = new Ensemble<Integer>();
        e.add(10);
        e.add(12);
        e.add(4);
        e.add(19);

        Ensemble<Integer> e1 = new Ensemble<Integer>();
        e1.add(1);
        e1.add(2);
        e1.add(4);
        e1.add(5);
        Part p = new Part();
        p.add(e);p.add(e1);

        /* Attention : il faut faire le casting à List car Ensemble<Integer>
        dans ce cas est une LinkedList<Integer> */
        Collections.sort((List) e);
   
        System.out.println(e);
        Set<Integer> s= p.enSet();
        System.out.println(s);


    }
}