import assets.ListaEncadeada;
import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;
import interfaces.IDequeue;

public class Dequeue<T> implements IDequeue<T> {
  private ListaEncadeada<T> lista;
  private int count;

  public Dequeue(){
    lista = new ListaEncadeada<>();
    count = 0;
  }

  public ListaEncadeada getLista(){return lista;}

  @Override
  public void fazVazia() {
    lista.fazVazia();
    count=0;
  }

  @Override
  public boolean estaVazia() {
    return count ==0;
  }

  @Override
  public T getPrimeiro() throws ListaVaziaException {
    if(count == 0){
      throw new ListaVaziaException();
    }
    return lista.getPrimeiro();
  }

  @Override
  public T getUltimo() throws ListaVaziaException {
    if(count ==0){
      throw new ListaVaziaException();
    }
    return lista.getElementByIndex(lista.size()).getData();
  }

  @Override
  public void enfileirarInicio(T objeto) {
    lista.inserirInicio(objeto);
    count++;
  }

  @Override
  public void enfileirarFim(T objeto) {
    lista.inserirFinal(objeto);
    count++;
  }

  @Override
  public T desenfileirarInicio() throws ContainerVazioException, ListaVaziaException {
    if(count==0){
      throw new ContainerVazioException();
    }
    T result =   lista.getPrimeiro();
    lista.extrair(result);
    --count;
    return result;
  }
  

  @Override
  public T desenfileirarFim() throws ContainerVazioException, IndexOutOfBoundsException, ListaVaziaException {
    if(count==0){
      throw new ContainerVazioException();
    }
    T result =   lista.getElementByIndex(lista.size()-1).getData();
    lista.extrair(result);
    --count;
    return result;
  }
  
}
