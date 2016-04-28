 public class Tree 
{  
  // Properties
  public Node root;
  
  // Constructors
  public Tree() {
    this.root = null;
  }
  // Methods
  public boolean isEmpty() {
    return (this.root == null);
  }

  public void insert(float newFloat){
    insert(new Node(newFloat), this.root);
  }

  public void insert(Node newNode, Node current) {
    if (current == null) // for empty tree
      this.root = newNode;
    else{
      if (newNode.data < current.data) {// left
        if (current.left == null) {
        // add node base case
          current.left = newNode;
          newNode.parent = current;
        }// recursive call to left subtree
        else insert(newNode, current.left);
      }
      else if (newNode.data > current.data){// right
        if (current.right == null) {
        // add node base case
        current.right = newNode;
        newNode.parent = current;
        }// recursive call to left subtree
        else insert(newNode, current.right);
      }
    else 
      // increment base case
      current.counter++;
    }
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
  /*public void print() {
    System.out.print("printTree: " + this.root);
  }*/
  public void print() {
    this.print(this.root);
  }
  
  public void print(Node current) {
    // recursively print
    //print left subtree
    if (current.left != null) {
      this.print(current.left);
    }
    // print current node
    current.print();
    // print right subtree
    if (current.right != null){
      this.print(current.right);
    } 
    
  }
  
} // class myList
