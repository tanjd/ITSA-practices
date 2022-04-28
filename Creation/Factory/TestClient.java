public class TestClient { // Developer A
    public static void main(String[] args) {
        ClaimsReport claimsReport = new ClaimsReport();
        claimsReport.retrievePersonalDetails();
        claimsReport.retrieveClaimsDetails();
    }
}

class ClaimsReport { // Developer B
    TableFactory tFactory = new ATableFactory();

    public void retrievePersonalDetails() {
        Table s1 = tFactory.getTable(DatabaseType.MSSQL);
        s1.select();
    }

    public void retrieveClaimsDetails() {
        Table s1 = tFactory.getTable(DatabaseType.MySQL);
        s1.select();
    }
}

// You are the developer

// Steps:
// a. Create an interface of the product.
// b. Create concrete classes implementing the product interface.
// c. Create an interface of the creator (factory) class
// d. Create a concrete class implementing the creator interface

interface TableFactory { // Factory
    public Table getTable(DatabaseType type);
}

class ATableFactory implements TableFactory {
    public Table getTable(DatabaseType type) {
        if (type == DatabaseType.MySQL) {
            return new MySQLTable();
        } else if (type == DatabaseType.MSSQL) {
            return new MSSQLTable();
        } else {
            return null;
        }
    }
}

interface Table { // Product
    public boolean select();
}

class MSSQLTable implements Table {
    public boolean select() {
        System.out.println("MSSQLTable::select() was called.");
        return true;
    }
}

class MySQLTable implements Table {
    public boolean select() {
        System.out.println("MySQLTable::select() was called.");
        return true;
    }
}

enum DatabaseType {
    MySQL, MSSQL, Oracle, PostgreSQL
}
