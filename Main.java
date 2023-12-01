public class Main {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();
        View v = new View();
        Model m = new Model(connection);
        Controller c = new Controller(v, m);
        v.addController(c);
    }
}
