public class OutgoingJob { // Developer A
  public static void main(String[] args) {
    Claim claim = new Claim();
    ClaimAdapterInterface service = new SAPService();
    service.send(claim);
    ClaimAdapterInterface service2 = new CSystemAdapter();
    service2.send(claim);
    // For Csystem, possible solution is to use the nativeObject and use the
    // incompatible interfaces.
    // however this create tight coupling as this coder requires to understands the
    // native object.
  }
}

// You are the developer

// Steps:
// a. Create an interface of the adapter.
// b. Create concrete (adapter) class implementing the adapter interface.
// c. Let the adapter compose the adaptee
// d. Implement the logic to adapt the adaptee

interface ClaimAdapterInterface {
  public void send(Claim claim);
}

class SAPService implements ClaimAdapterInterface {
  public void send(Claim claim) {
  } // some preocessing
}

class CSystemAdapter implements ClaimAdapterInterface {
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

public class Claim {
  public String getItems() {
    return "";
  };

  public int getAmount() {
    return 100;
  };
}