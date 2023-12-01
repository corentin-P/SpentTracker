import java.sql.*;
import java.util.ArrayList;

public class ConnectionDB {
    private Connection con;
    private PreparedStatement stmt;
    private String url= "jdbc:mysql://localhost:3306/spendtracker";

    public ArrayList<String> getElementFromTable(String table, String ColumnName) {
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
        return getElementFromTable(table, "name");
    }
}
