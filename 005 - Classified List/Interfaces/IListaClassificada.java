package Interfaces;

import Excecoes.ListaVaziaException;
import Lista.ListaClassificada.Cursor;

public interface IListaClassificada <T> {
  T get (int i);
  //Cursor procurarPosicao (T o);
  boolean eMembro(T o);
  void inserir (T o);
  void remover (T o) throws ListaVaziaException;
  T procurar (T o);
  
}