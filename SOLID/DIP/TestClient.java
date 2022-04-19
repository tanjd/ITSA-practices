import java.io.FileWriter;

public class TestClient { // Developer A
    public static void main(String[] args) {
        Customer cust = new Customer(new FileLogger());
        cust.add(new Database());
        System.out.println("End of program");
    }
}

interface Logger {
    void handle(String error);
}

// You are the developer
class Customer {
    private Logger logger;

    public Customer(Logger logger) {
        this.logger = logger;
    }

    void add(Database db) {
        try {
            db.add();
        } catch (Exception ex) {
            logger.handle(ex.toString());
        }
    }
}

class FileLogger implements Logger {
    public void handle(String error) {
        try {
            FileWriter fw = new FileWriter("D:\\testout.txt");
            fw.write("Welcome to ITSA.");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Skeleton codes
class Database {
    void add() {
    }

    void add(String postMessage) {
    }

    void addAsTag(String postMessage) {
    }
}