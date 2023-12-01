import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Model {
    private ConnectionDB connection;

    public Model(ConnectionDB c){
        this.connection = c;
    }

    public JPanel names(String table)
    {
        ArrayList<String> names = connection.getNames(table);
        System.out.println(names);
        JPanel p = new JPanel();
        JPanel ligne = new JPanel(new GridLayout(names.size(), 2));
        for (int i = 0; i<names.size(); i++){
            ligne.add(new JLabel(names.get(i)));
            ligne.add(new JButton("Modifier"));
        }
        p.add(ligne);
        return p;
    }

}
