public class ListaEncadeada {
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

  public void inserirInicio(Object item) {
    Element temp = new Element(item, head);
    if (head == null) {
      tail = temp;
    }
    head = temp;
  }

  public void inserirFinal(Object item) {
    Element temp = new Element(item, null);
    if (head == null) {
      head = temp;
    } else {
      tail.next = temp;
    }
    tail = temp;
  }

  public Element getElementByIndex(int cont) throws ListaVaziaException, IndexNotFound {
    Element element = head;
    if (cont > this.size()) { // caso esteja vazia
      throw new ListaVaziaException();
    }
    for (int i = 0; i < cont; i++) {
      element = element.getNext();
    }
    return element;
  }

  public int size() throws IndexNotFound {
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

  public Object getPrimeiro() throws ListaVaziaException {
    if (head == null)
      throw new ListaVaziaException();
    return head.data;
  }

  public Object getUltimo() throws ListaVaziaException {
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

  public void extrair(Object item) throws IndexNotFound {
    Element ptr = head;
    Element prevPtr = null;
    while (ptr != null && !ptr.data.equals(item)) {
      prevPtr = ptr;
      ptr = ptr.next;
    }
    if (ptr == null) {
      throw new IndexNotFound();
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
    private Object data;
    private Element next;

    public Element(Object data, Element next) {
      this.data = data;
      this.next = next;
    }

    public Object getData() {
      return data;
    }

    public void setData(Object data) {
      this.data = data;
    }

    public Element getNext() {
      return next;
    }

    public void setNext(Element next) {
      this.next = next;
    }

    public void inserirDepois(Object item) {
      next = new Element(item, next);
      if (tail == this) {
        tail = next;
      }
    }

    public void inserirAntes(Object item) {
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