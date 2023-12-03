import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();

        // views of the app
        View v = new View();
        ViewFirms firms= new ViewFirms(v, connection.getNames("firms"), connection.getElementsFromTable("firms", "place"));
        ViewCategoriesPaymentMode categories = new ViewCategoriesPaymentMode(v, connection.getNames("categories"));
        ViewCategoriesPaymentMode mode = new ViewCategoriesPaymentMode(v, connection.getNames("mode"));
        HashMap<String, Views> views = new HashMap<>();
        views.put("principal", v);
        views.put("firms", firms);
        views.put("categories", categories);
        views.put("mode", mode);

        Model m = new Model(connection, v, views);
        Controller c = new Controller(v, m);

        views.forEach((key, value) -> {
            value.addController(c);
        });

    }
}
