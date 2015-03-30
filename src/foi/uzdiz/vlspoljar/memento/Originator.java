package foi.uzdiz.vlspoljar.memento;

import foi.uzdiz.vlspoljar.composite.Direktorij;

public class Originator {

    private Direktorij root;
    private long vrijemeStanja;

    public Originator() {
    }

    public void setState(Direktorij root, long vrijemeStanja) {
        this.root = root;
        this.vrijemeStanja = vrijemeStanja;
    }

    public Direktorij getState() {
        return root;
    }

    public Memento saveStateToMemento() {
        return new Memento(root, vrijemeStanja);
    }

    public void getStateFromMemento(Memento memento) {
        root = memento.getState();
    }
    
}
