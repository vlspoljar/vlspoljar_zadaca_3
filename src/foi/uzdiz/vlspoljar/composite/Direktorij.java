package foi.uzdiz.vlspoljar.composite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Direktorij implements Component {

    private String naziv;
    private String vrsta;
    private long vrijemePromjene;
    private long velicina;
    private Component roditelj;
    static String out = "";
    public List<Component> componentList = new ArrayList<Component>();

    public Direktorij() {
    }

    public Direktorij(String naziv, Component roditelj) {
        this.naziv = naziv;
        this.roditelj = roditelj;
    }

    public Direktorij(String naziv, String vrsta, long vrijemePromjene, long velicina, Component roditelj) {
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.vrijemePromjene = vrijemePromjene;
        this.velicina = velicina;
        this.roditelj = roditelj;
    }

    public List<Component> getListaDjece() {
        return componentList;
    }

    public void setListaDjece(List<Component> listaDjece) {
        this.componentList = listaDjece;
    }

    @Override
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String getNaziv() {
        return naziv;
    }

    @Override
    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String getVrsta() {
        return vrsta;
    }

    @Override
    public void setVrijemePromjene(long vrijemePromjene) {
        this.vrijemePromjene = vrijemePromjene;
    }

    @Override
    public long getVrijemePromjene() {
        return vrijemePromjene;
    }

    @Override
    public void setVelicina(long velicina) {
        this.velicina = velicina;
    }

    @Override
    public long getVelicina() {
        return velicina;
    }

    @Override
    public void setRoditelj(Component roditelj) {
        this.roditelj = roditelj;
    }

    @Override
    public Component getRoditelj() {
        return roditelj;
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void remove(Component component) {
        componentList.remove(component);
    }

    @Override
    public Component getChild(int i) {
        return componentList.get(i);
    }  

}
