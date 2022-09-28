package sample.newreproductormusica;

/**
 * Represents a List that loops around itself.
 * The class isn't used
 * @author Franco Sagot
 */
public class Playlist{

    // these pointers point at the next/first song
    ListNode head;
    ListNode tail;
    int size;

    /**
     * Creates an instance of a Circular List
     * @author Franco Sagot
     */
    public Playlist(){

        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Insterts Data in the first position of the list
     * @param Data data that will be inserted first in the list
     * 
     * @author Franco Sagot
     */
    public void insertFirst(Object Data){

        ListNode insertedNode = new ListNode(Data);

        insertedNode.next = this.head;
        this.head.prev = insertedNode;

        this.head = insertedNode;
       
        if (this.head == null) this.tail = insertedNode;
        
        this.size++;

    }

    /**
     * Deletes the first node of the list
     * @return Deleted node
     * 
     * @author Franco Sagot
     */
    public ListNode deleteFirst(){

        if(this.head != null){

            ListNode temp = this.head;
            this.head = this.head.next;
            this.tail = this.tail.next;

            this.size--;
            return temp; 
        }
        else{

            return null;
        }
    }
}