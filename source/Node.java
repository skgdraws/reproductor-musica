public class Node {
    
    Node next;
    Node prev;
    Object value;

    /**
     *
     * @param getValue
     */
    public void Node(Object getValue){

        this.next = null;
        this.prev = null;
        this.value = getValue;
    }

    /**
     * Returns the value that the current node has
     * @return value from node
     */
    public Object getData(){

        return this.value
    }

    /**
     * Changes the value of the current node
     */
    public void setData(data){

        this.value = data;
    }

    /**
     * Returns the next node using the pointer
     * @return Next Node
     */
    public Node getNext() {

        return this.next;
    }

    /**
     * Returns the previous node using the pointer
     * @return Previous Node
     */
    public Node getPrev() {

        return this.prev;
    }

    /**
     * The function sets the node that follows
     * @param Next Node
     */
    public void setNext(Node node) {

        this.next = node;
    }

    /**
     * The function sets the node that preceeds it
     * @param Previews Node
     */
    public void setPrev(Node node) {

        this.prev = node;
    }
}
