/* Summary: This code defines the PhoneDirectory class which essentially allows the user to create a PhoneDirectory of DirectoryEntry objects. Additionally several operations are defined that will allow the users to customize the Phone Directory */

import java.io.*;
import java.util.*;

public class PhoneDirectory{
    private ArrayList<DirectoryEntry> theDirectory;
    
    //The constructor for this class initializes an ArrayList which stores DirectoryEntry objects
    public PhoneDirectory(){
        theDirectory = new ArrayList<DirectoryEntry>();
    }
    
    //Returns the size of the PhoneDirectory
    public int size(){
        return theDirectory.size();
    }
    
    //Returns a DirectoryEntry at the specified index
    public DirectoryEntry get(int index){
        return theDirectory.get(index);
    }
    
    //Return the number associated with certain name in the PhoneDirectory
    public String getNumber(String aName){
        int index = theDirectory.indexOf(new DirectoryEntry(aName,""));
        if(index != -1){
            return theDirectory.get(index).getNum();
        }
        else{
            return null;
        }
    }
    
    //Allows the user to either add a new entry or change an existing one
    public String addOrChangeEntry(String aName, String aNumber){
        int nameIndex = theDirectory.indexOf(new DirectoryEntry(aName, ""));
        if(nameIndex != -1){
            String oldNum = theDirectory.get(nameIndex).getNum();
            theDirectory.get(nameIndex).setNum(aNumber);
            return oldNum;
        }
        else{
            theDirectory.add(new DirectoryEntry(aName, aNumber));
            return null;
        }
    }
    
    //Returns the entry for a specified name
    public DirectoryEntry searchEntry(String aName){
        int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
        if(index != -1){
            return theDirectory.get(index);
        }
        else{
            return null;
        }
    }
    
    //Removes and returns an entry for a specified name
    public DirectoryEntry removeEntry(String aName){
        int index = theDirectory.indexOf(new DirectoryEntry(aName, ""));
        if(index != -1){
            return theDirectory.remove(index);
        }
        else{
            return null;
        }
    }
    
    //Prints out all entries in the PhoneDirectory
    public void displayAllEntries(){
        Iterator<DirectoryEntry> iter = theDirectory.iterator();
        while(iter.hasNext()){
            DirectoryEntry nextEntry = iter.next();
            System.out.println("Name: " + nextEntry.getName());
            System.out.println("Number: " + nextEntry.getNum());
        }
    }
    
}
