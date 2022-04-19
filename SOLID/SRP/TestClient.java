import java.io.FileWriter;

public class TestClient { // Developer A
    public static void main(String[] args) {
        Customer cust = new Customer();
        cust.add(new Database());
        System.out.println("Program successfully completed");
    }
}

class Customer { // You are the developer
    void add(Database db) {
        try {
            db.add();
        } catch (Exception ex) {
            try {
                FileLogger fileLogger = new FileLogger();
                fileLogger.log("Welcome to ITSA.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class FileLogger {
    void log(String errorMsg) {
        try {
            FileWriter fw = new FileWriter("D:\\testout.txt");
            fw.write(errorMsg);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Skeleton codes - Other Developers
class Database {
    void add() {
    }

    void add(String postMessage) {
    }

    void addAsTag(String postMessage) {
    }
}
