package foi.uzdiz.vlspoljar.cor;

import foi.uzdiz.vlspoljar.composite.Direktorij;

public class ConcreteHandlerVeliki extends Handler {

    Direktorij d;
    
    public ConcreteHandlerVeliki(Direktorij direktorij) {
        this.d = direktorij;
    }

    
    @Override
    public String handleRequest(Request request) {
        if ((request.getVelicina() / 1024) > 10) {
            return request.getVelicina()/1024 + "KB\t" + request.getNaziv();
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
        return "";
    }

}