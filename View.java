import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public  class View extends JFrame implements Views{
    private JPanel principal;
    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit;
    private JMenuItem menuItemExit, menuItemSpend, menuItemCategories, menuItemFirms, menuItemMode, menuItemPeople;
    private Controller controller;

    /** Creates a View */
    public View(){
        super("SpendTracker");
        principal = new JPanel();
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");
        menuItemExit = new JMenuItem("Exit");
        menuItemSpend = new JMenuItem("Spend");
        menuItemCategories = new JMenuItem("Categories");
        menuItemFirms = new JMenuItem("Firms");
        menuItemMode = new JMenuItem("Payment Mode");
        menuItemPeople = new JMenuItem("People");

        menuFile.add(menuItemExit);
        menuEdit.add(menuItemSpend);
        menuEdit.add(menuItemCategories);
        menuEdit.add(menuItemFirms);
        menuEdit.add(menuItemMode);
        menuEdit.add(menuItemPeople);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);


        setJMenuBar(menuBar);
        add(principal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setExtendedState(this.MAXIMIZED_BOTH);

    }

    /** Add an actionListener for all the swing elements that need one
     *
     * @param controller : main controller of the application
     */
    public void addController(Controller controller){
        this.controller = controller;
        menuItemExit.addActionListener(controller);
        menuItemSpend.addActionListener(controller);
        menuItemCategories.addActionListener(controller);
        menuItemFirms.addActionListener(controller);
        menuItemMode.addActionListener(controller);
        menuItemPeople.addActionListener(controller);
    }

    /** Change the principal panel
     *
     * @param p : new principal panel
     */
    public void changePanel(JPanel p){
        remove(principal);
        principal = p;
        add(principal);
        repaint();
        setVisible(true);
    }

    /** displays the page for the categories/firms/Payment mode menus
     *
     * @param names : names from a table
     * @param table : table of the datas
     * @param title : title of the page (just for display)
     */
    public void names(ArrayList<String> names, String table, String title){
        JPanel p = new JPanel();
        JPanel panelTitle = new JPanel(new BorderLayout());
        JPanel ligne = new JPanel(new GridLayout(names.size(), 2));
        for (int i = 0; i<names.size(); i++){
            ligne.add(new JLabel(names.get(i)));
            IdJButton modify = new IdJButton("Modify", i+1, table);
            modify.addActionListener(controller);
            ligne.add(modify);
        }

        JLabel labelTitle = new JLabel(title, SwingConstants.CENTER);
        panelTitle.add(labelTitle, BorderLayout.NORTH);
        panelTitle.add(ligne, BorderLayout.CENTER);
        labelTitle.setPreferredSize(new Dimension(200, 100));
        p.add(panelTitle, BorderLayout.PAGE_START);
        changePanel(p);
    }

}
