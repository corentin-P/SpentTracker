import javax.swing.*;

public class IdJButton extends JButton {
    private int id;
    private String table;

    public IdJButton(String text, int id, String table) {
        super(text);
        this.id = id;
        this.table = table;
    }

    public int getId() {
        return id;
    }

    public String getTable() {
        return table;
    }
}
