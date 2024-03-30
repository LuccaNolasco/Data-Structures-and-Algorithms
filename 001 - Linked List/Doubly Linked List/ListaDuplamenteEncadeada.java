public class ListaDuplamenteEncadeada {
  Element head;
  Element tail;

  public Element getHead() {
    return head;
  }

  public void setHead(Element head) {
    this.head = head;
  }

  public Element getTail() {
    return tail;
  }

  public void setTail(Element tail) {
    this.tail = tail;
  }

  public void inserirInicio(Object item) {
    Element temp = new Element(item, null, head);
    if (head == null) {
      tail = temp;
    } else {
      head.prev = temp;
    }
    head = temp;
  }

  public void inserirFim(Object item) {
    Element temp = new Element(item, tail, null);
    if (head == null) {
      head = temp;
    } else {
      tail.next = temp;
    }
    tail = temp;

  }

  public void remover(Element item) {
    Element ptr = head;
    while (ptr != null &&  !ptr.equals(item)) {
      ptr = ptr.next;
    }
    if (ptr == null) {
      try {
        throw new ObjetoNaoEncontradoException();
      } catch (ObjetoNaoEncontradoException e) {
        System.out.println(e.getMessage());
      }
    }
    if (ptr == head) {
      head = ptr.next;
      if (!head.equals(null)) {
        head.prev = null;
      }
    } else {
      if (ptr == tail) {
        tail = ptr.prev;
        if (!tail.equals(null)) {
          tail.next = null;
        }
      } else {
        System.out.println(ptr.prev);
        (ptr.prev).next = ptr.next;
        (ptr.next).prev = ptr.prev;
      }
    }
  }

  public int size() {
    int cont = 1;
    Element element = this.head;
    if (element==null) {
      System.out.println("Lista Vazia");
      return 0;
    }
    while (element!=tail) {
      element = element.next;
      cont++;
    }

    return cont;
  }

  public Element buscarPorIndex(int cont) {
    Element element = head;

    if(cont>= this.size()){
      System.out.println("Indice nao existe");
      return null;
    }

    if (element.equals(null)) {
      System.out.println("Lista Vazia");
      return element;
    } else {
      for (int i = 0; i < cont; i++) {
        element = element.next;
      }
    }
    return element;
  }

  public Element buscarPorDado(Object dado) throws ObjetoNaoEncontradoException{
    Element temp = head;
    while(temp!=null && temp.data!=dado){
      temp=temp.next;
    }
    if(temp==null){
      throw new ObjetoNaoEncontradoException();
    }

    return temp;
  }

  public final class Element {
    Object data;
    Element next, prev;

    public Element(Object data, Element prev, Element next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    public void inserirAntes(Object item) {
      Element temp = new Element(item, this.prev, this);
      this.prev = temp;
      if (this == head) {
        head = this.prev;
      } else {
        (temp.prev).next = temp;
      }
    }

    public void inserirDepois(Object item) {
      Element temp = new Element(item, this, this.next);
      this.next = temp;
      if (tail == this) {
        tail = this.next;
      } else {
        (temp.next).prev = temp;
      }
    }

    @Override
    public String toString() {
      return "[ " + this.data + " ]";
    }
    // Fim Element
  }
}