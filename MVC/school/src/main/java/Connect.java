import java.sql.*;

public class Connect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/doan";
        String username = "root";
        String passwprd = "";

        try {
            Connection c = DriverManager.getConnection(url,username,passwprd);
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM doan.tablelop");
            while (r.next()){
                System.out.println(r.getString("tenlop"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
