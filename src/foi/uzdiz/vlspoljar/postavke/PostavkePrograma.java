package foi.uzdiz.vlspoljar.postavke;

public class PostavkePrograma {
    public String putanja;
    public int brSekundi;
    public String datoteka;

    public PostavkePrograma(String putanja, int brSekundi, String datoteka) {
        this.putanja = putanja;
        this.brSekundi = brSekundi;
        this.datoteka = datoteka;
    }

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public int getBrSekundi() {
        return brSekundi;
    }

    public void setBrSekundi(int brSekundi) {
        this.brSekundi = brSekundi;
    }

    public String getDatoteka() {
        return datoteka;
    }

    public void setDatoteka(String datoteka) {
        this.datoteka = datoteka;
    }
    
}
