
public class TestClient { // Developer A
    public static void main(String[] args) {
        System.out.println("End of program");
    }
}

// Do not merge two methods into one interface, have separate interface if
// needed to make it more fine grained
interface PostCreate {
    void CreatePost();
}

interface PostRead {
    void ReadPost();
}
