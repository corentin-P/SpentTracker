import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewFirms extends JPanel implements Views{
    private View parentPage;
    private ArrayList<String> names;
    private ArrayList<String> places;
    private Controller controller;

    public ViewFirms(View parentPage, ArrayList<String> names, ArrayList<String> places) {
        super();
        this.parentPage = parentPage;
        this.names = names;
        this.places = places;
        setLayout(new GridLayout(names.size(), 2));
    }

    public void addController(Controller controller){
        this.controller = controller;
    }

    public void display (String table) {

        JPanel p = new JPanel();
        JPanel panelTitle = new JPanel(new BorderLayout());
        JPanel ligne = new JPanel(new GridLayout(names.size(), 2));
        for (int i = 0; i<names.size(); i++){
            ligne.add(new JLabel(names.get(i)));
            IdJButton modify = new IdJButton("Modify", i+1, table);
            modify.addActionListener(controller);
            ligne.add(modify);
        }
        JLabel labelTitle = new JLabel("Payment Mode", SwingConstants.CENTER);
        panelTitle.add(labelTitle, BorderLayout.NORTH);
        panelTitle.add(ligne, BorderLayout.CENTER);
        labelTitle.setPreferredSize(new Dimension(200, 100));
        p.add(panelTitle, BorderLayout.PAGE_START);
        parentPage.changePanel(p);
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<String> places) {
        this.places = places;
    }
}