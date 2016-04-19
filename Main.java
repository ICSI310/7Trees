import java.io.*;
import java.util.Scanner;

// declare the class.
public class Main 
{
  // the main method
  public static void main(String[] args) throws IOException{
    MyList list = new MyList();
    //Double elapsedTime = new Double(0);// assume 0 = first hero captured
    double elapsedTime = 0;
    Scanner input = null;

        try {
            input = new Scanner(new BufferedReader(new FileReader("heroList.txt")));
            // assume first line is number of sharks (int)
            list.setSharks(input.nextInt());
            while (input.hasNext()) {// find out if there's another hero
              Node tmp = getHero(input, elapsedTime);
              elapsedTime += tmp.time;
              list.capture(tmp, elapsedTime);
              list.trackFeedingTime(elapsedTime);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
        // TODO: replace this with something that feeds the sharks every 4 hours until the list is empty
        list.dequeueAll();
    
    
    /*list.head.setData("0");
    list.enqueue(new Node("1"));
    list.enqueue(new Node("2"));
    list.enqueue(new Node("3"));*/
    //list.dequeue().print();
    //list.dequeue().print();
    //list.dequeueAll();
    //list.popAll();
    /*list.print();
    list.get(2).print(); //thing1
    list.insert(2, new Node("thing4", null));
    list.get(2).print(); // thing4
    System.out.println("printing entire list:");
    list.print();*/
    //list.print();
    //list.remove(2);
    //list.insert(4, new Node("4"));
    //System.out.println(list.remove(10));
    //System.out.println("list after remove");
    //list.print();
  }
  
  // parses input and returns next hero node
  public static Node getHero(Scanner input, double elapsedTime) {
    String heroName = input.next();
    int nemesis = input.nextInt();
    double timeToArrive = input.nextDouble();
    Node tmp = new Node(heroName, nemesis, timeToArrive);
    return tmp;
  }
  

    
} // class Main
