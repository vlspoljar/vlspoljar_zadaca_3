package foi.uzdiz.vlspoljar.composite;

public interface Component {
    
    public void setNaziv(String naziv);
    
    public String getNaziv();
    
    public void setVrsta(String vrsta);
    
    public String getVrsta();
    
    public void setVrijemePromjene(long vrijemePromjene);
    
    public long getVrijemePromjene();
    
    public void setVelicina(long velicina);
    
    public long getVelicina();
    
    public void setRoditelj(Component roditelj);
    
    public Component getRoditelj();
    
    public void add(Component component);
    
    public void remove(Component component);
    
    public Component getChild(int i);
    
}
