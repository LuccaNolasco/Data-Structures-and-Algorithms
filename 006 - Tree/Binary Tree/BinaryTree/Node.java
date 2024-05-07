package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Node<T extends Comparable>{ 
    private T valor;   /* Valor armazenado na raiz. */
    private Node<T> filho_esq, filho_dir; /* Referências para sub-árvores. */
    Queue <Node<T>> fila = new LinkedList<Node<T>>();
    //Stack <Node<T>> s = new Stack();

   
    //construtor da arvore sem subarvore
    public Node(T v){
        valor = v;
        filho_esq = null;
        filho_dir = null;
        fila.add(this);
    }
    
    //fornecendo as subarvores no construtor
    public Node(T v, Node<T> NoEsq, Node<T> NoDir){
        valor = v;
        filho_esq = NoEsq;
        filho_dir = NoDir;
    }
    
    //retorna o conteudo ou valor do no da arvore
    public T getValor(){
        return valor;
    }
   
    //Retorna a sub-árvore esquerda
    public Node<T> getFilho_esq() {
     return filho_esq;
    }

    //Retorna a sub-árvore direita
    public Node<T> getFilho_dir() {
       return filho_dir;
    }
 
    // seta o valor do no raiz da arvore
    public void setValor(T v){
     valor = v;
    }

    //seta o no da subarvore esquerda
    public void setEsq(Node<T> f_esq){
     filho_esq = f_esq;
    }

    //seta o no da subarvore direita
    public void setDir(Node<T> f_dir){

     filho_dir = f_dir;
    }
   
    public boolean inserirOrdenado(T v) {      
       if (this.compareTo(v)>0) { //v.toString().compareTo(this.getValor().toString())<0
            //o valor deve ser inserido a esquerda do no atual
            if (this.getFilho_esq()!=null)
              return this.getFilho_esq().inserirOrdenado(v);//senao for nulo continua navegando na arvore ate encontrar uma folha
            else {
              Node<T> n = new Node<T>(v);//se for nulo, cria o no e adiciona na folha
              this.setEsq(n);
              return true;            
            }                
       }
       else{  
            //o valor deve ser inserido a direita atual
            if (this.getFilho_dir()!=null)
                  return this.getFilho_dir().inserirOrdenado(v);
             else {
                  Node<T> n = new Node<T>(v);
                  this.setDir(n);
                  return true;            
                }                    
       }
       
    }

    public void imprimeInOrdem() {      
      if (this.getFilho_esq()!=null) {
        this.getFilho_esq().imprimeInOrdem();
      }             
      System.out.print(this.valor + " "); //visitando o no raiz      
      if (this.getFilho_dir()!=null) {
        this.getFilho_dir().imprimeInOrdem();
      }        
   }

   public void imprimeEmPreordem(){
      System.out.print(this.valor + " "); //visitando o no raiz      
      if (this.getFilho_esq()!=null) {
          this.getFilho_esq().imprimeEmPreordem();
      }   
                
      if (this.getFilho_dir()!=null) {
        this.getFilho_dir().imprimeEmPreordem();
      } 

   }

   public void imprimeEmPosordem(){
      if (this.getFilho_esq()!=null) {
        this.getFilho_esq().imprimeEmPosordem();
      }             
      if (this.getFilho_dir()!=null) {
        this.getFilho_dir().imprimeEmPosordem();
      } 
      System.out.print(this.valor + " "); //visitando o no raiz      

   }

   public void imprimeEmLargura(){
      if(fila.peek().getFilho_esq()!=null){
        fila.add(fila.peek().getFilho_esq());
      }
      if(fila.peek().getFilho_dir()!=null){
        fila.add(fila.peek().getFilho_dir());
      }
      System.out.print(fila.remove().getValor()+ " ");

      if(fila.peek()!= null){
        imprimeEmLargura();
      }
   }


   public int calculaAltura() {
    //comprimento do caminho mais longo do nó a uma folha.      
       int alturaesquerda=0;
       int alturadireita=0;
               
       if (this.getFilho_esq()!=null)
           alturaesquerda = this.getFilho_esq().calculaAltura()+1;

       //aqui, como vou saber a altura do filho da direita pra eu poder calcular a altura do node
       
       if (this.getFilho_dir()!=null)
           alturadireita = this.getFilho_dir().calculaAltura()+1;
         
       
       if (alturaesquerda>alturadireita)
           return alturaesquerda;
       
       else
           return alturadireita;
    }//ate aqui
    
    public int calculaAlturaEmLargura() {
       
      Queue<Node<T>> f = new LinkedList<Node<T>>();
      Queue<Integer> dist = new LinkedList<Integer>();
      //FilaEncadeada f = new FilaEncadeada();
      //FilaEncadeada dist = new FilaEncadeada();

      f.add(this);
      dist.add(0);

      int altura_maxima = 0;

      while( !f.isEmpty()) {
        Node<T>  no = (Node<T>)f.remove();
        int dist_pai = (int) dist.remove();
             
          if (no.getFilho_esq()!=null) {
            f.add(no.getFilho_esq());
            dist.add(dist_pai + 1);
          }
                     
          if (no.getFilho_dir()!=null) {
            f.add(no.getFilho_dir());
            dist.add(dist_pai + 1);
          }
       
          // eh folha
          if (dist_pai > altura_maxima) altura_maxima = dist_pai;
         }//while

      return altura_maxima;
    }//imprimelargura

    
    public int calculaTotalNodes() {
      int totalesq=0;
      int totaldir=0;  
         
      if (this.getFilho_esq()!=null) {
        totalesq = this.getFilho_esq().calculaTotalNodes();
      }
      if (this.getFilho_dir()!=null) {
        totaldir = this.getFilho_dir().calculaTotalNodes();
      }
       
      return totalesq+totaldir + 1; // o mais 1 é da raiz
    }

    public int calculaTotalNodesFolhas() {
      int totalesq=0;
      int totaldir=0;
      boolean ehfolha=true;
                     
      if (this.getFilho_esq()!=null) {
        totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
        ehfolha = false;
      }
      if (this.getFilho_dir()!=null) {
        totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
        ehfolha = false;
      }
      if (ehfolha) { 
        return 1;
      }
      else 
        return (totaldir + totalesq);
    }


    public Node<T> pesquisarValor(T v) {
       
       int comparacao = this.compareTo(v);
      //int comparacao = v.toString().compareTo(this.getValor().toString());
       
      if (comparacao>0) {//o valor a ser pesquisado estah do lado esquerdo do node?
        if (this.getFilho_esq()!=null)
          return this.getFilho_esq().pesquisarValor(v); // o valor pode estah na arvore esquerda
        else return null;//valor nao foi encontrado
      }
      else if (comparacao<0) {
        if (this.getFilho_dir()!=null)
          return this.getFilho_dir().pesquisarValor(v); // o valor pode estah na arvore direita
          else 
            return null;//valor nao foi encontrado
       }
       else 
        return this;// o valor encontra-se nesse noh atual   
    }

  public boolean removerNode(T v, Node<T> nodepai){
      int comparacao = v.compareTo(this.getValor());
      boolean resultado=false;
       
       if (comparacao<0){
          if (this.getFilho_esq()!=null)
          return this.getFilho_esq().removerNode(v,this); // o nó a ser removido ta na subarvore esquerda
            else resultado=false;//o valor nao ta na subarvoreesquerda  
       }
       else if (comparacao>0) {
         if (this.getFilho_dir()!=null)
            return this.getFilho_dir().removerNode(v,this); // o valor pode estah na subarvore direita
          else resultado=false;//valor nao foi encontrado               }
        }
        else //o no a ser removido é o atual.
        {
            if ((this.getFilho_esq()==null)&&(this.getFilho_dir()==null)){
                 //este node é folha, pois os dois filhos sao nulos
                 this.setFilhoNode(nodepai,null);//setar o filho de pai como nulo
                 resultado = true;
               }
               else if ((this.getFilho_esq()!=null)&&(this.getFilho_dir()==null)){
                 //o node tem o filho da esquerda diferente de nulo e o da direita eh nulo
                 this.setFilhoNode(nodepai,this.getFilho_esq()); //seta o pai o node atual com o filho da esquerda do nodeatual  
                 resultado = true;
               }
               else if ((this.getFilho_esq()==null)&&(this.getFilho_dir()!=null)){
                 //o node tem o filho da direita diferente de nulo e o da esquerda eh nulo
                 this.setFilhoNode(nodepai,this.getFilho_dir()); //seta o pai do node atual com o filho da direita do nodeatual
                 resultado = true;  
               }
               else if ((this.getFilho_esq()!=null)&&(this.getFilho_dir()!=null)){
              //podemos pegar um dos dois nodes a seguir, tanto faz.
                 //Node<String> nEsq = NodeComMaiorValor(nodeatual.getFilho_esq()); //pega o node com maior valor da subarvore esquerda
                 
                   Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor(); //pega o node com menor valor da subarvore da direita
                   Node<T> paiMenorNodeDir;
                   if (menorNodeDir !=this.getFilho_dir()) { //verifica se o proprio node raiz da subarvore direita eh ou nao o menor valor
                       paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
                   }
                   else paiMenorNodeDir=this;
                   
                   this.setValor(menorNodeDir.getValor());//coloca o novo valor no nodeatual.
                   /*
                    * Se menorNodeDir eh o menor valor da subarvore direita, entao menorNodeDir nao tem filhos a esquerda porque
                    * o menor valor de uma arvore eh o node mais a esquerda dessa arvore
                    * sendo assim, eu já sei que o menorNodeDir tem no maximo um filho a direita
                    * ou ele eh um node folha.
                    * Sendo assim posso setar diretamente o filho (direita) do paiMenorNoDir com o filho da direita do menorNodeDir
                    */
                   menorNodeDir.setFilhoNode(paiMenorNodeDir,menorNodeDir.getFilho_dir()); //seta o pai do menorNode com o filho da direita                    
                   resultado = true;
                   }
                 
               }
   
    return resultado;
  } 

  

  //seta o filho de um node pai como sendo o novo node.
    private void setFilhoNode(Node<T> nodePai, Node<T> novoNode) {
      if (nodePai.getFilho_esq()==this) {
        nodePai.setEsq(novoNode);}
      else
        if (nodePai.getFilho_dir()==this) {    
          nodePai.setDir(novoNode);}
    }

    private Node<T> NodeComMaiorValor() {
      if (this.getFilho_dir()!= null) {
        return this.getFilho_dir().NodeComMaiorValor();          
      }
      else return this;
    }//fim algotimo

    private Node<T> NodeComMenorValor() {
       if (this.getFilho_esq()!= null) {
            return this.getFilho_esq().NodeComMenorValor();
      } else return this;
    }//fim algotimo
 
    private Node<T> acharPai(Node<T> nofilho) {
      /*
      Esse algoritmo retorna o pai do Node noFilho
      O algoritmo verifica se o node do contexto de execução do metodo
      node This eh pai (pela esquerda ou pela direita) do nofilho.  
      */  
      if (this.getFilho_esq() == nofilho || this.getFilho_esq() == nofilho) {
        return this;
      } else{
          if (nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0) { //o valor do no do atual contexto é maior que o nofilho, entao o pai estah do lado esquerdo
            if (this.getFilho_esq() != null) {
              return this.getFilho_esq().acharPai(nofilho);
            } else {
              return null;//pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
            }
          } else {// subarvore direita
              if (this.getFilho_dir() != null) {
                return this.getFilho_dir().acharPai(nofilho);
              } else {
                return null; //pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
              }
            }
        }
    }





   public int compareTo(T newData){
    if(newData instanceof Integer){
      if((Integer)this.getValor()< (Integer)newData){
        return -1;
      } else if((Integer)this.getValor()==(Integer)newData){
        return 0;
      }else{
        return 1;
      }  
    }

    if(newData instanceof Float){
      if((Float)this.getValor()< (Float)newData){
        return -1;
      } else if((Float)this.getValor()==(Float)newData){
        return 0;
      }else{
        return 1;
      }  
    }

    if(newData instanceof Double){
      if((Double)this.getValor()< (Double)newData){
        return -1;
      } else if((Double)this.getValor()==(Double)newData){
        return 0;
      }else{
        return 1;
      }  
    }
    return this.getValor().toString().compareTo(newData.toString());
   }
}   
