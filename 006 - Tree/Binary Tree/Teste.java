import BinaryTree.Node;

public class Teste {
  public static void main(String[] args) {
    Node arvoreInt = new Node<Integer>(50);
    //Node arvoreStr = new Node<String>("Teste");

    arvoreInt.inserirOrdenado(1);
    arvoreInt.inserirOrdenado(9);
    arvoreInt.inserirOrdenado(51);
    arvoreInt.inserirOrdenado(-15);
    arvoreInt.inserirOrdenado(-14);
    arvoreInt.inserirOrdenado(8);


    
    System.out.print("Em ordem inteiros: ");
    arvoreInt.imprimeInOrdem();
    System.out.println(); // quebra de linha

    System.out.print("Em pre ordem inteiros: ");
    arvoreInt.imprimeEmPreordem();
    System.out.println();//quebra de linha

    System.out.print("Em pos ordem inteiros:  ");
    arvoreInt.imprimeEmPosordem();
    System.out.println();//quebra de linha

    System.out.print("Em largura inteiros: ");
    arvoreInt.imprimeEmLargura();
    System.out.println(); // Quebra de linha

    System.out.println("Altura: " + arvoreInt.calculaAltura());
    System.out.println("Buscando valor -15 -> "+ arvoreInt.pesquisarValor(-15).getValor());
    System.out.println("Buscando valor 99 -> " + arvoreInt.pesquisarValor(99));
    System.out.println("A quantidade de nos totais eh: "+ arvoreInt.calculaTotalNodes());
    arvoreInt.inserirOrdenado(-20);
    System.out.println("Inseri -20, agora o total eh: "+ arvoreInt.calculaTotalNodes());
    System.out.println("O total de folhas eh: "+arvoreInt.calculaTotalNodesFolhas());
    System.out.println("Removendo node -15: "+arvoreInt.removerNode(-15, null));
    System.out.println("Nova impressao em ordem: ");
    //arvoreInt.imprimeEmLargura();
    arvoreInt.imprimeEmPreordem();
  }
}
