package foi.uzdiz.vlspoljar.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    public List<Memento> mementoList = new ArrayList<Memento>();

    public List<Memento> getMementoList() {
        return mementoList;
    }

    public void setMementoList(List<Memento> mementoList) {
        this.mementoList = mementoList;
    } 
    
    public void add(Memento memento) {
        mementoList.add(memento);
    }
    
    public void remove(int index) {
        mementoList.remove(index);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
