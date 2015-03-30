package foi.uzdiz.vlspoljar.mvc;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void odabir() {
        String izbor = "";
        do {
            view.izbornik();
            Scanner scan = new Scanner(System.in);
            izbor = scan.nextLine();
            switch (izbor) {
                case "1":
                    view.ispis("Ukupan broj direktorija: " + model.getBrojDirektorija());
                    view.ispis("Ukupan broj datoteka: " + model.getBrojDatoteka());
                    break;
                case "2":
                    view.ispis(model.ispisiStrukturu());
                    break;
                case "3":
                    view.ispis(model.startDretva());
                    break;
                case "4":
                    view.ispis(model.stopDretva());
                    break;
                case "5":
                    view.ispis(model.ispisiSpremljenihStanja());

                    break;
                case "6":
                    view.ispis("Unesite broj n: ");
                    try {
                        int n = scan.nextInt();
                        view.ispis(model.postavljanjeStanjaStruktureNaN(n));
                    } catch (InputMismatchException ex) {
                        view.ispis("n mora biti broj!");
                    }
                    break;
                case "7":
                    view.ispis("Unesite broj n i m (odvojeno razmakom): ");
                    String nm = scan.nextLine();
                    String[] NM = nm.split("\\s+");
                    try {
                        int N = Integer.parseInt(NM[0]);
                        int M = Integer.parseInt(NM[1]);
                        view.ispis(model.odaberiStanja(N, M));
                    } catch (NumberFormatException ex) {
                        view.ispis("I n i m moraju biti brojevi!");
                    }
                    break;
                case "8":
                    view.ispis(model.postavljanjeTrenutnogStanja());

                    break;
                case "9":
                    view.ispis(model.setUpChain());
                    break;
                case "Q":

                    break;
                default:

            }
        } while (!izbor.equals("Q"));

    }
}
