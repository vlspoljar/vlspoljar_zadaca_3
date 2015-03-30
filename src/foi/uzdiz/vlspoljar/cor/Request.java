package foi.uzdiz.vlspoljar.cor;

public class Request {

    private long velicina;
    private String naziv;

    public Request(long velicina, String naziv) {
        this.velicina = velicina;
        this.naziv = naziv;
    }

    public long getVelicina() {
        return velicina;
    }

    public void setVelicina(long velicina) {
        this.velicina = velicina;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
