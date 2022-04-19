
public class TestClient { // Developer A
    public static void main(String[] args) {
        Post p = new Post();
        p.createPost(new Database(), "Welcome to ITSA");
        System.out.println("End of program");
    }
}

// You are the developer
class Post {
    void createPost(Database db, String postMessage) {
        db.add(postMessage);
    }
}

class TagPost extends Post {
    @Override
    void createPost(Database db, String tagPostMessage) {
        db.addAsTag(tagPostMessage);
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
