// sait.sll.utility.Node.javapackage sait.sll.utility;
import java.io.Serializable;
public class Node implements Serializable {
    // CRITICAL: Required for serializationprivate static final long serialVersionUID = 1L; 
        // Attributesprivate Object data; 
    private Node next;       // Constructorpublic Node(Object data) {
        this.data = data;
        this.next = null; // Default to null when created    }
    // Getters and Setters (Implement these)public Object getData() {
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
    }
    
    
    