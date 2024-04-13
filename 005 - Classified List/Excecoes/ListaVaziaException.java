package Excecoes;

public class ListaVaziaException extends Exception {
    public ListaVaziaException(){
        super("A lista esta vazia");
    }
}
