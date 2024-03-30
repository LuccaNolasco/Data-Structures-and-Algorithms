public class Teste {
    public static void main(String[] args) {
        ListaEncadeada listaEncadeada = new ListaEncadeada();
        double n1 =5.6, n2=12.4, n3=14;

        // Insercao no Inicio
        listaEncadeada.inserirInicio(n1);
        listaEncadeada.inserirInicio(n2);
        listaEncadeada.inserirInicio(n3);

        //Impressao
        for (int i=0; i<3;i++){
            try {
              System.out.println(listaEncadeada.getElementByIndex(i));
            } catch (ListaVaziaException e) {
              System.out.println(e.getMessage());
            } catch (IndexNotFound e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
        }
        System.out.println("------------------------");
        
        int n4 =20;

        //Inserindo apos um especifico
        try {
          listaEncadeada.getElementByIndex(1).inserirDepois(n4);
        } catch (ListaVaziaException e) {
          System.out.println(e.getMessage());
        } catch (IndexNotFound e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        for (int i=0; i<4;i++){
            try {
              System.out.println(listaEncadeada.getElementByIndex(i));
            } catch (ListaVaziaException e) {
              System.out.println(e.getMessage());
            } catch (IndexNotFound e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
        }

        System.out.println("---------------");
        //O tamanho
        try {
          System.out.println("O tamanho eh:" + listaEncadeada.size() );
        } catch (IndexNotFound e) {
          System.out.println(e.getMessage());
        }
        System.out.println("-----------------");

        //Nova Lista instanciada
        ListaEncadeada listaVazia = new ListaEncadeada();

        
        try {
          System.out.println("Elemento em posicao alem "+listaEncadeada.getElementByIndex(4));
        } catch (ListaVaziaException e) {
          System.out.println(e.getMessage());
        } catch (IndexNotFound e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        try {
          System.out.println("Size vazia: "+ listaVazia.size());
        } catch (IndexNotFound e) {
          System.out.println(e.getMessage());
        }
        try {
          System.out.println("Elemento numa vazia: "+listaVazia.getElementByIndex(2));
        } catch (ListaVaziaException e) {
          System.out.println(e.getMessage());
        } catch (IndexNotFound e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        listaVazia.atribuir(listaEncadeada);
        System.out.println("Agora 'listaVazia' nao eh mais vazia. Seus elementos:");
        try {
          for(int i=0; i<listaVazia.size();i++){
            System.out.println(listaVazia.getElementByIndex(i));
          }
        } catch (IndexNotFound | ListaVaziaException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        System.out.println("Agora, quero extrair o elemento 12.4 : ");
        try {
          listaVazia.extrair(12.4);
        } catch (IndexNotFound e) {
          e.printStackTrace();
        }
         try {
          for(int i=0; i<listaVazia.size();i++){
            System.out.println(listaVazia.getElementByIndex(i));
          }
        } catch (IndexNotFound | ListaVaziaException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
    }
}
