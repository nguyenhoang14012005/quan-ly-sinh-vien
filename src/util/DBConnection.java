package util;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection{
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/quanlysinhvien";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] ai){
        Connection c = getConnection();
        if(c !=null){
            System.out.println("Ket noi thanh cong");
        }else{
            System.out.println("Ket noi khong thanh cong");
        }
    }
}