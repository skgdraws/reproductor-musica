public class Node {
    
    Node next;
    Node prev;
    Object value;

    /**
     * Defines the instance of the Node Class
     * @author Franco Sagot
     * @param getValue
     */
    public Node(Object getValue){

        this.next = null;
        this.prev = null;
        this.value = getValue;
    }

    /**
     * Returns the value that the current node has
     * @author Franco Sagot
     * @return value from node
     */
    public Object getData(){

        return this.value
    }

    /**
     * Changes the value of the current node
     * @author Franco Sagot
     */
    public void setData(data){

        this.value = data;
    }

    /**
     * Returns the next node using the pointer
     * @author Franco Sagot
     * @return Next Node
     */
    public Node getNext() {

        return this.next;
    }

    /**
     * Returns the previous node using the pointer
     * @author Franco Sagot
     * @return Previous Node
     */
    public Node getPrev() {

        return this.prev;
    }

    /**
     * The function sets the node that follows
     * @author Franco Sagot
     * @param Next Node
     */
    public void setNext(Node node) {

        this.next = node;
    }

    /**
     * The function sets the node that preceeds it
     * @author Franco Sagot
     * @param Previews Node
     */
    public void setPrev(Node node) {

        this.prev = node;
    }
}
