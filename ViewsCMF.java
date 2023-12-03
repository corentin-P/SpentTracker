import java.util.ArrayList;

public abstract class ViewsCMF {
    protected View parentPage;
    protected ArrayList<String> names;
    protected Controller controller;

    /** Creates a ViewsCMF
     *
     * @param parentPage : main page of the app
     * @param names : names from the db
     */
    public ViewsCMF(View parentPage, ArrayList<String> names) {
        this.names = names;
        this.parentPage = parentPage;
    }

    /** add a controller to the View
     *
     * @param controller
     */
    public void addController(Controller controller){
        this.controller = controller;
    }

    public ArrayList<String> getNames() {
        return names;
    }
    public void setNames(ArrayList<String> names) {
        this.names = names;
    }
    public void setName(int id, String value) {
        names.set(id, value);
    }

    /** displays the page of the app
     *
     * @param table : table of the db where the datas of the page are located
     */
    public abstract void display(String table);

}
