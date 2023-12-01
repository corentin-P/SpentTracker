import javax.swing.*;
import java.util.ArrayList;

public class ViewModify extends JDialog {
    /** Creates a View to modify one element
     * @param connection : connection to the db
     * @param table : table to modify
     * @param id : id of the line to modify
     */
    public ViewModify(String table, ConnectionDB connection, int id){
        super();
        if (table.equals("firms")) {
            ArrayList<String> places = connection.getElementFromTable(table, "place");
            JLabel place = new JLabel("place");
            JTextField field_place = new JTextField(places.get(id-1));
            add(place);
            add(field_place);
        }
    }
}
