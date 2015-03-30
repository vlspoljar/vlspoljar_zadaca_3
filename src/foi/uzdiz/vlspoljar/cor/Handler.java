package foi.uzdiz.vlspoljar.cor;

public abstract class Handler {

    Handler successor;

    public void setSuccessor(Handler successor) {
        successor = successor;
    }

    public abstract String handleRequest(Request request);
}
