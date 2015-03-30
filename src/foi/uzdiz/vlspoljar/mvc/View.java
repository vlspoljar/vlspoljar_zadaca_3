package foi.uzdiz.vlspoljar.mvc;

public class View {
    public Model model;
    
    public View(Model model) {
        this.model = model;
    }
    
    public void izbornik() {
        System.out.println("\n================================IZBORNIK=================================");
        System.out.println("-1 - ispis ukupnog broja direktorija i datoteka u strukturi");
        System.out.println("-2 - ispis sadrzaja strukture direktorija i datoteka");
        System.out.println("-3 - izvrsavanje dretve");
        System.out.println("-4 - prekid izvrsavanja dretve");
        System.out.println("-5 - ispis rednog broja i vremena spremljenih promjena stanja u strukturi");
        System.out.println("-6 - postavljanje stanja strukture na n");
        System.out.println("-7 - usporedivanje stanja strukture izmedu n i m");
        System.out.println("-8 - postavljanje trenutnog stanja strukture kao pocetno stanje");
        System.out.println("-9 - klasifikacija datoteka strukture po velicini");
        System.out.println("-Q - prekid rada programa");
        System.out.println("Vas odabir: ");
    }
    
    public void ispis(String out) {
        System.out.println(out);
    }
    
}
