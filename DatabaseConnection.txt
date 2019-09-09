import java.sql.*;
public class Main{
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "user", "pwd")){
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM students");
                int numOfColumns = rs.getMetaData().getColumnCount();
                while (rs.next()){
                    for (int col = 1; col <= numOfColumns; col++){
                        System.out.print(rs.getString(col) + " ");
                    }
                    System.out.println();
                }
            }} catch (Exception ex){ex.printStackTrace();}
    }
}

// ExecString query = "{CALL student_avg(?)}";
CallableStatement stmt = con.prepareCall(query);
int studentId = 222;
stmt.setInt(1, studentId);
ResultSet rs = stmt.executeQuery();
