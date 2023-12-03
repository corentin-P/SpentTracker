import java.sql.*;
import java.util.ArrayList;

public class ConnectionDB {
    private Connection con;
    private PreparedStatement stmt;
    private String url= "jdbc:mysql://localhost:3306/SpentTracker";

    public ArrayList<String> getElementsFromTable(String table, String ColumnName) {
        String query = "Select " + ColumnName + " from " + table;
        ArrayList<String> elements = new ArrayList<String>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException (try:)");
            System.err.print(e.getMessage());
        }
        try{
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                String name = rs.getString(ColumnName);
                elements.add(name);
            }
            stmt.close();
            con.close();

        }catch(SQLException e){
            System.err.println("SQL Exception :"+ e.getMessage());
        }
        return elements;
    }

    /**
     *
     * @param table : "categories" or "firms" or "mode"
     *
     * return column 'name' from table
     */
    public ArrayList<String> getNames (String table){
        return getElementsFromTable(table, "name");
    }

    public boolean modifyStringElementOfTable(int id, String table, String ColumnName, String element) {
        String query = "Update " + table + " SET " + ColumnName + " = ? where id = ?";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException (try:)");
            System.err.print(e.getMessage());
            return false;
        }
        try{
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.prepareStatement(query);
            stmt.setString(1, element);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }catch(SQLException e){
            System.err.println("SQL Exception :"+ e.getMessage());
            return false;
        }
        return true;
    }

    public boolean insertNamePlaceInCMF(String table, String[] values){
        String query = "INSERT INTO " + table + "(name"+(table.equals("firms") ? ", place" :"" )+") Values(? "+(table.equals("firms") ? "?":"")+" )";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException (try:)");
            System.err.print(e.getMessage());
            return false;
        }
        try{
            con = DriverManager.getConnection(url, "root", "");
            stmt = con.prepareStatement(query);
            stmt.setString(1, values[0]);
            if (table.equals("firms")) stmt.setString(2, values[1]);
            stmt.executeUpdate();
            stmt.close();
            con.close();

        }catch(SQLException e){
            System.err.println("SQL Exception :"+ e.getMessage());
            return false;
        }
        return true;
    }
}
