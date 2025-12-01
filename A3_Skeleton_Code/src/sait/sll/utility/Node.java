package sait.sll.utility;

import java.io.Serializable;

// Node must be Serializable to allow the list to be serialized
public class Node implements Serializable {
    // CRITICAL: Required for serialization
    private static final long serialVersionUID = 1L; 
    
    // Attributes
    private Object data; 
    private Node next;   

    /**
     * Initializes a Node object.
     * This is the constructor: Node(Object)
     */
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    // Getters and Setters: Fixing the "method is undefined" errors
    
    public Object getData() {
        return this.data;
    }
    
    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return this.next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
}
    
    