package foi.uzdiz.vlspoljar.cor;

import foi.uzdiz.vlspoljar.composite.Direktorij;

public class ConcreteHandlerSrednji extends Handler {

    Direktorij d;
    
    public ConcreteHandlerSrednji(Direktorij direktorij) {
        this.d = direktorij;
    }

    @Override
    public String handleRequest(Request request) {
        if ((request.getVelicina() / 1024) > 5 && (request.getVelicina() / 1024) < 10) {
            return request.getVelicina()/1024 + "KB\t" + request.getNaziv();
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
        return "";
    }

}
