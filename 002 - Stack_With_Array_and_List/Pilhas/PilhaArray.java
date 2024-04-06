package Pilhas;

import intefaces.IPilha;

public class PilhaArray <T> implements IPilha <T> {

    private T array[];
    private int count;
    
    @SuppressWarnings("unchecked")
    public PilhaArray  (int tam) {
        count = 0;
        array = (T[]) new Object [tam];
    }

    @Override
    public void fazVazia() {
        while(count>0){
            array[--count]=null;
        }    
    }

    @Override
    public boolean estaVazia() {
        return count == 0;
    }

    @Override
    public T getTop() {
        if (count == 0)
            System.out.println("A lista esta vazia");
        return array [count -1];
    }

    @Override
    public void push(T o) {
        if (count == array.length)
            System.out.println("O array esta cheio");
        array[count] = o;
        count ++;
    }

    @Override
    public T pop() {
        if (count == 0)
            System.out.println("O container esta vazio");
        count --;
        T result = array[count];
        array[count] = null;
        return result;
    }
    
}
