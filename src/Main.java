import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**This is the main method of the priority queue. This is mostly used to just test out the queue and house method*/
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //creates the que and goes to the file.
        PriorityQueueListClass que = new PriorityQueueListClass();
        String filepath = "houses.txt";
        File file = new File("houses.txt");
        Scanner scnr = new Scanner(file);
    //checks the txt file and adds every house and value to the list
    while(scnr.hasNext()){
        String Name = scnr.nextLine();
        String value = scnr.nextLine();
        int val = Integer.parseInt(value);
        que.add(new House(Name, val));
    }
    //copy que constructor
    PriorityQueueListClass queCopy = new PriorityQueueListClass(que);
    //prints out each element in the order of most expensive to least expensive. Also test the get length method
    while(!que.isEmpty()){
        House a = que.getMostExpensive();
        System.out.println(a.getOwner() +": "+ a.getValue());
        System.out.println("Length: " + que.getLength());
    }
    //testing the deep copy constructor and set and get methods. Also check the .equals method
    House testHouse = new House("Matthew", 150);
    House deepcopy = new House(testHouse);
    System.out.println("The .equals method: " + testHouse.equals(deepcopy));
    deepcopy.setValue(149);
    deepcopy.setOwner("josh");
    System.out.println("Testing the deepcopy: " + testHouse+ " " + deepcopy + testHouse.getValue() + "--" + testHouse.getOwner()+testHouse.getValue()+ " - "+deepcopy.getOwner()+deepcopy.getValue());
    System.out.println("The .equals method after a change has been made to a house : " + testHouse.equals(deepcopy));
    //Testing to see if the ques are copied correctly. And checking the clear method.
    System.out.println("Testing the Deepcopy of the que: "+ que + " " + queCopy + ": They both have different addresses. And here are their different lengths: " + que.getLength() + " " + queCopy.getLength());
    System.out.print("Testing the Clear Command: " + queCopy.getLength()+ " Now we clear it ");
    queCopy.clear();
    System.out.print(queCopy.getLength());
    }

}