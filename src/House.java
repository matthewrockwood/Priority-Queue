/**Class for the House Object*/
public class House {
    private String owner;
    private int value;
    /** this is the default constructor*/
    House(){
    this.owner = null;
    this.value = -1;
    }
    /**Constructor that takes in the Variables*/
   public House(String owner, int value){
        this.owner = owner;
        this.value = value;
    }
    /**This Does a DeepCopy Of the House*/
   public House(House other){
        this.owner = other.owner;
        this.value = other.value;
    }
    /**method that returns the owner*/
    public String getOwner() {
        return owner;
    }
    /**method that returns the value*/
    public int getValue() {
        return value;
    }
    /**method that sets the owner*/
    public void setOwner(String owner){
        this.owner = owner;
    }
    //**method that sets the value
    public void setValue(int x){
        this.value = x;
    }
    /**Method that creates a deep copy of a House Object*/
    public House deepCopy(){
        return new House(this.owner,this.value);
    }
    /** Method used for equals method for two houses*/
    public boolean equals(House B){
        return (owner.equals(B.owner)&&value == B.value);
    }

}
