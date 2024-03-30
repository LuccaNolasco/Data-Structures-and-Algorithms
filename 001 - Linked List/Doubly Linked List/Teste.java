import java.util.Scanner;

public class Teste {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ListaDuplamenteEncadeada lista1 = new ListaDuplamenteEncadeada();
    ListaDuplamenteEncadeada lista2 = new ListaDuplamenteEncadeada();

    System.out.println("Insira items ateh estar satisfeito: ");
    char opt;

    //Popular a lista um
    do{
      System.out.print("Insira um valor: ");
      int d = scan.nextInt();
      lista1.inserirFim(d);
      System.out.println("-----------\nContinuar? y/n");
      opt= scan.next().charAt(0);
    }while(opt =='y');

    System.out.println("---------\n Tamanho de Sua lista: "+lista1.size()+"\n---------");
    
    //Imprimir a Lista Um
    System.out.println("--------------\n Eis a lista um:");
    for(int i=0;i<lista1.size();i++){
      System.out.println(lista1.buscarPorIndex(i));
    }
    
    System.out.println("---------\n Quer um elemento em específico por indice?");
    System.out.println(lista1.buscarPorIndex(scan.nextInt()));

    System.out.println("---------\n Quer um elemento  por dados?");
    int d1 = scan.nextInt(); 
    try {
      System.out.println(lista1.buscarPorDado(d1));
    } catch (ObjetoNaoEncontradoException e) {
      System.out.println(e.getMessage());
    }


    System.out.println("--------------\nInserir antes de um indice especifico?");
    lista1.buscarPorIndex(scan.nextInt()).inserirAntes(scan.nextInt());
    //Imprimir a Lista Um Novamente
    System.out.println("Eis a nova lista um:");
    for(int i=0;i<lista1.size();i++){
      System.out.println(lista1.buscarPorIndex(i));
    }

    //Remover elemento
    System.out.println("----------------\nRemovendo no inicio");
    lista1.remover(lista1.buscarPorIndex(0));
    System.out.println("Eis a nova lista um:");
    for(int i=0;i<lista1.size();i++){
      System.out.println(lista1.buscarPorIndex(i));
    }

    //Remover elemento
    System.out.println("-----------\nRemovendo no fim");
    lista1.remover(lista1.buscarPorIndex(lista1.size()-1));
    System.out.println("--------------\n Eis a nova lista um:");
    for(int i=0;i<lista1.size();i++){
      System.out.println(lista1.buscarPorIndex(i));
    }

    //Remover elemento especifco
    System.out.println("-------------\n Remover em posicao especifica por index");
    lista1.remover(lista1.buscarPorIndex(scan.nextInt()));
    System.out.println("--------------\n Eis a nova lista um:");
    for(int i=0;i<lista1.size();i++){
      System.out.println(lista1.buscarPorIndex(i));
    }
    scan.close();

  }

}
