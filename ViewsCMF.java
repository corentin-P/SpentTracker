import java.util.ArrayList;

public abstract class ViewsCMF {
    protected View parentPage;
    protected ArrayList<String> names;
    protected Controller controller;

    public ViewsCMF(View parentPage, ArrayList<String> names) {
        this.names = names;
        this.parentPage = parentPage;
    }
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

    public abstract void display(String table);

}
