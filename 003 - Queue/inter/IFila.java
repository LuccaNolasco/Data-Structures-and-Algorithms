package inter;

import exceptions.ContainerCheioException;
import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;

public interface IFila <T> {
  void fazVazia();
  boolean estaVazia();
  T getPrimeiro() throws ContainerVazioException, ListaVaziaException;
  void enfileirar(T objeto) throws ContainerCheioException;
  T desenfileirar() throws ContainerVazioException, ListaVaziaException;
  
} 
