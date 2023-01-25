/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick & Ethan Yuen
 * @version: 2022-2023
 */
import java.util.Scanner;
import java.util.ArrayList;


public class ContactList
{
    // TODO: Create your array contacts
    private ArrayList<Person> contacts;
    // TODO: Write a Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact(Scanner s) {
        // TODO: Complete the addContact method
        System.out.println("Select a type of contact to add:\n1. Student\n2. Athlete");
        int typeContact = s.nextInt();
        s.nextLine();
        if (typeContact == 1) {
            System.out.println("First Name:");
            String fN = s.nextLine();
            System.out.println("Last Name:");
            String lN = s.nextLine();
            System.out.println("Phone Number:");
            String pN = s.nextLine();
            System.out.println("Grade:");
            int grade = s.nextInt();
            contacts.add(new Student(fN, lN, pN, grade));
        }
        else if(typeContact == 2) {
            System.out.println("First Name:");
            String fN = s.nextLine();
            System.out.println("Last Name:");
            String lN = s.nextLine();
            System.out.println("Phone Number:");
            String pN = s.nextLine();
            System.out.println("Sport:");
            String sport = s.nextLine();
            contacts.add(new Athlete(fN, lN, pN, sport));
        }
    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (Person contact : contacts)
        {
            System.out.println(contact);
        }

    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        int n = contacts.size();
        switch(sortBy) {
            case 0://first name
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (contacts.get(j+1).getFirstName().compareTo(contacts.get(j).getFirstName()) < 0) { //arr[j] > arr[j + 1]
                            //s1 < s2, it returns negative number
                            // swap arr[j+1] and arr[j]
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;
            case 1://last name
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (contacts.get(j+1).getLastName().compareTo(contacts.get(j).getLastName()) < 0) { //arr[j] > arr[j + 1]
                            //s1 < s2, it returns negative number
                            //swap arr[j+1] and arr[j]
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;
            case 2://phone number
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < n - i - 1; j++) {
                        if (contacts.get(j+1).getPhoneNumber().compareTo(contacts.get(j).getPhoneNumber()) < 0) { //arr[j] > arr[j + 1]
                            //s1 < s2, it returns negative number
                            //swap arr[j+1] and arr[j]
                            Person temp = contacts.get(j);
                            contacts.set(j, contacts.get(j + 1));
                            contacts.set(j + 1, temp);
                        }
                    }
                }
                break;

        }
    }

    // TODO: Write searchByFirstName
    public void searchByFirstName(String firstName){
        for (Person contact : contacts)
        {
            if (contact.getFirstName().equals(firstName)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println(firstName + " is not in the list.");
    }

    // TODO: Write searchByLastName
    public void searchByLastName(String lastName){
        for (Person contact : contacts)
        {
            if (contact.getLastName().equals(lastName)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println(lastName + " is not in the list.");

    }
    // TODO: Write searchByPhoneNumber
    public void searchByPhoneNumber(String phoneNumber){
        for (Person contact : contacts)
        {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println(phoneNumber + " is not a phone number in the list.");

    }
    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (Person contact : contacts)
        {
            if (contact instanceof Student)
            {
                System.out.println(contact);
            }
        }
    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        Scanner scan = new Scanner(System.in);


        // TODO: Complete the run method
        while(true){
            printMenuOptions();
            int input = scan.nextInt();
            scan.nextLine();
            String inputS;
            switch(input) {
                case 1:
                    addContact(scan);
                    break;
                case 2:
                    sort(0);
                    printContacts();
                    break;
                case 3:
                    sort(1);
                    printContacts();;
                    break;
                case 4:
                    sort(2);
                    printContacts();
                    break;
                case 5:
                    listStudents();
                    break;
                case 6:
                    System.out.println("Enter a first name: ");
                    inputS = scan.nextLine();
                    searchByFirstName(inputS);
                    break;
                case 7:
                    System.out.println("Enter a last name: ");
                    inputS = scan.nextLine();
                    searchByLastName(inputS);
                    break;
                case 8:
                    System.out.println("Enter a phone number: ");
                    inputS = scan.nextLine();
                    searchByPhoneNumber(inputS);
                    break;
                case 0:
                    scan.close();
                    System.out.println("exiting");
                    return;
                }
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
