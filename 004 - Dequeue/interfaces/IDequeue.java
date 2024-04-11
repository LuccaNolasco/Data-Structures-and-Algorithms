package interfaces;

import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;

public interface IDequeue <T>{
  void fazVazia();
  boolean estaVazia();
  T getPrimeiro() throws ListaVaziaException;
  T getUltimo() throws ListaVaziaException;
  void enfileirarInicio(T objeto);
  void enfileirarFim(T objeto);
  T desenfileirarInicio() throws ContainerVazioException, ListaVaziaException;
  T desenfileirarFim() throws ContainerVazioException, IndexOutOfBoundsException, ListaVaziaException;
  
} 
