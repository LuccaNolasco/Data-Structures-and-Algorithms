package Interfaces;

public interface ICursor<T> {
  T getDado();
  void inserirDepois (T o);
  void inserirAntes (T o);
  void remover();
}
