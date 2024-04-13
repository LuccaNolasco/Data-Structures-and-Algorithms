package Lista;

import Excecoes.ListaVaziaException;
import Interfaces.ICursor;
import Interfaces.IListaClassificada;

public class ListaClassificada<T> implements IListaClassificada<T> {
  private ListaEncadeada <T> lista;
  private int count;
  
  public ListaClassificada(){
    lista = new ListaEncadeada<T>();
    count=0;
  }

  public int getCount(){return this.count;}
  public ListaEncadeada<T> getLista(){return this.lista;}
  
  @Override
  public T get(int offset) {
    if (offset <0 || offset >=count){
      throw new IndexOutOfBoundsException();
    }
    ListaEncadeada<T>.Element ptr;
    ptr = lista.getHead();

    for(int i=0;i<offset && ptr!=null;i++)
      ptr = ptr.getNext();

    return ptr.getData();
  }

  /* 
  @Override
  public Cursor procurarPosicao(T o) {
    ListaEncadeada<T>.Element ptr = lista.getHead();
    while(ptr.getNext()!=null && ptr.ehMenor(o)){
      ptr= ptr.getNext();
    }
    if(ptr.getNext()==null && ptr.ehMenor(o)){
      ptr=lista.getTail();
    }
    return new Cursor(ptr);
  }

  */
  @Override
  public boolean eMembro(T o) {
    ListaEncadeada.Element ptr;
    for (ptr=lista.getHead();ptr!=null; ptr=ptr.getNext()){
      if (ptr.getData() == o)
        return true;
      }
    return false;
  }

  @Override

  public void inserir(T o){
    if(lista.estaVazia()){
      lista.inserirInicio(o);
      count++;
    } else{
        ListaEncadeada<T>.Element ptr = lista.getHead();
          while(ptr.getNext()!=null && ptr.ehMenor(o)){
           ptr= ptr.getNext();
          }   
        if(ptr.getNext()==null && ptr.ehMenor(o)){ //Caso ptr seja tail
          lista.inserirFinal(o);
          count++;
        } else{
          Cursor cursor = new Cursor(ptr);
          cursor.inserirAntes(o);
          count++;
        }
    }
  }

  /* 
  @Override
  public void inserir(T o) {
    if(lista.estaVazia()){
      lista.inserirInicio(o);
    } else{
      Cursor cursor = procurarPosicao(o);
      if(lista.getTail().equals(lista.getHead().getNext())){
        lista.inserirFinal(o);
      } else{
          cursor.inserirAntes(o);
          count ++;
        }  
    }    
  }
  */

  @Override
  public void remover(T o) throws ListaVaziaException {
    if (count == 0)
      throw new ListaVaziaException();
    lista.extrair(o);
    count--;
  }

  @Override
  public T procurar(T o) {
    ListaEncadeada<T>.Element ptr;
    for (ptr = lista.getHead(); ptr!=null; ptr = ptr.getNext()){
      T obj =  ptr.getData();
      if (obj.equals(o))
      return obj;
    }
  return null;
  }

  /*
  
    CLASSE CURSOR
   */
  public class Cursor implements ICursor<T>{
    ListaEncadeada<T>.Element elemento;
    
    public Cursor(ListaEncadeada<T>.Element elemento){
      this.elemento = elemento;
    }

    @Override
    public T getDado() {
      return elemento.getData();
    }

    @Override
    public void inserirDepois(T o) {
      elemento.inserirDepois(o);
      count++;
    }

    @Override
    public void inserirAntes(T o) {
      elemento.inserirAntes(o);
    }

    @Override
    public void remover() {
      lista.extrair(elemento.getData());
      count--;
    }

  }
  
}
