
package dao;
import dto.TaiKhoan;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class TaiKhoanDAO {
    public TaiKhoan checkLogin(String tenDangNhap, String matKhau){
        TaiKhoan tk = null;
        String sql = "SELECT * FROM tblDangNhap Where TenDangNhap = ? AND MatKhau = ?";
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //Nếu tìm thấy=>tạo đối tượng TaiKhoan
                tk = new TaiKhoan();
                tk.setTenDangNhap(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matKhau"));
                tk.setVaiTro(rs.getString("vaiTro"));
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tk;
    }
}
