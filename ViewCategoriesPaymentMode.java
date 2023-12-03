import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewCategoriesPaymentMode extends ViewsCMF implements Views{

    public ViewCategoriesPaymentMode(View parentPage, ArrayList<String> names) {
        super(parentPage, names);
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

}
