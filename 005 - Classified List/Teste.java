import Excecoes.ListaVaziaException;
import Lista.ListaClassificada;

public class Teste {
  public static void main(String[] args) throws IndexOutOfBoundsException, ListaVaziaException {
    ListaClassificada<Integer> listaIn = new ListaClassificada<>();
    ListaClassificada<Double> listaDo = new ListaClassificada<>();
    ListaClassificada<Float> listaFl = new ListaClassificada<>();
    ListaClassificada<String> listaStr = new ListaClassificada<>();

    listaIn.inserir(1);
    listaIn.inserir(3);
    listaIn.inserir(2);
    listaIn.inserir(5);

    listaFl.inserir(3.5f);
    listaFl.inserir(3.5552f);
    listaFl.inserir(3.55521f);
    listaFl.inserir(3.5551f);

    

    listaDo.inserir(5.2);
    listaDo.inserir(3.222);
    listaDo.inserir(3.2);

    listaStr.inserir("oi");
    listaStr.inserir("aba");
    listaStr.inserir("");
    listaStr.inserir(" ");


    for(int i =0; i<listaIn.getCount();i++){
      System.out.println("Elemento da posicao "+ i +" : "+ listaIn.getLista().getElementByIndex(i));
    }
    for(int i =0; i<listaDo.getCount();i++){
      System.out.println("Elemento da posicao "+ i +" : "+ listaDo.getLista().getElementByIndex(i));
    }
    for(int i =0; i<listaFl.getCount();i++){
      System.out.println("Elemento da posicao "+ i +" : "+ listaFl.getLista().getElementByIndex(i));
    }
    for(int i =0; i<listaStr.getCount();i++){
      System.out.println("Elemento da posicao "+ i +" : "+ listaStr.getLista().getElementByIndex(i));
    }

  }
}
