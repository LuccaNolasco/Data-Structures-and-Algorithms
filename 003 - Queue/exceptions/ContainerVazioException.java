package exceptions;

public class ContainerVazioException extends Exception{
  public ContainerVazioException(){
    super("Container cheio!");
  }
}
