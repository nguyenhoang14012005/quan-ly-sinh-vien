
package bus;
import dao.TaiKhoanDAO;
import dto.TaiKhoan;

public class TaiKhoanBUS {
    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    
    public TaiKhoan getTaiKhoan(String user, String pass){
        return taiKhoanDAO.checkLogin(user, pass);
    }
}
