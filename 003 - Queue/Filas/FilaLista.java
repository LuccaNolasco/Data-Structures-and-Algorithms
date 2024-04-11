package Filas;

import exceptions.ContainerCheioException;
import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;
import inter.IFila;
import linkedLists.ListaEncadeada;

public class FilaLista <T> implements IFila<T>{
  private ListaEncadeada<T> lista;
  private int count;

  public ListaEncadeada getLista(){
    return lista;
  }

  public FilaLista(){
    lista = new ListaEncadeada();
    count = 0;
  }

  @Override
  public void fazVazia() {
    lista.fazVazia();
    count = 0;
  }

  @Override
  public boolean estaVazia() {
    return count == 0;
  }

  @Override
  public T getPrimeiro() throws ListaVaziaException {
    if(count==0){
      throw new ListaVaziaException();
    }
    return   lista.getPrimeiro();
    
  }

  @Override
  public void enfileirar(T objeto) throws ContainerCheioException {
    lista.inserirFinal(objeto);
    count++;
  }

  @Override
  public T desenfileirar() throws ContainerVazioException, ListaVaziaException {
    if(count==0){
      throw new ContainerVazioException();
    }
    T result =   lista.getPrimeiro();
    lista.extrair(result);
    --count;
    return result;
  }
  
}
