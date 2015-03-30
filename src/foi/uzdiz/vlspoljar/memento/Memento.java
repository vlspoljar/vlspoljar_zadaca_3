package foi.uzdiz.vlspoljar.memento;

import foi.uzdiz.vlspoljar.composite.Direktorij;

public class Memento {

    Direktorij mementoRoot;
    long mementoVrijemeStanja;

    public Direktorij getMementoRoot() {
        return mementoRoot;
    }

    public void setMementoRoot(Direktorij mementoRoot) {
        this.mementoRoot = mementoRoot;
    }

    public long getMementoVrijemeStanja() {
        return mementoVrijemeStanja;
    }

    public void setMementoVrijemeStanja(long mementoVrijemeStanja) {
        this.mementoVrijemeStanja = mementoVrijemeStanja;
    }
    
    public Memento(Direktorij root, long vrijemeStanja) {
        this.mementoRoot = root;
        this.mementoVrijemeStanja = vrijemeStanja;
    }

    public Direktorij getState() {
        return mementoRoot;
    }

}
