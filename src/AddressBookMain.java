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
}
