package intefaces;

public interface IPilha <T>{
    void fazVazia();
    boolean estaVazia();
    T getTop();
    void push(T o);
    T pop();
    }