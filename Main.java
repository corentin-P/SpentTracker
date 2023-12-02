public class Main {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();
        View v = new View();
        ViewFirms mode= new ViewFirms(v, connection.getNames("mode"), connection.getElementsFromTable("firms", "place"));
        Model m = new Model(connection, v, mode);
        Controller c = new Controller(v, m);
        v.addController(c);
        mode.addController(c);
    }
}
