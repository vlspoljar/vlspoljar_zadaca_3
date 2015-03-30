package foi.uzdiz.vlspoljar.mvc;

import foi.uzdiz.vlspoljar.composite.Component;
import foi.uzdiz.vlspoljar.composite.Datoteka;
import foi.uzdiz.vlspoljar.composite.Direktorij;
import foi.uzdiz.vlspoljar.cor.ConcreteHandlerMali;
import foi.uzdiz.vlspoljar.cor.ConcreteHandlerSrednji;
import foi.uzdiz.vlspoljar.cor.ConcreteHandlerVeliki;
import foi.uzdiz.vlspoljar.cor.Handler;
import foi.uzdiz.vlspoljar.cor.Request;
import foi.uzdiz.vlspoljar.memento.Caretaker;
import foi.uzdiz.vlspoljar.memento.Originator;
import foi.uzdiz.vlspoljar.postavke.PostavkePrograma;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {

    private PostavkePrograma postavkePrograma;
    public int brojDirektorija;
    public int brojDatoteka;
    public Direktorij rootDirektorij;
    public Direktorij noviRootDirektorij;
    public Direktorij struktura;
    public Direktorij novaStruktura;
    public String out;
    public Caretaker caretaker;
    public Originator originator;
    public boolean zastavica = false;
    public boolean promjena = false;
    public int indeks = -1;
    public List<String> listaUspordbi;
    public List<String> listaUspordbiNovi;
    public List<String> listaUspordbiTrenutni;
    public List<String> listaPromjena;
    public File file;

    public Model() {
        caretaker = new Caretaker();
        originator = new Originator();

    }

    public PostavkePrograma getPostavkePrograma() {
        return postavkePrograma;
    }

    public void setPostavkePrograma(PostavkePrograma postavkePrograma) {
        this.postavkePrograma = postavkePrograma;
    }

    public int getBrojDirektorija() {
        return brojDirektorija;
    }

    public void setBrojDirektorija(int brojDirektorija) {
        this.brojDirektorija = brojDirektorija;
    }

    public int getBrojDatoteka() {
        return brojDatoteka;
    }

    public void setBrojDatoteka(int brojDatoteka) {
        this.brojDatoteka = brojDatoteka;
    }

    public void struktura() {
        stvoriStrukturu(postavkePrograma.putanja);
    }

    public boolean isZastavica() {
        return zastavica;
    }

    public void setZastavica(boolean zastavica) {
        this.zastavica = zastavica;
    }

    public boolean isPromjena() {
        return promjena;
    }

    public void setPromjena(boolean promjena) {
        this.promjena = promjena;
    }

    public Direktorij getRootDirektorij() {
        return rootDirektorij;
    }

    public void setRootDirektorij(Direktorij rootDirektorij) {
        this.rootDirektorij = rootDirektorij;
    }

    public Direktorij stvoriStrukturu(String root) {
        brojDirektorija = 0;
        brojDatoteka = 0;
        File f = new File(root);
        rootDirektorij = new Direktorij(f.getName(), "Direktorij", f.lastModified(), 0, null);
        stvoriKomponente(root, rootDirektorij);
        rootDirektorij.setVelicina(rootDirektorij.getListaDjece().size());
        originator.setState(rootDirektorij, System.currentTimeMillis());
        caretaker.add(originator.saveStateToMemento());
        return rootDirektorij;
    }

    public Direktorij stvoriNovuStrukturu(String root) {
        brojDirektorija = 0;
        brojDatoteka = 0;
        File f = new File(root);
        noviRootDirektorij = new Direktorij(f.getName(), "Direktorij", f.lastModified(), 0, null);
        stvoriKomponente(root, noviRootDirektorij);
        noviRootDirektorij.setVelicina(noviRootDirektorij.getListaDjece().size());
        return noviRootDirektorij;
    }

    public void stvoriKomponente(String root, Direktorij direktorij) {
        File f = new File(root);
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                Direktorij componentDirektorij = new Direktorij(file.getName(), direktorij);
                componentDirektorij.setVrsta("Direktorij");
                componentDirektorij.setVrijemePromjene(file.lastModified());
                direktorij.add(componentDirektorij);
                brojDirektorija++;
                stvoriKomponente(file.getPath(), componentDirektorij);
                componentDirektorij.setVelicina(componentDirektorij.getListaDjece().size());
            } else {
                Datoteka componentDatoteka = new Datoteka(file.getName(), direktorij);
                componentDatoteka.setVrsta("Datoteka");
                componentDatoteka.setVrijemePromjene(file.lastModified());
                componentDatoteka.setVelicina(file.length());
                brojDatoteka++;
                direktorij.add(componentDatoteka);
            }
        }
    }

    public String ispisiStrukturu() {
        out = "\n===Ispis sadrazaja strukture direktorija i datoteka===\n";
        out += "Naziv\t\t\t\t\t\t\t\t\tVrsta\t\t\tVrijeme promjene\t\t\tVelicina\n";
        out += (originator.getState().getNaziv() + "\t\t\t\t\t\t\t\t\t" + originator.getState().getVrsta() + "\t\t\t" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(originator.getState().getVrijemePromjene())) + "\t\t\t" + originator.getState().getVelicina() + "\n");
        ispisiKomponente(originator.getState(), "\t");
        return out;
    }

    public void ispisiKomponente(Direktorij rootDir, String tab) {
        for (Component component : rootDir.getListaDjece()) {
            if (component.getVrsta().equals("Direktorij")) {
                out += (tab + component.getNaziv() + "\t\t\t\t\t" + component.getVrsta() + "\t\t\t" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(component.getVrijemePromjene())) + "\t\t\t" + component.getVelicina() + "\n");
                ispisiKomponente((Direktorij) component, tab + "\t");
            } else {
                out += (tab + component.getNaziv() + "\t\t\t\t\t" + component.getVrsta() + "\t\t\t" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(component.getVrijemePromjene())) + "\t\t\t" + component.getVelicina() / 1024 + " KB\n");
            }
        }
    }

    public String startDretva() {
        zastavica = true;
        out = "Pocetak izvrsavanja dretve...";
        if (postavkePrograma.datoteka != "") {
            file = new File(postavkePrograma.datoteka);
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (zastavica) {
                    long pocetak = System.nanoTime();

                    novaStruktura = new Direktorij();
                    novaStruktura = stvoriNovuStrukturu(postavkePrograma.putanja);
                    out = usporediStanja(originator.getState(), novaStruktura) + "\n";
                    System.out.println(out);
                    if (postavkePrograma.datoteka != "") {
                        FileWriter fw = null;
                        try {
                            fw = new FileWriter(file, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(out);
                            bw.flush();
                        } catch (IOException ex) {
                            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            try {
                                fw.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    if (promjena) {
                        originator.setState(novaStruktura, System.currentTimeMillis());
                        caretaker.add(originator.saveStateToMemento());
                    }

                    try {
                        long spavanje = postavkePrograma.brSekundi * 1000 - (System.nanoTime() - pocetak) / 1000000;
                        if (spavanje < 0) {
                            spavanje = 0;
                        }
                        Thread.sleep(spavanje);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        t.start();
        return out;
    }

    public String stopDretva() {
        zastavica = false;
        return "Dretva prekinuta!";
    }

    public String ispisiSpremljenihStanja() {
        out = "\n===Ispis rednog broja i vremena spremljenih promjena stanja strukture===\n";
        if (caretaker.mementoList != null) {
            for (int i = 0; i < caretaker.mementoList.size(); i++) {
                originator.getStateFromMemento(caretaker.get(i));
                out += "Redni broj: " + i + "\t" + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(caretaker.get(i).getMementoVrijemeStanja())) + "\n";
            }
        } else {
            out += "Nema spremljenih stanja strukture.";
        }
        return out;
    }

    public String postavljanjeStanjaStruktureNaN(int n) {
        out = "\n===Postavljanje stanja strukture na n===\n";
        if (n > caretaker.mementoList.size()) {
            out += "Ne postoji spremljeno stanje strukture sa rednim brojem " + n;
        } else {
            originator.getStateFromMemento(caretaker.get(n));
            rootDirektorij = originator.getState();
            out += "Postavljeno stanje strukture na " + n;
            indeks = n;
        }
        return out;
    }

    public String postavljanjeTrenutnogStanja() {
        out = "\n===Postavljanje trenutnog stanja strukture kao pocetno stanje===\n";
        rootDirektorij = originator.getState();
        if (indeks == -1) {
            for (int i = 0; i < caretaker.mementoList.size() - 1; i++) {
                caretaker.mementoList.remove(i);
            }
        } else {
            for (int i = 0; i < indeks; i++) {
                caretaker.mementoList.remove(i);
            }
        }
        out += "Trenutno stanje postavljeno kao pocetno.";
        return out;
    }

    public String odaberiStanja(int N, int M) {
        if (N > caretaker.mementoList.size()) {
            return "Ne postoji spremljeno stanje strukture sa rednim brojem " + N;
        } else if (M > caretaker.mementoList.size()) {
            return "Ne postoji spremljeno stanje strukture sa rednim brojem " + M;
        } else {
            return usporediStanja(caretaker.get(N).getMementoRoot(), caretaker.get(M).getMementoRoot());
        }
    }

    public String usporediStanja(Direktorij root1, Direktorij root2) {
        out = "";
        /*for (String s : stvoriListuUsporedbi(caretaker.getMementoList().get(N).getMementoRoot())) {
         out += s;
         }*/
        listaUspordbiTrenutni = new ArrayList<>();
        listaUspordbiNovi = new ArrayList<>();
        listaPromjena = new ArrayList<>();
        listaUspordbiTrenutni = stvoriListuUsporedbi(root1);
        listaUspordbiNovi = stvoriListuUsporedbi(root2);
        for (String s1 : listaUspordbiNovi) {
            if (!listaUspordbiTrenutni.contains(s1)) {
                listaPromjena.add(s1 + "\t" + "Dodan je novi element u strukturu.\n");
            }
        }
        for (String s2 : listaUspordbiTrenutni) {
            if (!listaUspordbiNovi.contains(s2)) {
                listaPromjena.add(s2 + "\t" + "Obrisan je element iz strukture.\n");
            }
        }
        if (listaPromjena.isEmpty()) {
            out += new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(System.currentTimeMillis())) + "\tNema promjene.";
            promjena = false;
        } else {
            for (String s : listaPromjena) {
                out += new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(System.currentTimeMillis())) + "\t" + postavkePrograma.putanja + s;
            }
            promjena = true;
        }
        return out;
    }

    public List<String> stvoriListuUsporedbi(Direktorij rootD) {
        listaUspordbi = new ArrayList<>();
        stvoriKomponenteUsporedbe(rootD, "\\");
        return listaUspordbi;
    }

    public void stvoriKomponenteUsporedbe(Direktorij d, String putanjaRoditelj) {
        for (Component component : d.getListaDjece()) {
            if (component.getVrsta().equals("Direktorij")) {
                listaUspordbi.add(putanjaRoditelj + component.getNaziv() + "\t" + component.getVrijemePromjene() + "\t" + component.getVelicina() + "\n");
                stvoriKomponenteUsporedbe((Direktorij) component, putanjaRoditelj + component.getNaziv() + "\\");
            } else {
                listaUspordbi.add(putanjaRoditelj + component.getNaziv() + "\t" + component.getVrijemePromjene() + "\t" + component.getVelicina() + "\n");
            }
        }
    }
    
    public String setUpChain() {
        Direktorij direktorij = new Direktorij("Datoteke", "Direktorij", 0, 0, null);
        Direktorij direktorijMale = new Direktorij("Male datoteke", "Direktorij", 0, 0, null);
        Direktorij direktorijSrednje = new Direktorij("Srednje datoteke", "Direktorij", 0, 0, null);
        Direktorij direktorijVelike = new Direktorij("Velike datoteke", "Direktorij", 0, 0, null);
        direktorij.add(direktorijMale);
        direktorij.add(direktorijSrednje);
        direktorij.add(direktorijVelike);
        Handler chain1 = new ConcreteHandlerMali(direktorijMale);
        Handler chain2 = new ConcreteHandlerSrednji(direktorijSrednje);
        Handler chain3 = new ConcreteHandlerVeliki(direktorijVelike);
        chain1.setSuccessor(chain2);
        chain2.setSuccessor(chain3);
        out = "\n===Klasifikacija datoteka strukture po velicini===\n";
        out += "\nVelicina datoteke\tNaziv datoteke\n";
        ispisKomponenteChain(rootDirektorij, chain1);
        out += "\nVelicina datoteke\tNaziv datoteke\n";
        ispisKomponenteChain(rootDirektorij, chain2);
        out += "\nVelicina datoteke\tNaziv datoteke\n";
        ispisKomponenteChain(rootDirektorij, chain3);
        return out;
    }
    
    public void ispisKomponenteChain(Direktorij d, Handler h) {
        for (Component component : d.getListaDjece()) {
            if (component.getVrsta().equals("Direktorij")) {
                ispisKomponenteChain((Direktorij) component, h);
            } else {
                out += h.handleRequest(new Request(component.getVelicina(), component.getNaziv())) + "\n";
            }
        }
    }
    
}
