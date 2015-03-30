package foi.uzdiz.vlspoljar.composite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datoteka implements Component {

    private String naziv;
    private String vrsta;
    private long vrijemePromjene;
    private long velicina;
    private Component roditelj;

    public Datoteka(String naziv, Component roditelj) {
        this.naziv = naziv;
        this.roditelj = roditelj;
    }
    
    public Datoteka(String naziv, String vrsta, long vrijemePromjene, long velicina, Component roditelj) {
        this.naziv = naziv;
        this.vrsta = vrsta;
        this.vrijemePromjene = vrijemePromjene;
        this.velicina = velicina;
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
        throw new UnsupportedOperationException("Nepodrzana operacija."); 
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Nepodrzana operacija."); 
    }

    @Override
    public Component getChild(int i) {
        throw new UnsupportedOperationException("Nepodrzana operacija.");
    }
    
}
