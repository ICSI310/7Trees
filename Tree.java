 public class Tree 
{  
  // Properties
  public Node root;
  
  // Constructors
  
  // Methods
  public boolean isEmpty() {
    return (this.head == null);
  }
  
  
  
  public void insert(Node newNode) {
    Node current = null;
    if (this.root == null) {
      this.root = newNode;
    }
    else {
      // traverse to new node (binary search tree)
      current = this.root;
      // compare newNode to current and decide which branch to move to
      if(newNode.data < current.data) 
        // move left
      else if (newNode.data > current.data) 
      // move right
      else
        // increment counter
        
    /*
    else{
      System.out.println("else");
      
      this.current = this.get(index); 
      if (this.current == null) { // end of the list
        newNode.setPrev(this.tail);
        this.tail.setNext(newNode);
        this.tail = newNode;
         
      }
      else {
        // set newNode's previous to current's prev
        newNode.setPrev(this.current.getPrev());
        // set newNode's next to current
        newNode.setNext(this.current);
        // newNode's prevous's next to newNode
        newNode.getPrev().setNext(newNode);
        // newNode's next's previous to newNode
        newNode.getNext().setPrev(newNode);
      }
    } */
  }
  
  /*public Node remove(int index){
    // make sure index is legal
    if (index < 0) {
      System.out.println("Index is less than 0.");
      return null;
    }
    // store the removed node
    Node removedNode = this.get(index);
    // make sure removed node exists
    if (removedNode == null) {
      System.out.println("Index is out of bounds.");
      return null;
    }
    // set the next of the previous to removedNodes's next
    if (removedNode.getPrev() == null) { // beginning of list
      this.head = removedNode.getNext();
    }
    else
      removedNode.getPrev().setNext(removedNode.getNext());
    // set removedNode's next's prev to removedNode's previous
    if (removedNode.getNext() == null) { // end of list
      this.tail = removedNode.getPrev();
    }
    else
      removedNode.getNext().setPrev(removedNode.getPrev());
    // return removed node
    return removedNode;
  }*/
  
/*  public Node get(int index) {
    //System.out.println("get: " + index);
    this.current = this.head;
    //System.out.println("current: " + this.current);
    int counter = 0;
    while(null != this.current){
      //System.out.println("counter: " + counter);
      if (counter == index) break;
      this.current = this.current.getNext();
      counter++;
      //System.out.println("current: " + this.current);
    }
    //System.out.println("Traversal finished");
    return(this.current);
  }*/
  
  // traverses and prints
  public void print() {
    System.out.print("printTree: " + this.root);
  }
  

} // class myList
