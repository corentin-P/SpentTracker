import java.util.HashMap;

public class Model {
    private ConnectionDB connection;
    private View view;
    private HashMap<String, Views> views;

    /** Creates a model */
    public Model(ConnectionDB c, View v, HashMap<String, Views> views){
        this.connection = c;
        this.view = v;
        this.views = views;
    }

    /** add the names of the table on the view
     *
     * @param table : table name "categories" or "firms" or "mode"
     */
    public void names(String table, String title)
    {
        ((ViewsCMF)views.get(table)).display(table);
    }

    /** modify one line of the table
     *
     * @param table : table to modify (categories, mode, firms)
     * @param id : id of the line to modify
     */
    public void modifyCMF(String table, int id) throws Exception{
        if (table.equals("categories") || table.equals("mode") || table.equals("firms")) {
            new ViewModifyCMF(table, connection, id, views);
        } else {
            throw new Exception("table not found");
        }
    }
}
