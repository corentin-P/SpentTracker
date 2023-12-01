import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JMenuItem){
            if (((JMenuItem)e.getSource()).getText().equals("Exit")){
                System.exit(0);
            }
            if (((JMenuItem)e.getSource()).getText().equals("Spend")){
                System.out.println("Spend");
            }
            if (((JMenuItem)e.getSource()).getText().equals("Categories")){
                view.changePanel(model.names("categories"));
            }
            if (((JMenuItem)e.getSource()).getText().equals("Firms")){
                view.changePanel(model.names("firms"));
            }
            if (((JMenuItem)e.getSource()).getText().equals("Payment Mode")){
                view.changePanel(model.names("mode"));
            }
            if (((JMenuItem)e.getSource()).getText().equals("People")){
                System.out.println("People");
            }
        }

    }
}
