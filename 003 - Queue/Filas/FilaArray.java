package Filas;

import exceptions.ContainerCheioException;
import exceptions.ContainerVazioException;
import inter.IFila;

public class FilaArray<T> implements IFila <T>{
  private T[] array;
  private int head, tail, count;

  public T[] getArray(){
    return array;
  }

  @SuppressWarnings("unchecked")
  public FilaArray(int tam){
    array = (T[]) new Object[tam];
    head = 0;
    tail = tam-1;
    count = 0;
  }
  @Override
  public void fazVazia() {
    while(count>0){
      array[head] = null;
      ++ head;

      if (head == array.length)
        head= 0;
      --count;
    }
  }

  @Override
  public boolean estaVazia() {
    return count == 0;
  }

  @Override
  public T getPrimeiro() throws ContainerVazioException {
    if(count==0){
      throw new ContainerVazioException();
    }
    return array[head];
  }

  @Override
  public void enfileirar(T objeto) throws ContainerCheioException {
    if (count == array.length )
      throw new ContainerCheioException();
    ++tail;
    if (tail == array.length )
      tail = 0;
    array [tail] = objeto;
    ++count;
  }

  @Override
  public T desenfileirar() throws ContainerVazioException {
    if (count == 0 )
      throw new ContainerVazioException();
    T result = array [head];
    array[head] = null;
    ++head;
    if (head == array.length)
      head = 0;
    --count;
    return result;
  }
  
}
