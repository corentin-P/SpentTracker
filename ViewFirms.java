import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewFirms extends ViewsCMF implements Views{
    private ArrayList<String> places;

    public ViewFirms(View parentPage, ArrayList<String> names, ArrayList<String> places) {
        super(parentPage, names);
        this.places = places;
    }

    public void display (String table) {
        JPanel p = new JPanel();
        JPanel global = new JPanel(new BorderLayout());
        JPanel title = new JPanel();
        JPanel ligne = new JPanel(new GridLayout(names.size(), 2));
        for (int i = 0; i<names.size(); i++){
            ligne.add(new JLabel(names.get(i)));
            IdJButton modify = new IdJButton("Modify", i+1, table);
            modify.addActionListener(controller);
            ligne.add(modify);
        }
        JLabel labelTitle = new JLabel("Firms", SwingConstants.CENTER);
        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //new ViewModifyCMF(table, new ConnectionDB(), )
            }
        });
        title.add(labelTitle);
        title.add(add);
        global.add(title, BorderLayout.NORTH);
        global.add(ligne, BorderLayout.CENTER);
        labelTitle.setPreferredSize(new Dimension(200, 100));
        p.add(global, BorderLayout.PAGE_START);
        parentPage.changePanel(p);
    }

    public ArrayList<String> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }
    public void setPlace(int id, String value) {
        places.set(id, value);
    }

    public void addPlace(String value) {
        places.add(value);
    }
}
