import java.util.*;

public class TestClient { // Developer A
    public static void main(String[] args) {
        ClaimsReport claimsReport = new ClaimsReport();
        claimsReport.displayClaimsReport();
    }
}

class ClaimsReport { // Developer B
    public void displayClaimsReport() {
        // Cache cache = new Cache();
        Cache cache = Cache.getInstance();
        System.out.println(cache.lookupValue("TR"));
    }
}

// You are the developer

// a. Make constructor(s) private so that they can not be called from outside
// b. Declare a single static private instance of the class
// c. Write a public getInstance() or similar method that allows access to the

// single instance
class Cache {

    Map<String, String> lookupValues = new HashMap<String, String>();

    private Cache() {
        // read from DB and put into map
        lookupValues.put("TR", "Transport");
    }

    private static final Cache INSTANCE = new Cache();

    public static Cache getInstance() {
        return Cache.INSTANCE;
    }

    public String lookupValue(String name) {
        return lookupValues.get(name);
    }
}