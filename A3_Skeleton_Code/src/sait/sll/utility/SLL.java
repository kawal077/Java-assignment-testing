// sait.sll.utility.SLL.java
package sait.sll.utility;

import java.io.Serializable;

// Must implement the ADT and Serializable
public class SLL implements LinkedListADT, Serializable { 
    private static final long serialVersionUID = 1L;

    // ATTRIBUTES
    private Node head;
    private int size;
        
    // CONSTRUCTOR
    public SLL() {
        this.head = null;
        this.size = 0;
    }
    
    // MEMBER 1's IMPLEMENTATION: BASIC ADT METHODS
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }
        
    /**
     * Helper method to find the Node at a specific index.
     * @exception IndexOutOfBoundsException if index is invalid.
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("Index out of bounds: " + index);
       }    
       Node current = head;    
       for (int i = 0; i < index; i++) {
           current = current.getNext();
       }
       return current;
    }
    
    // -------------------------------------------------------------------
    // MEMBER 2 START IMPLEMENTING THE REMAINDER OF THE LINKEDLISTADT HERE
    // -------------------------------------------------------------------

    // MEMBER 2: Task A Methods go in this exact spot (prepend, append, insert)
    
    @Override
    public void prepend(Object data) {
        // Your code for Task A, part 1 goes here
    	Node newNode = new Node(data);
        
        // 1. New node points to the current head
        newNode.setNext(this.head);
        
        // 2. Head becomes the new node
        this.head = newNode;
        
        this.size++;
    }

    @Override
    public void append(Object data) {
        // Your code for Task A, part 2 goes here
    	Node newNode = new Node(data);
        
        if (this.head == null) {
            // Handle empty list
            this.head = newNode;
        } else {
            // Find the last node (size - 1) using Member 1's helper
            Node lastNode = getNode(this.size - 1);
            
            // Last node points to the new node
            lastNode.setNext(newNode);
        }
        
        this.size++;
    }

    @Override
    public void insert(Object data, int index) throws IndexOutOfBoundsException {
        // Your code for Task A, part 3 goes here
    	if (index < 0 || index > size) { 
            throw new IndexOutOfBoundsException("Invalid index for insertion: " + index);
        }
        
        if (index == 0) {
            // Use the existing prepend method
            prepend(data);
        } else if (index == size) {
            // Use the existing append method
            append(data);
        } else {
            // 2. Insert in the middle
            Node newNode = new Node(data);
            
            // Find the node BEFORE the insertion point (index - 1)
            Node previous = getNode(index - 1); 
            
            // New node points to the node AFTER the insertion point
            newNode.setNext(previous.getNext());
            
            // Previous node points to the new node
            previous.setNext(newNode);
            
            this.size++;
        }
    }

    // MEMBER 2: Task B (delete, replace) and Task C (retrieve, indexOf, contains) follow below...

    @Override
    public void delete(int index) throws IndexOutOfBoundsException {
    	// 1. Check for Index Out of Bounds (Deletion must be 0 to size-1)
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index for deletion: " + index);
        }

        if (index == 0) {
            // 2. Handle Deleting the Head
            // Simply move the head pointer to the next node.
            this.head = this.head.getNext();
        } else {
            // 3. Handle Deleting a Middle or End Node
            // Find the node *before* the one to be deleted (index - 1)
            Node previous = getNode(index - 1);
            
            // Skip the target node: previous.next now points to the target's next node
            previous.setNext(previous.getNext().getNext());
        }
        
        // Decrement the size regardless of which node was deleted
        this.size--;
    }
    
    @Override
    public void replace(Object data, int index) throws IndexOutOfBoundsException {
    	// 1. getNode() handles the boundary check (0 to size-1)
        // If the index is valid, the helper method returns the node.
        Node targetNode = getNode(index);
        
        // 2. Simply update the data in the existing node
        targetNode.setData(data);
    }
    
    @Override
    public Object retrieve(int index) throws IndexOutOfBoundsException {
    	// getNode() handles the boundary check (0 to size-1)
        // If index is valid, it returns the Node at that position.
        Node targetNode = getNode(index);
        
        // Return the data object held by that node.
        return targetNode.getData();
    }
    
    @Override
    public int indexOf(Object data) {
        // ...
    	Node current = this.head;
        
        // Iterate through all nodes in the list
        for (int i = 0; i < this.size; i++) {
            // CRITICAL: Use .equals() for object comparison, not ==
            if (current.getData().equals(data)) {
                return i; // Found it! Return the current index.
            }
            current = current.getNext(); // Move to the next node
        }
        
        // Item not found after checking all nodes
        return -1; // Placeholder
    }
    
    @Override
    public boolean contains(Object data) {
    	// The most efficient way is to reuse the indexOf method.
        // If indexOf returns any index (i.e., not -1), the list contains the data.
        return indexOf(data) != -1;
    }

}