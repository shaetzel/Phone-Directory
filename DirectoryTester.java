import java.util.*;
import java.io.*;

public class DirectoryTester{
    public static void main(String[] args){
        //Initialize a new phone directory
        PhoneDirectory myDirect = new PhoneDirectory();
        String ans = "yes";
        while(ans.equals("yes")){
            //Allow the user to select from loading an existing directory or creating a new one
            
            System.out.println("Please select an option from the menu below: ");
            System.out.println("1 - Load a Phone Directory from a File");
            System.out.println("2 - Start a New Phone Directory");
            
            Scanner menuChoice = new Scanner(System.in);
            int choice = menuChoice.nextInt();
            
            if(choice == 1){
                //If the user wants to load an existing directory, the following code opens a specified file and initializes Directory Entries into the PhoneDirectory with the information stored in the file
                boolean fileFound = false;
                BufferedReader directoryInput = null;
                String inputLine = "";
                while(fileFound == false){
                    try{
                        System.out.println("Enter the name of the file: ");
                        Scanner inputFile = new Scanner(System.in);
                        String fileName = inputFile.nextLine();
                        directoryInput = new BufferedReader(new FileReader(fileName));
                        fileFound = true;
                        inputLine = directoryInput.readLine();
                        String[] inputArray = inputLine.split(",");
                        for(int i = 0; i<inputArray.length; i++){
                            String[] newEntry = inputArray[i].split("-");
                            myDirect.addOrChangeEntry(newEntry[0], newEntry[1]);
                        }
                    }
                    catch(FileNotFoundException e){
                        System.out.println("File not found - try again");
                    }
                    catch(IOException e){
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                    finally{
                        if(directoryInput != null){
                            try{
                                directoryInput.close();
                            }
                            catch(IOException e){
                                System.out.println("Error closing file.");
                            }
                        }
                    }
                }
            }
            String continueEdit = "yes";
            while(continueEdit.equals("yes")){
                //The following code allows the user to select from five different options to modify or interact with the PhoneDirectory
                System.out.println("Please select an action from the menu below.");
                System.out.println("1 - Add or Change an Entry");
                System.out.println("2 - Remove an Entry");
                System.out.println("3 - Search for an Entry");
                System.out.println("4 - Display all Entries");
                System.out.println("5 - Quit");
                Scanner menuOptions = new Scanner(System.in);
                int menuOptionChoice = menuOptions.nextInt();
                
                if(menuOptionChoice == 1){
                    //The user is prompted for the details of the new entry or the modifications to an existing entry
                    System.out.println("Enter the name of the entry to add or change : ");
                    Scanner nameEntry = new Scanner(System.in);
                    String name = nameEntry.nextLine();
                    
                    System.out.println("Enter the number of the entry to add or change: ");
                    Scanner numEntry = new Scanner(System.in);
                    String num = numEntry.nextLine();
                    
                    System.out.println(myDirect.addOrChangeEntry(name,num));
                }
                else if(menuOptionChoice == 2){
                    //The user is promped to input the name of the entry that is to be removed
                    System.out.println("Enter the name of the entry to remove: ");
                    Scanner nameEntry = new Scanner(System.in);
                    String name = nameEntry.nextLine();
                    System.out.println(myDirect.removeEntry(name));
                }
                else if(menuOptionChoice == 3){
                    //The user is able to search for an entry associated with a specified name
                    System.out.println("Enter the name of the entry to search for: ");
                    Scanner nameEntry = new Scanner(System.in);
                    String name = nameEntry.nextLine();
                    System.out.println(myDirect.searchEntry(name));
                }
                else if(menuOptionChoice == 4){
                    //This code displays all the entries in the phone book
                    myDirect.displayAllEntries();
                }
                else if(menuOptionChoice == 5){
                    continueEdit = "no";
                }
                System.out.println("Would you like to perform more actions?");
                Scanner menuLoop = new Scanner(System.in);
                continueEdit = menuLoop.nextLine();
            }
            
            //Below, if the user chooses to save the PhoneDirectory the savedDirectory.txt file is updated
            System.out.println("Would you like to save your directory to a file (yes/no)?");
            Scanner saveDirect = new Scanner(System.in);
            if(saveDirect.nextLine().equals("yes")){
                PrintWriter output = null;
                try{
                    output = new PrintWriter(new FileOutputStream("savedDirectory.txt"));
                    for(int i = 0; i<myDirect.size();i++){
                        DirectoryEntry nextEntry = myDirect.get(i);
                        output.print(nextEntry.getName() + "-" + nextEntry.getNum() + ",");
                    }
                }
                catch(FileNotFoundException e){
                    System.out.println("File not found");
                }
                finally{
                    if(output != null){
                        output.close();
                    }
                }
            }
            
            Scanner programLoop = new Scanner(System.in);
            System.out.println("Would you like to run the program again (yes/no)");
            ans = programLoop.nextLine();
        }
    }
}
