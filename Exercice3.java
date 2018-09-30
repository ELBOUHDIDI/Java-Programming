/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercice3;

/**
 *
 * @author Jaber
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class Pair<U, V> {

    private U first;
    private V secend;

    public Pair(U a, V b) {
        this.first = a;
        this.secend = b;
    }

    public U getFirst() {
        return first;
    }

    public V getSecend() {
        return secend;
    }

    public void setFirst(U first) {
        this.first = first;
    }

    public void setSecend(V secend) {
        this.secend = secend;
    }

    @Override
    public String toString() {
        return "{" + first + "=>" + secend + "}";
    }
}

class Fcompare<U extends Comparable<U>, V> implements Comparator<Pair<U, V>> {

    public int compare(Pair<U, V> p1, Pair<U, V> p2) {
        U x = p1.getFirst();
        U y = p2.getFirst();
        return x.compareTo(y);
    }
}

class Scompare<U, V extends Comparable<V>> implements Comparator<Pair<U, V>> {

    public int compare(Pair<U, V> p1, Pair<U, V> p2) {
        V x = p1.getSecend();
        V y = p2.getSecend();
        return x.compareTo(y);
    }
}
//////////////////////////////////////////////////////////
class Lexique extends TreeSet<Pair<String, String>> {

    public Lexique(Comparator c) throws FileNotFoundException {
        super(c);
        Scanner s = new Scanner(new File("c:\\Lexique.txt"));
        while (s.hasNext()) {
            //System.out.println(s.next());
            //String fr=s.next();String an=s.next();
            if(c instanceof Fcompare){
            Pair<String, String> p = new Pair<String, String>(s.next(), s.next());
            this.add(p);}
            if(c instanceof Scompare){
                String fr=s.next();String an=s.next();
            Pair<String, String> p = new Pair<String, String>(an, fr);
            this.add(p);}
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////

    public Lexique lexFrAn() throws FileNotFoundException {
        Lexique l = new Lexique(new Fcompare<String, String>());
        return l;
    }
    /////////////////////////////////////////////////////////////////////////////////////

    public Lexique lexAnFr() throws FileNotFoundException {
        Lexique l = new Lexique(new Scompare<String, String>());
        return l;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
class Synonyme extends TreeSet<Pair<String, Set<String>>> {

    public Synonyme() {
        super(new Fcompare<String, Set<String>>());
    }

    public Set<String> localiser(String s) {
        Iterator<Pair<String, Set<String>>> it = this.iterator();
        while (it.hasNext()) {
            Pair<String, Set<String>> p = it.next();
            String str = p.getFirst();
            if (str.equalsIgnoreCase(s)) {
                return p.getSecend();
            }
        }
        return null;
    }
    //////////////////////////////////////////////////////////////////////

    public void ajouter(String s, String ss) {
        Set<String> tr = localiser(s);
        if (tr == null) {
            tr = new TreeSet<String>();
            tr.add(ss);
            this.add(new Pair<String, Set<String>>(s, tr));
        } else {
            tr.add(ss);//tr pointe sur la bonne position dans this

        }

    }
    ////////////////////////////////////////////////////////////////////

    public void ajouter(Pair<String, String> u) {
        Set<String> tr=localiser(u.getFirst());
        if(tr==null){
            tr=new TreeSet<String>();
            tr.add(u.getSecend());
            this.add(new Pair<String, Set<String>>(u.getFirst(),tr) );
        }else{
            tr.add(u.getSecend());
        }
    }
//////////////////////////////////////////////////////////////////////////////////
}

 class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Lexique l = new Lexique(new Fcompare());
        System.out.println(l);
        Synonyme s= new Synonyme();
        s.ajouter("salut","bonjour");
        s.ajouter("salut","salam");
         s.ajouter("salut","ca va");
          s.ajouter("trouver","localiser");
          s.ajouter("trouver","find");

        System.out.println(s);
    Lexique anfr=l.lexAnFr();
       System.out.println(anfr);
//
        Lexique fran=l.lexFrAn();
        System.out.println(fran);


    }
}