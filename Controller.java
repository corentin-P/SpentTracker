import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private Model model;

    /** Creates a controller
     *
     * @param : view = vue principale de l'application
     */
    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }


    @Override
    /** Manages the events of the application
     *
     * @param e : event
     * */
    public void actionPerformed(ActionEvent e) {
        // manage the content of the menus
        if(e.getSource() instanceof JMenuItem){
            JMenuItem item =  ((JMenuItem)e.getSource());
            String text = item.getText();
            if (text.equals("Exit")){
                System.exit(0);
            }
            else if (text.equals("Spend")){
                System.out.println("Spend");
            }
            else if (text.equals("Categories")){
                model.names("categories", "Categories");
            }
            else if (text.equals("Firms")){
                model.names("firms", "Firms");
            }
            else if (text.equals("Payment Mode")){
                model.names("mode", "Payment Mode");
            }
            else if (text.equals("People")){
                System.out.println("People");
            }
        }


        if (e.getSource() instanceof IdJButton) {
            IdJButton element = ((IdJButton)e.getSource());
            String title = element.getTable();
            if (title.equals("categories")) {
                try {
                    model.modifyCMF(title, element.getId());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (title.equals("mode")) {
                try {
                    model.modifyCMF(title, element.getId());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if (title.equals("firms")) {
                try {
                    model.modifyCMF(title, element.getId());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
