public class TestClient { // Developer A
    public static void main(String[] args) {
        Login login = new Login();
        login.constructUser();
        System.out.println("Program successfully completed");
    }
}

class Login { // Developer B
    public User constructUser() {
        // return new Staff("Ouh", "", "Eng Lieh", "80", "Stamford Road", "5036",
        // "Singapore", 178902, true);
        NameBuilder nameBuilder = new NameBuilder("Ouh", "Eng Lieh", "");
        AddressBuilder addressBuilder = new AddressBuilder("80", "Stamford Road", "5036", "Singapore", 178902);
        StaffBuilder staff = new StaffBuilder(true);
        staff.buildName(nameBuilder);
        staff.buildAddress(addressBuilder);
        return staff.getUser();
    }
}

// You are the developer

// Steps:
// a. Encapsulate, create, and assemble the parts of a complex object in a
// separate Builder object.
// b. Delegate the object creation to a Builder object instead of creating the
// objects directly.

interface UserBuilder { // Builder
    void buildName(NameBuilder nameBuilder);

    void buildAddress(AddressBuilder addressBuilder);

    User getUser();
}

class StaffBuilder implements UserBuilder {
    private User user;
    private NameBuilder nameBuilder;
    private AddressBuilder addressBuilder;

    public StaffBuilder(boolean isEmployed) {
        user = new User(isEmployed);
    }

    public void buildName(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;
    }

    public void buildAddress(AddressBuilder addressBuilder) {
        this.addressBuilder = addressBuilder;
    }

    public User getUser() {
        return user;
    }
    // setter methods for the abstract methods
}

class GuestBuilder implements UserBuilder {
    private User user;
    private NameBuilder nameBuilder;
    private AddressBuilder addressBuilder;

    public GuestBuilder() {
        user = new User(false);
    }

    public void buildName(NameBuilder nameBuilder) {
        this.nameBuilder = nameBuilder;
    }

    public void buildAddress(AddressBuilder addressBuilder) {
        this.addressBuilder = addressBuilder;
    }

    public User getUser() {
        return user;
    }
    // setter methods for the abstract methods
}

class User { // Product
    private NameBuilder nameBuilder;
    private AddressBuilder addressBuilder;
    private boolean isEmployed;

    public User(boolean isEmployed) {
        this.isEmployed = isEmployed;
    }
    // assume constructor and setter methods
}

class NameBuilder {
    private String lastName;
    private String firstName;
    private String middleName;

    public NameBuilder(String lastName, String firstname, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
    // assume constructor and setter methods
}

class AddressBuilder {
    private final String addressBlock;
    private final String addressStreet;
    private final String addressUnit;
    private final String addressCity;
    private final int addressPostalCode;

    public AddressBuilder(String addressBlock, String addressStreet, String addressUnit, String addressCity,
            int addressPostalCode) {
        this.addressBlock = addressBlock;
        this.addressStreet = addressStreet;
        this.addressUnit = addressUnit;
        this.addressCity = addressCity;
        this.addressPostalCode = addressPostalCode;
    }
    // assume constructor and setter methods
}