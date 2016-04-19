 public class MyList 
{  
  // Properties
  boolean nemesisCaptured;
  double timeSinceFed;
  double timeBetweenFeedings;
  private int sharks;
  public Node head;
  public Node tail;
  public Node current;
  
  // Constructors
  public MyList() {
    //System.out.println("MyList: Default constructor");
    this.nemesisCaptured = false;
    this.timeSinceFed = 0;
    this.timeBetweenFeedings = 8;
    this.sharks = 0;
    this.head = new Node();
    this.tail = head;
    this.current = head;
  }
  
  public void setSharks(int newSharks) {
    this.sharks = newSharks;
    this.timeBetweenFeedings = 8/this.sharks;
    System.out.println("sharks = " + sharks);
  }
  
  public boolean isEmpty() {
    return (this.head == null);
  }
  
  // Methods
  public void addToFront(Node newNode) {
    //System.out.println("MyList: addToFront");
    //this.head.debug();
    //newNode.debug();
     // just add to head of list for now
    newNode.setNext(this.head);
    this.head.setPrev(newNode);
    //newNode.debug();
    this.head = newNode; 
    //this.head.debug();
  }
  
  public void insert(int index, Node newNode) {
    System.out.println("insert: " + index);
    if (index == 0) {
      System.out.println("if index == 0");
      this.addToFront(newNode);
    }
    else{
      System.out.println("else");
      // traverse to new node
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
      /*System.out.println("got index: " + this.current);
      // set newnode's next
      newNode.setNext(current.getNext()); // shouldn't be self
      this.current.setNext(newNode);
      System.out.println("set newNode");*/
      // set node before newnode's next to newnode
    } 
  }
  
  public Node remove(int index){
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
  }
  
  public Node get(int index) {
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
  }
  
  // traverses and prints
  public void print() {
    //System.out.println("MyList: print");
    System.out.print("forwards: ");
    this.current = this.head;
    //this.current.debug();
    while(null != this.current){
      //this.current.debug();
      //this.current.print();
      System.out.print(this.current.heroName + " ");
      this.current = this.current.getNext();
    }
    System.out.print("\n");
    System.out.print("backwards: ");
    this.current = this.tail;
    //this.current.debug();
    while(null != this.current){
      //this.current.debug();
      //this.current.print();
      System.out.print(this.current.heroName + " ");
      this.current = this.current.getPrev();
    }
  }
  
  // stack methods
  
  public void push(Node newNode) {
    System.out.println("push");
    this.addToFront(newNode);
  }
  
  public Node pop(){
    return remove(0);
  }
  
  public void popAll() {
    while (!isEmpty()) {
      this.pop().print();
    }
  }
  
  // queue methods
  
  public void enqueue(Node newNode){
    newNode.setPrev(this.tail);
    this.tail.setNext(newNode);
    //newNode.debug();
    this.tail = newNode; 
    //this.head.debug();
  }
  
  public Node dequeue(){
    return remove(0);
  }
  
  public void dequeueAll() {
    //System.out.println("dequeueAll");
    while (!isEmpty()) {
      //System.out.println("isn't empty");
      this.dequeue().print();
    }
  }
  
  public void capture(Node capturedHero, double elapsedTime) {
    if (capturedHero.nemesis == 1) {
      this.nemesisCaptured = true;
      this.enqueue(capturedHero);
    }
    else
    {
      if (this.nemesisCaptured)
        this.push(capturedHero);
      else
        this.enqueue(capturedHero);
    }
    System.out.println(elapsedTime + ": " +
                                   capturedHero.heroName + 
                                   " has been captured.");
  }
  
  public void feedSharks(double elapsedTime) {
    System.out.println("feedSharks");
    Node fedHero;
// feeds next hero to sharks
    if (this.nemesisCaptured)
      fedHero = this.pop();
    else
      fedHero = this.dequeue();
    if (fedHero.nemesis == 1) {
      this.nemesisCaptured = false;
    }
    System.out.println(elapsedTime + ": " +
                                   fedHero.heroName + 
                                   " has been fed to the sharks.");
  }
  
  public void trackFeedingTime(double elapsedTime){
    System.out.println("trackFeedingTime: timeSinceFed " + this.timeSinceFed + " timeBetweenFeedings " + this.timeBetweenFeedings);
    if (this.timeSinceFed > this.timeBetweenFeedings) {
      feedSharks(elapsedTime);
      this.timeSinceFed = this.timeSinceFed - this.timeBetweenFeedings;
    }
    this.timeSinceFed += elapsedTime - lastfeedingtime
  }
} // class myList
