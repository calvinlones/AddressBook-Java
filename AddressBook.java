package finalprojectmain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBook {
    private Contact[] friends;//array for instances of address book
    private int numfriends;//number of people in address book
    
    //default constructor that creates room for 10 entries in address book
    public AddressBook(){
        friends= new Contact[10];
        numfriends = 0;
    }
    //subroutine to add a new contact
    public void addContact(Contact c) throws IOException{
        friends[numfriends] = c;
        numfriends++;
        writeToBook(c);
    }
    //subroutine to print all contacts 
    public void printContacts(){
        for (int i=0; i<numfriends; i++)
            friends[i].printContact();
    }
    //subroutine that returns number of people in address book
    public int numContacts(){
        return numfriends;
    }
    //this writes the detail of a contact to a file to save
    public void writeToBook(Contact c) throws FileNotFoundException, IOException{
        File file;
        file = new File("addressbook.txt");
        FileWriter fw = new FileWriter(file);
        if (!file.exists()) {
            System.out.println("Target file addressbook doesn't already exist.");
            System.exit(3);
        }
        fw.write(c.toString());
        
        
    }
    //subroutine that returns a non-negative integer if a Conact with name s exists
    //non-neg int is array index of contact in address book
    //returns -1 if s is not in address book
    private int haveContact(String s){
        for (int i=0; i<numfriends; i++)
            if (friends[i].getName().equals(s))
                return i;
        return -1;
    }
    //subroutine that deletes a contact with name s if s in address book
    public void deleteContact(String s){
        int place = haveContact(s);
        if (place >= 0)
        {
            friends[place] = friends[numfriends-1];
            numfriends--;
        }
    }
}
