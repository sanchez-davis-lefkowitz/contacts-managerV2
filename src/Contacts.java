public class Contacts {

    private String firstName;
    private String lastName;
    private String cellNumber;


    public Contacts(String firstName, String lastName, String cellNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellNumber = cellNumber;
    }

    public String getContact() {
        return firstName + " " + lastName + " " + cellNumber;
    }

    public void setContact(String firstName, String lastName, String cellNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellNumber = cellNumber;
    }

//        String directory = "./src/contactsIO/data";
//        String filename = "contacts.txt";
//
//        Path dataDirectory = Paths.get(directory);
//        Path dataFile = Paths.get(directory, filename);
//
//        System.out.println("dataFile = " + dataFile);
//
//        if(Files.notExists(dataDirectory)){//IF T: got down path and directory not there!
//
//            Files.createDirectories(dataDirectory); //go ahead and create a directory on this path :)
//
//        }
//
//        if(Files.notExists(dataFile)){//IF T: got down path and file not found in directory~
//
//            Files.createFile(dataFile);
//        }
//        Path  contactsTxtPath = Paths.get(directory,filename);
//
//        System.out.println("contactsTxtPath = " + contactsTxtPath);
//
//        List<String> contacts = Arrays.asList("Jonathan Sanchez | 2104445467", "Timothy Lefkowitz | 2106548756","Felecia Davis | 3362547998");
//
//        System.out.println("Contacts txt file = " + contacts);
//
//        Files.write(contactsTxtPath, contacts);
//
//        List<String> contactList = Files.readAllLines(contactsTxtPath);
//
//        System.out.println("Name      |        Phone Number\n" + "----------------------------");
//
//        for (int i = 0; i < contactList.size(); i +=1){
//            System.out.println((i + 1) + ": " + contactList.get(i));
//        }
//    }
    }