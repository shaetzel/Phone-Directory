# Phone-Directory
This project consists of various files that allow the user to build, modify, view
and save a phone directory. 

The DirectoryEntry class creates a DirectoryEntry object which has both a name and 
number. This class also contains function definitions that allow the instances of the
DirectoryEntry to be accessed and mutated.

The PhoneDirectory class creates an array list of DirectoryENtry objects and then 
defines a wide variety of methods including the addOrChangeEntry, the searchEntry, the
removeEntry and the displayAllEntries functions. This class allows for the creation of
a phone book which the user can interact with in various ways.

The DirectoryTester file contains the driver program, which is a user-friendly program where the user selects from a menu of various options in order to work with a phone directory. First, the user is allowed to choose whether to load the directory from an existing file or whether to start a new phone directory. Then, the user is able to select from a menu what they would like to do next. The options are adding new entries, changing existing entries, removing entries, searching for entries, diplaying all entries and quitting the program. Before the user quits, they are able to decide whether or not to save their phone directory to the savedDirectory.txt file.
