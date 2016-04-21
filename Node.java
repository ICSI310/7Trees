 
public class Node 
{  
  // Properties
  public float data;
  public Node root;
  public Node left;
  public Node right;
    
  // Constructors
  public Node() {
    //System.out.println("Node: Default Constructor");
    this.data = 0;
    this.root = null;
    this.left = null;
    this.right = null;
  }
  
  public Node(float newData) {
    this.data = newData;
    this.root = null;
    this.left = null;
    this.right = null;
  }
  
  // Getters/Setters
  public Node getNext() {
    //System.out.println("Node: getNext");
    return this.next;
  }
  
  public Node getPrev() {
    //System.out.println("Node: getNext");
    return this.prev;
  }
  
  public void setNext(Node newNext) {
    //System.out.println("Node setNext");
    this.next = newNext;
  }
  
  public void setPrev(Node newPrev) {
    //System.out.println("Node setNext");
    this.prev = newPrev;
  }
  
  /*public String getData() {
    //System.out.println("Node: getData");
    return this.data;
  }*/
  
  /*public void setData(String newData) {
    //System.out.println("Node: setData");
    this.data = newData;
  }*/
  
  // Methods
  public void debug() {
    System.out.println( "Node " + this + " Data " + this.heroName + " " + this.nemesis + " " + this.time + " Next " + this.next + " Prev " + this.prev);
  }
  
  public void print() {
    System.out.println(this.heroName + " " + this.nemesis + " " + this.time);
  }
  
  
} // class Node
