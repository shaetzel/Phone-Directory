/* Summary: This code creates a DirectoryEntry class which allows for the creation of a DirectoryEntry object which has the two features: name and number. This code also defines various methods that help with the use of a DirectoryEntry.
Author: Sarah Haetzel
*/

public class DirectoryEntry{
    String name;
    String number;
    
    //Constructor for a DirectoryEntry object
    public DirectoryEntry(){
        name = "";
        number = "";
    }
    
    //Constructor for a DirectoryEntry that takes two parameters
    public DirectoryEntry(String nam, String num){
        name = nam;
        number = num;
    }
    
    //Accessor method that returns the name
    public String getName(){
        return name;
    }
    
    //Accessor method that returns the number
    public String getNum(){
        return number;
    }
    
    //Equals method to check the equality of two DirectoryEntry objects
    public boolean equals(Object anEntry){
        DirectoryEntry castEntry = (DirectoryEntry) anEntry;
        if((this.getName()).equals(castEntry.getName())){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Mutator method that sets the name of a DirectoryEntry
    public void setName(String aName){
        name = aName;
    }
    
    //Mutator method that prints a DirectoryEntry properly
    public void setNum(String aNum){
        number = aNum;
    }
    
    //toString method that print a DirectoryEntry properly
    public String toString(){
        return("Name: " + name + '\n' + "Number: " + number);
    }
}
