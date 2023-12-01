import javax.swing.*;
import java.awt.*;

public  class View extends JFrame {
    private JPanel principal;
    private JMenuBar menuBar;
    private JMenu menuFile, menuEdit;
    private JMenuItem menuItemExit, menuItemSpend, menuItemCategories, menuItemFirms, menuItemMode, menuItemPeople;
    private Controller controller;
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

    public void addController(Controller controller){
        menuItemExit.addActionListener(controller);
        menuItemSpend.addActionListener(controller);
        menuItemCategories.addActionListener(controller);
        menuItemFirms.addActionListener(controller);
        menuItemMode.addActionListener(controller);
        menuItemPeople.addActionListener(controller);
    }

    public void changePanel(JPanel p){
        remove(principal);
        principal = p;
        add(principal);
        repaint();
        setVisible(true);
        pack();
        setExtendedState(this.MAXIMIZED_BOTH);
    }


}
