import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsManagerV2 {
    //Instances
    public static String directory = "./src/contactsIO/data";
    public static String filename = "contacts.txt";
    public static Path contactsTxtPath = Paths.get(directory,filename);
    public static Path dataDirectory = Paths.get(directory);
    public static Path dataFile = Paths.get(directory, filename);

    //Main method
    public static void main(String[] args) throws IOException{
        System.out.println("\n\n\nWelcome to the contacts manager!\n");
        mainMenu();
    }

    //  CONTACTS
    public static void DisplayAllContacts() throws IOException {
//        Path contactsTxtPath = Paths.get(directory,filename);
        List<String> contactsList = Files.readAllLines(contactsTxtPath);
        System.out.println(" \n");
        for (int i = 0; i < contactsList.size(); i +=1){
            System.out.println((i + 1) + ": " + contactsList.get(i));
        }}


    //Remove name method
    public static void removeName() throws IOException {
        Scanner cl = new Scanner(System.in);
        System.out.println("Please enter a name to delete \n");
        String name = cl.nextLine();
        List<String> contactName = Files.readAllLines(contactsTxtPath);
        List<String> anotherCL = new ArrayList<>();
        for (String contact : contactName) {
            if (contact.contains(name)) {
                continue;
            } else
                anotherCL.add(contact);
        }
        Files.write(contactsTxtPath, anotherCL);
//        System.out.println(anotherCL);
    }
    //    public static String[] searchName(String name) throws IOException {
//
//        List<String> contactList = Files.readAllLines(contactsTxtPath);
//        String[] contactFound = new String[0];
//        for (String contact : contactList) {
//            if (contact.contains(name)) {
//                contactFound = contact.split(":");
//            }
//        }
//        return contactFound;
//    }

    //Search name method
    public static void searchName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search contact information by name: ");
        String name = scanner.nextLine();
        boolean nameFound = false;
        //
        //              ADD FEATURE TO SEARCH FOR LOWERCASE
        //
        List<String> contactList = Files.readAllLines(contactsTxtPath);
        for (String contact : contactList) {
            if (contact.contains(name.toLowerCase(Locale.ROOT)) || contact.contains(name) ) {
                name = contact;
                nameFound = true;
                break;
            }
        }
        if (nameFound) {
            System.out.println(name);
        } else {
            System.out.println("Sorry Contact not found");
        }
    }

    //Add contacts method
    public static void addContact() throws IOException {
        String directory = "./src/contactsIO/data";
        String filename = "contacts.txt";
        Scanner sc = new Scanner(System.in);
        System.out.println(" Please Enter Firstname");
        String inputContactFirstname = sc.nextLine();
        System.out.println(" Please Enter Lastname");
        String inputContactLastname = sc.nextLine();
        System.out.println(" Please Enter Phone Number without Dashes");
        String inputContactPhoneNumber = sc.nextLine();
        System.out.printf("%s " + "%s " + "| " + "%s ", inputContactFirstname, inputContactLastname, inputContactPhoneNumber);
        Path  contactsTxtPath = Paths.get(directory,filename);
//        Files.write(contactsTxtPath, Arrays.asList(inputContactFirstname + " " + inputContactLastname + " | " + inputContactPhoneNumber), StandardOpenOption.APPEND);
        Files.write(contactsTxtPath, Arrays.asList(inputContactFirstname + inputContactLastname + " | " + inputContactPhoneNumber), StandardOpenOption.APPEND);
    }

    // This is our main menu for our application.
    public static void mainMenu() throws IOException {
        Scanner ui = new Scanner(System.in);
        int userInput;
        String yesOrNo;
        boolean loop = true;
        while (loop) {
            System.out.println("       Contacts Manager    \n");
            System.out.println("Please input one of the following: ");
            System.out.println("1. View Contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search a contact by name.");
            System.out.println("4. Delete an existing contact.");
            System.out.println("5. Exit.");
            System.out.println("Enter an option (1, 2, 3, 4, 5)");
            userInput = ui.nextInt();
            if (userInput == 0) {
                loop = false;
            } else if (userInput == 1){
                DisplayAllContacts();
//                System.out.println("Would you like to go back to the main menu?");
//                yesOrNo = ui.nextLine();
//
//                    if(yesOrNo == "Yes"){
//                        continue;
//                    } else if (yesOrNo == "No"){
//                        continue;
//                    }
//                    loop = false;
            } else if (userInput == 2){
                addContact();
            } else if (userInput == 3){
                searchName();
            } else if (userInput == 4){
                removeName();
            } else if (userInput == 5){
                loop = false;
            }
        }
    }


}
