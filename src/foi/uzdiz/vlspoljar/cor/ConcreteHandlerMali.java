package foi.uzdiz.vlspoljar.cor;

import foi.uzdiz.vlspoljar.composite.Direktorij;

public class ConcreteHandlerMali extends Handler {
    
    Direktorij d;
    
    public ConcreteHandlerMali(Direktorij direktorij) {
        this.d = direktorij;
    }
    
    @Override
    public String handleRequest(Request request) {
        if ((request.getVelicina() / 1024) < 5) {
            return request.getVelicina()/1024 + "KB\t" + request.getNaziv();
        } else {
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
        return "";
    }

}
