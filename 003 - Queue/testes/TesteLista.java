package testes;

import java.util.Scanner;

import Filas.FilaLista;
import exceptions.ContainerCheioException;
import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;

public class TesteLista {
  public static void main(String[] args) throws ContainerCheioException, ContainerVazioException, ListaVaziaException {
    Scanner scan = new Scanner (System.in);
    FilaLista fila = new FilaLista<>();
    char opt;
    int position=0;
    
    do{
      System.out.print("Elemento de posicao "+position+" :");
      fila.enfileirar(scan.nextInt());
      scan.nextLine();
      position++;
      System.out.print("Continuar? y/n ");
      opt=scan.nextLine().charAt(0);
    }while(opt!='n');
    position = 0;

    for(int i =0; i<fila.getLista().size()+i;i++){
      System.out.println("Desinfileirando elemento de indice "+i+" : "+fila.desenfileirar());
    }

    System.out.println("Insira novamente");
    do{
      System.out.print("Elemento de posicao "+position+" :");
      fila.enfileirar(scan.nextInt());
      scan.nextLine();
      position++;
      System.out.print("Continuar? y/n ");
      opt=scan.nextLine().charAt(0);
    }while(opt!='n');

    fila.fazVazia();

    if(fila.estaVazia()){
      System.out.println("Sua fila foi esvaziada pelo metodo 'fazVazia'");
    }

  }
}
