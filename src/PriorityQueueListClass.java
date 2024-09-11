//This class is a priority queue using Nodes. The priority lies in the pricing of the house.
public class PriorityQueueListClass implements PriorityQueueInterface{

    //this int will be used to track the length.
    private int length;
    //these two nodes will be updated to tell where the front and the back of the line are.
    private Node front;
    private Node back;
    //First we add a class that has creates Nodes for the LinkedList. The data is the house. Next is null unless assigned.
    class Node{
       private House data;
       private Node next;
        Node(House data){
            this.data =data;
            this.next = null;

        }
    }
    //default constructor that assigns the class members
    PriorityQueueListClass(){
        this.front = null;
        this.back = null;
        this.length = 0;
    }
    //to make a deepcopy of a LinkedList we cant just copy the linked list. We need to copy all data of each node individually.
    PriorityQueueListClass(PriorityQueueListClass prique){
        if(prique.isEmpty()){
            this.front = null;
            this.back = null;
            this.length = 0;
        }
        else{
            Node temp = prique.front;
            while(temp!=null){
                this.add(temp.data);
                temp = temp.next;
            }
        }

    }

    //Adds a House object to the priority queue
    @Override
    public void add(House a) {
        //adding one so we add to the length
        Node newNode = new Node(a);
        if(isEmpty()){
            front = newNode;
            back = newNode;
            length++;
        }
        else{
            back.next = newNode;
            back = newNode;
            length++;
        }
    }
    //Gets the house with the highest value. Use the house’s value to determine priority. The item is removed from the priority queue.
    @Override
    public House getMostExpensive() {
        if(isEmpty()) return null; //checks if the list is empty first
        Node mostExpesniveHouse = front; // we need this node to keep track of the most expensive house.
        Node prevmostExpensiveHouse = null; // we need this node to delete the most expensive house.Or we could just use prev, but the time complex would be 2n instead of n.
        Node temp=front; // we need this node to traverse the list
        Node prev=null; // we need this node to update prevmostexpensive node.
        while (temp!=null){//this runs through the entire list
            if(temp.data.getValue() > mostExpesniveHouse.data.getValue()){
            mostExpesniveHouse=temp; //assigns the variable if the temp is more expensive.
            prevmostExpensiveHouse = prev;
            }
            //keeps track of prev and temp.
            prev=temp;
            temp=temp.next;
        }
        //used for deletion
        if (mostExpesniveHouse == front) {
            front = front.next; // if the front is the most expensive
            if (front == null) {
                back = null; // if the list becomes empty
            }
        } else if (mostExpesniveHouse == back) {
            back = prevmostExpensiveHouse; // last house is the most expensive
            if (back != null) { // so many problems where the length would be -3 after running this method. But this if statement fixes that. Sometimes if the last item was removed, it would duplicate a house removal.
                back.next = null; // update backs next to null
            }
        } else {
            prevmostExpensiveHouse.next = mostExpesniveHouse.next; // somewhere in the list is most expensive
        }
        length--;//removing one we subtract the length
        return mostExpesniveHouse.data;
    }
    //clears all items from the priority queue
    @Override
    public void clear() {
    front=null;
    back=null;
    length=0;
    }
    //Returns the number of houses being stored in the priority queue.
    @Override
    public int getLength() {
        return length;
    }
    //Returns true if the priority queue is empty
    @Override
    public boolean isEmpty() {
        return front == null;
    }
}
