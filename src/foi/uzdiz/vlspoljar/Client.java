package foi.uzdiz.vlspoljar;

import foi.uzdiz.vlspoljar.mvc.Controller;
import foi.uzdiz.vlspoljar.mvc.Model;
import foi.uzdiz.vlspoljar.mvc.View;
import foi.uzdiz.vlspoljar.postavke.PostavkePrograma;

public class Client {

    public static void main(String[] args) {
        if (args.length > 1) {
            PostavkePrograma postavkePrograma = new PostavkePrograma(args[0], Integer.valueOf(args[1]), args[2]);
            Model model = new Model();
            model.setPostavkePrograma(postavkePrograma);
            model.struktura();
            View view = new View(model);
            Controller controller = new Controller(model, view);
            controller.odabir();
        } else {
            System.out.println("Argumenti nisu definirani!");
        }
    }
}
