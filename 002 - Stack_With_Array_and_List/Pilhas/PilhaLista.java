package Pilhas;

import intefaces.IPilha;
import linkedLists.ListaDuplamenteEncadeada;

public class PilhaLista<T> implements IPilha<T> {
    private  ListaDuplamenteEncadeada<T> lista;
    private int count;
    
    public PilhaLista(){
        lista = new ListaDuplamenteEncadeada<T>();
        count = 0;
    }

    public ListaDuplamenteEncadeada<T> getLista(){
        return this.lista;
    }

    @Override
    public void fazVazia() {
        lista.fazVazia();
        count=0;
    }

    @Override
    public boolean estaVazia() {
        return count==0;
    }

    @Override
    public T getTop() {
        if(count==0){
          System.out.println("O container esta vazio!");
        }
        return lista.buscarPorIndex(0).getData();
    }

    @Override
    public void push(T o) {
        lista.inserirInicio(o);
        count ++;
    }

    @Override
    public T pop() {
        if(count==0){
            System.out.println("Container esta vazio");
        }
        T result =  lista.buscarPorIndex(0).getData();
        lista.extrair(result);
        count --;
        return result;
    }
    
}
