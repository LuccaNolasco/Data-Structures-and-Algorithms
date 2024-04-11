import java.util.Scanner;

import exceptions.ContainerVazioException;
import exceptions.ListaVaziaException;

public class TesteLista {
  public static void main(String[] args) throws ContainerVazioException, ListaVaziaException {
    Dequeue fila = new Dequeue<Integer>();
    Scanner scan = new Scanner(System.in);

    fila.enfileirarInicio(3);
    System.out.println("A lista ja possui o elemento '3'.");
    System.out.print("Insira um elemento no inicio:");
    fila.enfileirarInicio(scan.nextInt());
    System.out.print("Agora ao fim: ");
    fila.enfileirarFim(scan.nextInt());

    System.out.print("Sua lista desinfileirada pelo inicio\n[");
    for(int i =0; i<fila.getLista().size()+i;i++){
      System.out.print(" "+fila.desenfileirarInicio()+" ");
    }
    System.out.println("]\n");

    System.out.println("Insira mais até estar satisfeito");

    char opt;
    do{
      int escolha;
      System.out.println("Deseja inserir no inicio ou no fim? 1 / 2");
      escolha= scan.nextInt();
      System.out.print("Insira o valor: ");
      if(escolha==1){
        fila.enfileirarInicio(scan.nextInt());
      } else{
        fila.enfileirarFim(scan.nextInt());
      }
      System.out.print("Continuar? y/n ");
      scan.nextLine();
      opt=scan.nextLine().charAt(0);
    }while(opt!='n');

    System.out.print("Desinfileirando do fim");
    for(int i =0; i<fila.getLista().size()+i;i++){
      System.out.println("Retirando elemento da posicao " + fila.getLista().size()+ ": "+fila.desenfileirarFim());
    }
    if(fila.estaVazia()){
      System.out.println("Sua fila esta vazia");
    }
  }
}
