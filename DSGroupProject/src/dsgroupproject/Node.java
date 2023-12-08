
package dsgroupproject;

public class Node {
    
    private Customer info;
    private Node link;

    public Node() {
	this.info = null;
	this.link = null;
    }

    public Node(Customer newInfo) {
        this.info = newInfo;
        this.link = null;
    }

    public void setInfo(Customer a) {
        this.info = a;
    }

    public void setLink(Node b) {
        this.link = b;
    }

    public Customer getInfo() {
        return this.info;
    }

    public Node getLink() {
        return this.link;
    }

}
