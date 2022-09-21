/**
 * Represents a List that loops around itself
 * @author Franco Sagot
 */
public class Playlist{

    // these pointers point at the next/first song
    Node head;
    Node tail;
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

    public void insertFirst(Object Data){

        Node insertedNode = new Node(Data);

        insertedNode.next = this.head;
        this.head.prev = insertedNode;

        this.head = insertedNode;
        this.tail = insertedNode;
        this.size++;

    }

    public Node deleteFirst(){

        if(this.head != null){

            Node temp = this.head;
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