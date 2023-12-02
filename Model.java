import java.util.ArrayList;

public class Model {
    private ConnectionDB connection;
    private View view;
    private ViewFirms mode;

    /** Creates a model */
    public Model(ConnectionDB c, View v, ViewFirms mode){
        this.connection = c;
        this.view = v;
        this.mode = mode;
    }

    /** add the names of the table on the view
     *
     * @param table : table name "categories" or "firms" or "mode"
     */
    public void names(String table, String title)
    {
        if (table.equals("mode")) {
            mode.display(table);
        } else {
            ArrayList<String> names = connection.getNames(table);
            view.names(names, table, title);
        }
    }

    /** modify one line of the table
     *
     * @param table : table to modify (categories, mode, firms)
     * @param id : id of the line to modify
     */
    public void modifyCMF(String table, int id) throws Exception{
        if (table.equals("categories") || table.equals("mode") || table.equals("firms")) {
            new ViewModify(table, connection, id, this);
        } else {
            throw new Exception("table not found");
        }
    }
}
