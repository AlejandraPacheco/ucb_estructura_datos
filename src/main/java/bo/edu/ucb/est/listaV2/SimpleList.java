package bo.edu.ucb.est.listaV2;

public class SimpleList <T> {
    private Node first;
    private int size;

    public SimpleList() {
        first = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        Node node = new Node(data, null);
        size++;
        if (first == null) {
            first = node;
        } else {
            for (Node current = first ; current != null; current = current.getNext() ) {
                if (current.getNext() == null ) { // es el ultimo nodo
                    current.setNext(node); // Enlazo el ultimo nodo.
                    break;
                }
            }
        }
    }

    public void print() {
       for (Node current = first; current != null ; current = current.getNext()) {
           System.out.print( current.getData() + " -> ");
       } 
       System.out.println(" |. ");
    }
    
// Ejercicios
    public Object getData(int elemento){//obtener un elemento
        Object resultado=null;
        if (size!=0) {
            int i=0;
            for (Node current=first; current!=null; current=current.getNext()) {
                if (elemento==i) {
                    resultado=current.getData();
                    break;
                }
                i++;
            }
        }
        return resultado;
    }
    
    public boolean contains(T data){ // Retorna true si la lista contiene el elemento.
        boolean resultado=false;
        for (Node current=first; current!=null; current=current.getNext()){
            if (current.getData().equals(data)){
                resultado=true;
            break;
            }
        }
        return resultado;
    }
    
    public void remove(T data){ // Remueve el elemento
        if (size!=0) {
            Node previous=null;
            for (Node current=first; current!=null; current=current.getNext()) {
                if (current.getData().equals(data)) {
                    // Eliminar el nodo actual
                    if (previous==null) { // Significa que estoy eliminando el primer elemento
                        first=current.getNext();
                    } else { // Si tenemos nodoAnterior es un elemento de en medio o el utlimo.
                        previous.setNext(current.getNext()); 
                    }
                    break;
                }
                previous=current;
            }
        }
    }
    
    public void remove(int elemento){ // Remueve el elemento de la posicion i especifgicada.
        if (size!=0) {
            int i=0;
            Node previous=null;
            for (Node current=first; current!=null; current=current.getNext()) {
                if (elemento==i) {
                    // Eliminar el nodo actual
                    if (previous==null) { // Significa que estoy eliminando el primer elemento
                        first=current.getNext();
                    } else { // Si tenemos nodoAnterior es un elemento de en medio o el utlimo.
                        previous.setNext(current.getNext()); 
                    }
                    break;
                }
                i++;
                previous=current;
            }
        }
    }

    
}
