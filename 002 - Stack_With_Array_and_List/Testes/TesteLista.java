package Testes;

import java.util.Scanner;

import Pilhas.PilhaLista;

public class TesteLista {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PilhaLista pilha = new PilhaLista<Integer>();
        char opt;

        System.out.println("Insira elementos ate estar satisfeito:");
        do{
            System.out.print("Insira o valor: ");
            pilha.push(scan.nextInt());
            scan.nextLine();
            System.out.print("Continuar? y/n: ");
            opt = scan.nextLine().charAt(0);
        }while(opt!='n');

        
        for(int i=0;i<pilha.getLista().size()+i;i++){
           //System.out.println("Tamanho da lista " + pilha.getLista().size());
            System.out.println("Elemento no topo que esta sendo removido "+ pilha.pop());
        }
        System.out.println("--------------\nEncha a pilha novamente:");
        System.out.println("Insira elementos ate estar satisfeito:");
        do{
            System.out.print("Insira o valor: ");
            pilha.push(scan.nextInt());
            scan.nextLine();
            System.out.print("Continuar? y/n: ");
            opt = scan.nextLine().charAt(0);
        }while(opt!='n');

        System.out.println("Elemento no topo: "+pilha.getTop());
        pilha.fazVazia();
        if(pilha.estaVazia()){
          System.out.println("Pilha esvaziada pelo metodo 'fazVazia( )'");
        }
    }
}
