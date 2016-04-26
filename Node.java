 
public class Node 
{  
  // Properties
  public int counter;
  public float data;
  public Node parent;
  public Node left;
  public Node right;
    
  // Constructors
  public Node() {
    //System.out.println("Node: Default Constructor");
    this.data = 0;
    this.counter = 0;
    this.parent = null;
    this.left = null;
    this.right = null;
  }
  
  public Node(float newData) {
    this.data = newData;
    this.counter = 0;
    this.parent = null;
    this.left = null;
    this.right = null;
  }
  
  // Getters/Setters
  public Node getRight() {
    return this.right;
  }
  
  public Node getLeft() {
    return this.left;
  }
  
  public void setLeft(Node newLeft) {
    //System.out.println("Node setNext");
    this.left = newLeft;
  }
  
  public void setRight(Node newRight) {
    //System.out.println("Node setNext");
    this.right = newRight;
  }

  public void debug() {
    System.out.println( "Node " + this + " " + this.left + " " + this.right);
  }
  
  public void print() {
    System.out.println("Data: " + this.data);
  }
  
  
} // class Node
