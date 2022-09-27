package sample.newreproductormusica;

/**
 * List made out of nodes using pointers to find the data
 * 
 * @author Franco Sagot
 */
public class LinkedList{

    int size;
    ListNode head;

    /**
     * This creates an instance of a double linked list
     * @author Franco Sagot
     */
    public LinkedList(){

        this.head = null;
        this.size = 0;
    }

    /**
     * Checks if the list is empty
     * @return True if the list is Empty
     *
     * @author Franco Sagot
     */
    public boolean isEmpty() {

        return this.head == null;
    }

    /**
     * Returns the amount of elements inside the list
     * @return size
     *
     * @author Franco Sagot
     */
    public int size() {

        return this.size;
    }

    /**
     * Inserts one an Item on
     * @param data Data to be inserted in list
     *
     * @author Franco Sagot
     */
    public void insertFirst(Object data) {
        ListNode newNode = new ListNode(data);

        newNode.next = this.head;
        this.head.prev = newNode;

        this.head = newNode;
        this.size++;
    }

    /**
     * This deletes the first item in the list
     * @return The deleted node
     *
     * @author Franco Sagot
     */
    public ListNode deleteFirst() {
        if (this.head != null) {

            ListNode temp = this.head;
            this.head = this.head.next;

            this.size--;
            return temp;
        } else {

            return null;
        }
    }

    /**
     * Deletes the node with the item that you're looking for
     * @param searchValue Value to be deleted
     * @return The deleted node
     *
     * @author Franco Sagot
     */
    public ListNode delete(Object searchValue) {
        ListNode current = this.head;
        ListNode previous = this.head;

        while (current != null) {

            if (current.getData().equals(searchValue)) {
                if (current == this.head) {
                    this.head = this.head.getNext();

                } else {
                    previous.setNext(current.getNext());
                }
                return current;

            } else {
                previous = current;
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Finds a specific value inside of the list
     * @param searchValue the value to look for
     * @return node with the value that was found
     *
     * @author Franco Sagot
     */
    public ListNode find(Object searchValue) {
        ListNode current = this.head;
        while (current != null) {
            if (current.getData().equals(searchValue)) {
                return current;
            } else {
                current = current.getNext();
            }
        }
        return null;
    }

    /**
     * Displays all of the current values of the list
     *
     * @author Franco Sagot
     */
    public void displayList() {
        ListNode current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
