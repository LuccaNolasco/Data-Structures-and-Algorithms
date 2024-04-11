package testes;

import java.util.Scanner;

import Filas.FilaArray;
import exceptions.ContainerCheioException;
import exceptions.ContainerVazioException;

public class TesteArray {
  public static void main(String[] args) throws ContainerCheioException, ContainerVazioException {
    FilaArray fila = new FilaArray<Integer>(5);
    Scanner scan = new Scanner(System.in);


    System.out.println("Insira 5 valores no seu array");
    for(int i =0; i<fila.getArray().length;i++){
      System.out.print("Valor na posicao " + i+" :");
      fila.enfileirar(scan.nextInt());
    }
      
   

    for(int i = 0;i<fila.getArray().length;i++){
      System.out.println("Desenfileirando valor na posicao "+i+" : "+ fila.desenfileirar());
    }

    System.out.println("Enfilere novamente:");
    System.out.println("Insira 5 valores no seu array");
    for(int i =0; i<fila.getArray().length;i++){
      System.out.print("Valor na posicao " + i+" :");
      fila.enfileirar(scan.nextInt());
    }

    System.out.println("O valor na frente da fila eh: "+fila.getPrimeiro());

    fila.fazVazia();

    if(fila.estaVazia()){
      System.out.println("Sua fila foi sucedidamente esvaziada pelo metodo 'fazVazia'");
    }

  }
}
