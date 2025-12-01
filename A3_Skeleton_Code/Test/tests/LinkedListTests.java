package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;


class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	/**
	 * Creates a new SLL instance for each test.
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Initialize your concrete SLL implementation here
		this.linkedList = new SLL(); 
	}

	/**
	 * Clears the list after each test.
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}
	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test retrieval
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("c", this.linkedList.retrieve(2));
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test retrieval (d -> c -> b -> a)
		assertEquals("d", this.linkedList.retrieve(0));
		assertEquals("c", this.linkedList.retrieve(1));
		assertEquals("b", this.linkedList.retrieve(2));
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid middle index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2); // a -> b -> [e] -> c -> d
		
		// Test the size is 5
		assertEquals(5, this.linkedList.size());

		// Test retrieval
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("e", this.linkedList.retrieve(2)); // New node at index 2
		assertEquals("c", this.linkedList.retrieve(3)); 
		assertEquals("d", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2); // a -> b -> [e] -> d
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test retrieval
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("e", this.linkedList.retrieve(2)); // Replaced node
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests deleting node from linked list (middle).
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2); // a -> b -> d
		
		// Test the size is 3
		assertEquals(3, this.linkedList.size());

		// Test retrieval
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		assertEquals("d", this.linkedList.retrieve(2)); // Node at new index 2
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}

	// ------------------------------------------------------------------
	// MEMBER 3: 5 ADDITIONAL UNIT TESTS
	// ------------------------------------------------------------------

	/**
	 * 1. Tests deleting the Head node (index 0).
	 */
	@Test
	void testDeleteHead() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		
		this.linkedList.delete(0); // b
		
		assertEquals(1, this.linkedList.size());
		assertEquals("b", this.linkedList.retrieve(0));
	}
	
	/**
	 * 2. Tests deleting the Tail node (index size - 1).
	 */
	@Test
	void testDeleteTail() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		
		this.linkedList.delete(2); // a -> b
		
		assertEquals(2, this.linkedList.size());
		assertEquals("a", this.linkedList.retrieve(0));
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Asserting that retrieving index 2 throws an exception
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.retrieve(2);
		});
	}

	/**
	 * 3. Tests inserting at the boundary (index == size).
	 */
	@Test
	void testInsertAtTailBoundary() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		
		this.linkedList.insert("Z", this.linkedList.size()); // a -> b -> Z
		
		assertEquals(3, this.linkedList.size());
		assertEquals("Z", this.linkedList.retrieve(2));
	}
	
	/**
	 * 4. Tests indexOf() and contains() for an element not found.
	 */
	@Test
	void testIndexOfNotFound() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		
		// Test containment
		assertFalse(this.linkedList.contains("z"));
		
		// Test index returns -1
		assertEquals(-1, this.linkedList.indexOf("z"));
	}
	
	/**
	 * 5. Tests that delete throws IndexOutOfBoundsException for invalid index.
	 */
	@Test
	void testDeleteInvalidIndex() {
		this.linkedList.append("a");
		
		// Test deleting a negative index
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.delete(-1);
		});
		
		// Test deleting an index equal to size (invalid)
		assertThrows(IndexOutOfBoundsException.class, () -> {
			this.linkedList.delete(this.linkedList.size());
		});
	}
}
