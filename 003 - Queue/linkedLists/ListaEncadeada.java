package linkedLists;

import exceptions.ListaVaziaException;

public class ListaEncadeada <T>{
  private Element head;
  private Element tail;

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

  public ListaEncadeada() {
    this.fazVazia();
  }

  public void fazVazia() {
    head = null;
    tail = null;
  }

  public boolean estaVazia() {
    return (head == null);
  }

  public void inserirInicio(T item) {
    Element temp = new Element(item, head);
    if (head == null) {
      tail = temp;
    }
    head = temp;
  }

  public void inserirFinal(T item) {
    Element temp = new Element(item, null);
    if (head == null) {
      head = temp;
    } else {
      tail.next = temp;
    }
    tail = temp;
  }

  public Element getElementByIndex(int cont) throws ListaVaziaException, IndexOutOfBoundsException {
    Element element = head;
    if (cont > this.size()) { // caso esteja vazia
      throw new ListaVaziaException();
    }
    for (int i = 0; i < cont; i++) {
      element = element.getNext();
    }
    return element;
  }

  public int size() throws IndexOutOfBoundsException {
    int size = 1;
    Element temp = this.head;
    if (temp == null) { // caso esteja vazia
      return 0;
    }

    while (temp != tail) {
      temp = temp.getNext();
      size++;
    }
    return size;
  }

  public T getPrimeiro() throws ListaVaziaException {
    if (head == null)
      throw new ListaVaziaException();
    return head.data;
  }

  public T getUltimo() throws ListaVaziaException {
    if (tail == null)
      throw new ListaVaziaException();
    return tail.data;
  }

  public void atribuir(ListaEncadeada l) {
    if (l != this) {
      this.fazVazia();
      for (Element ptr = l.head; ptr != null; ptr = ptr.next) {
        this.inserirFinal(ptr.data);
      }
    }
  }

  public void extrair(T item) throws IndexOutOfBoundsException {
    Element ptr = head;
    Element prevPtr = null;
    while (ptr != null && !ptr.data.equals(item)) {
      prevPtr = ptr;
      ptr = ptr.next;
    }
    if (ptr == null) {
      throw new IndexOutOfBoundsException();
    }
    if (ptr == head) {
      head = ptr.next;
    } else {
      prevPtr.next = ptr.next;
    }
    if (ptr == tail) {
      tail = prevPtr;
    }
  }

  public class Element {
    private T data;
    private Element next;

    public Element(T data, Element next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public Element getNext() {
      return next;
    }

    public void setNext(Element next) {
      this.next = next;
    }

    public void inserirDepois(T item) {
      next = new Element(item, next);
      if (tail == this) {
        tail = next;
      }
    }

    public void inserirAntes(T item) {
      Element temp = new Element(item, this);
      if (this == head) {
        head = temp;
      } else {
        Element prevPtr = head;
        while ((prevPtr != null && prevPtr != this)) {
          prevPtr = prevPtr.next;
        }
        prevPtr.next = temp;
      }
    }

    @Override
    public String toString() {
      return "[ " + this.data + " ]";
    }

  }
}