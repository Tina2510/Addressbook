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



}
