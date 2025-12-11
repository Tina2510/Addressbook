import java.util.*;
public class AddressBookMain {
    static class Contact {
        String firstName, lastName, address, city, state, zip, phone, email;


        Contact(String fn, String ln, String address, String city, String state,
                String zip, String phone, String email) {
            this.firstName = fn;
            this.lastName = ln;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.phone = phone;
            this.email = email;
        }
    }
        static class AddressBook {
            List<Contact> contacts = new ArrayList<>();
        }
        public static Contact createContact() {
            Scanner sc = new Scanner(System.in);

            System.out.print("First Name: ");
            String fn = sc.nextLine();

            System.out.print("Last Name: ");
            String ln = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            System.out.print("City: ");
            String city = sc.nextLine();

            System.out.print("State: ");
            String state = sc.nextLine();

            System.out.print("ZIP: ");
            String zip = sc.nextLine();

            System.out.print("Phone: ");
            String phone = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            return new Contact(fn, ln, address, city, state, zip, phone, email);
        }
        public static void addContact(AddressBook ab) {
        Contact newContact = createContact();
        ab.contacts.add(newContact);
        System.out.println("Contact added successfully!");
        }
    public static void editContact(AddressBook ab) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name of contact to edit: ");
        String name = sc.nextLine();

        for (Contact c : ab.contacts) {
            if (c.firstName.equalsIgnoreCase(name)) {
                System.out.println("Enter new details:");
                Contact updated = createContact();

                c.firstName = updated.firstName;
                c.lastName = updated.lastName;
                c.address = updated.address;
                c.city = updated.city;
                c.state = updated.state;
                c.zip = updated.zip;
                c.phone = updated.phone;
                c.email = updated.email;

                System.out.println("Contact updated successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
    public static void deleteContact(AddressBook ab) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name of contact to delete: ");
        String name = sc.nextLine();

        Iterator<Contact> it = ab.contacts.iterator();
        while (it.hasNext()) {
            Contact c = it.next();
            if (c.firstName.equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Contact deleted successfully!");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
    public static void addMultipleContacts(AddressBook ab) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            addContact(ab);  // Reuse UC2 method

            System.out.print("Add another contact? (y/n): ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }
    static Map<String, AddressBook> addressBookDict = new HashMap<>();
    public static AddressBook createAddressBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter AddressBook name: ");
        String name = sc.nextLine();

        if (addressBookDict.containsKey(name)) {
            System.out.println("AddressBook already exists. Switching to it.");
            return addressBookDict.get(name);
        }

        AddressBook ab = new AddressBook();
        addressBookDict.put(name, ab);
        System.out.println("AddressBook '" + name + "' created!");
        return ab;
    }


    public static AddressBook switchAddressBook() {
        Scanner sc = new Scanner(System.in);

        if (addressBookDict.isEmpty()) {
            System.out.println("No AddressBooks found. Creating a default one.");
            AddressBook defaultAB = new AddressBook();
            addressBookDict.put("Default", defaultAB);
            return defaultAB;
        }

        System.out.println("Available AddressBooks: " + addressBookDict.keySet());
        System.out.print("Enter AddressBook name to switch: ");
        String name = sc.nextLine();

        if (addressBookDict.containsKey(name)) {
            return addressBookDict.get(name);
        } else {
            System.out.println("AddressBook not found.");
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook currentBook = createAddressBook(); // create first address book

        while (true) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Add Multiple Contacts");
            System.out.println("5. Create New AddressBook");
            System.out.println("6. Switch AddressBook");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact(currentBook);
                    break;
                case 2:
                    editContact(currentBook);
                    break;
                case 3:
                    deleteContact(currentBook);
                    break;
                case 4:
                    addMultipleContacts(currentBook);
                    break;
                case 5:
                    currentBook = createAddressBook();
                    break;
                case 6:
                    AddressBook switched = switchAddressBook();
                    if (switched != null) {
                        currentBook = switched;
                        System.out.println("Switched successfully!");
                    }
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


}
