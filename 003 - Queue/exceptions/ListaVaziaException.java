package exceptions;

public class ListaVaziaException extends Exception {
  public ListaVaziaException(){
    super("A lista está vazia!");
  }
}
