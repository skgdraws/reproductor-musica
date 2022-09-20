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
     * @param data Value which you want to change in the current node
     *
     * @author Franco Sagot
     */
    public void setData(data){

        this.value = data;
    }

    /**
     * Returns the next node using the pointer
     * @return Next Node
     *
     * @author Franco Sagot
     */
    public Node getNext() {

        return this.next;
    }

    /**
     * Returns the previous node using the pointer
     * @return Previous Node
     *
     * @author Franco Sagot
     */
    public Node getPrev() {

        return this.prev;
    }

    /**
     * The function sets the node that follows
     * @param node Next Node
     *
     * @author Franco Sagot
     */
    public void setNext(Node node) {

        this.next = node;
    }

    /**
     * The function sets the node that preceeds it
     * @param node Previews Node
     *
     * @author Franco Sagot
     */
    public void setPrev(Node node) {

        this.prev = node;
    }
}
