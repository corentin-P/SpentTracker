import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewModify extends JDialog {

    private JPanel panelName, panelPlace;
    private JLabel name, place;
    private JTextField fieldName, fieldPlace;
    private ConnectionDB connection;
    private Model model;

    /** Creates a View to modify one element
     * @param connection : connection to the db
     * @param table : table to modify
     * @param id : id of the line to modify
     */
    public ViewModify(String table, ConnectionDB connection, int id, Model model){
        super();
        this.connection = connection;
        this.model = model;
        setLayout(new GridLayout(table.equals("firms") ? 3 : 2, 0));
        panelName = new JPanel(new GridLayout(1,2));
        panelPlace = null;
        ArrayList<String> names = connection.getElementsFromTable(table, "name");
        name = new JLabel("Name");
        place = null;
        fieldName = new JTextField(30);
        fieldName.setText(names.get(id-1));
        fieldPlace = new JTextField(30);
        panelName.add(name, CENTER_ALIGNMENT);
        panelName.add(fieldName);
        add(panelName);

        if (table.equals("firms")) {
            panelPlace = new JPanel(new GridLayout(1,2));
            place = new JLabel("Place");
            ArrayList<String> places = connection.getElementsFromTable(table, "place");
            fieldPlace.setText(places.get(id-1));
            panelPlace.add(place);
            panelPlace.add(fieldPlace);
            add(panelPlace);
        }

        JButton validForm = new JButton("Valid");
        validForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection.modifyStringElementOfTable(id, table, "name", fieldName.getText());

                if (!fieldPlace.getText().equals("")) connection.modifyStringElementOfTable(id, table, "place", fieldPlace.getText());
                dispose();

            }
        });

        add(validForm);
        setVisible(true);
        pack();
    }
}
