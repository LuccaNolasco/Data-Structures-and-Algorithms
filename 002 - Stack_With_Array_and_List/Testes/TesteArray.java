package Testes;

import java.util.Scanner;
import Pilhas.PilhaArray;

public class TesteArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Insira um tamanho para o array: ");
        int tam = scan.nextInt();
        PilhaArray pilha = new PilhaArray<Integer>(tam);

        System.out.println("Insira os valores:");
        for(int i = 0; i<tam;i++){
            System.out.print("Elemento da posicao "+i+" :");
            pilha.push(scan.nextInt());
        }

        System.out.println("------------\n Sua Pilha");
        for(int i =0;i<tam;i++){
            System.out.println("Retirando o valor: " + pilha.pop());
        }
        if(pilha.estaVazia()){
            System.out.println("Sua lista esta vazia");
        }

        System.out.println("Insira os valores:");
        for(int i = 0; i<tam;i++){
            System.out.print("Elemento da posicao "+i+" :");
            pilha.push(scan.nextInt());
        }
        
        System.out.println("O topo eh "+ pilha.getTop());




        
    }
}
