public class OutgoingJob { // Deveoper A
    public static void main(String[] args) {
        Claim claim = new Claim();
        // read from args the jobFrequency
        new OutgoingJobFacade().process("Monthly", claim);
    }
}

// You are the developer

// Steps:
// a. Create an interface and methods for the set of services behind the facade
// b. Create concrete (service) class implementing the service interface.
// c. Create concrete (facade) class to hide these services
// d. Implement the logic for client to call through the facade

interface ClaimFacadeInterface {
    public void send(Claim claim);
}

class OutgoingJobFacade {
    public void process(String jobFrequency, Claim claim) {
        if (jobFrequency.equals("Monthly")) {
            ClaimFacadeInterface service = new SAPService();
            service.send(claim);
        } else { // assume daily
            ClaimFacadeInterface service = new CSystemAdapter();
            service.send(claim);
        }
    }
}

class SAPService implements ClaimFacadeInterface {
    public void send(Claim claim) {
    } // some preocessing
}

class CSystemAdapter implements ClaimFacadeInterface {
    CSystemService nativeObject = new CSystemService();

    public void send(Claim claim) { // send claims to C System
        nativeObject.send(claim.getItems(), claim.getAmount());
    }
}

// NativeObject with the method differ from above send method-
// send(claim.items(), claim.getAmount());
class CSystemService {
    public void send(String items, int amount) {
    } // some preocessing
}

class Claim {
    public String getItems() {
        return "";
    };

    public int getAmount() {
        return 100;
    };
}