import java.util.*;

public class TestClient { // Developer A
    public static void main(String[] args) {
        Cache cache = Cache.getCache();
        System.out.println(cache.lookupValue("TR"));

        LVSubject.getSubject().notifyRegisteredUsers();
    }
}

// You are the developer

// Steps:
// a. Create an interface of the subject with methods to register, notify and
// unregister.
// b. Create concrete (subject) class implementing the subject interface.
// c. Create interface with methods for the observer
// d. Update concrete (observer) to implement the interface.
// e. Register observers to the subject

interface LVObserverInterface { // Observer
    public void updateValue();
}

class Cache implements LVObserverInterface { // observer
    Map<String, String> lookupValues = new HashMap<String, String>();

    private Cache() {
        // read from DB and put into map
        lookupValues.put("TR", "Transport");
        LVSubject.getSubject().register(this);
    }

    private static final Cache INSTANCE = new Cache();

    public static Cache getCache() {
        return Cache.INSTANCE;
    }

    public String lookupValue(String name) {
        return lookupValues.get(name);
    }

    public void updateValue() {
        System.out.println("An update is received.");
    } // some processing
}

interface LVSubjectInterface { // Subject
    void register(LVObserverInterface anObserver);

    void unregister(LVObserverInterface anObserver);

    void notifyRegisteredUsers();
}

class LVSubject implements LVSubjectInterface {
    private LVSubject() {
    }

    private static LVSubject subject = new LVSubject();

    public static LVSubjectInterface getSubject() {
        return subject;
    }

    List<LVObserverInterface> observerList = new ArrayList<LVObserverInterface>();

    public void register(LVObserverInterface anObserver) {
        observerList.add(anObserver);
    }

    public void unregister(LVObserverInterface anObserver) {
        observerList.remove(anObserver);
    }

    public void notifyRegisteredUsers() {
        for (LVObserverInterface observer : observerList)
            observer.updateValue();
    }
}
