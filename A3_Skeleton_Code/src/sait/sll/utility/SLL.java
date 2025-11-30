// sait.sll.utility.SLL.javapackage sait.sll.utility;
import java.io.Serializable;
// Must implement the ADT and Serializablepublic class SLL implements LinkedListADT, Serializable { 
    private static final long serialVersionUID = 1L;

    // Attributes for the list structureprivate Node head;
    private int size;
        // Constructorpublic SLL() {
        this.head = null;
        this.size = 0;
        
        
     // Continued in SLL.java/**
        * Helper method to find the Node at a specific index.
        * @exception IndexOutOfBoundsException if index is invalid.
        */private Node getNode(int index) throws IndexOutOfBoundsException {
           if (index < 0 || index >= size) {
               throw new IndexOutOfBoundsException("Index out of bounds: " + index);
           }    Node current = head;    for (int i = 0; i < index; i++) {
               current = current.getNext();
           }
           return current;
       }
    }
    // ... Implement the required methods below ...
}