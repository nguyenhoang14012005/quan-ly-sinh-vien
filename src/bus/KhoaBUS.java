package bus;

import dao.KhoaDAO;
import dto.Khoa;
import java.util.List;

public class KhoaBUS {
    private KhoaDAO khoaDAO = new KhoaDAO();

    public List<Khoa> getAll() { 
        return khoaDAO.getAll(); 
    }

    public String insert(Khoa k) {
        if (k.getMaKhoa().isEmpty() || k.getTenKhoa().isEmpty()) 
            return "Mã và Tên Khoa không được để trống!";
        if (khoaDAO.insert(k)) 
            return "Thêm thành công!";
        return "Thêm thất bại (Có thể trùng Mã)!";
    }

    public String update(Khoa k) {
        if (k.getTenKhoa().isEmpty()) 
            return "Tên Khoa không được để trống!";
        if (khoaDAO.update(k)) 
            return "Cập nhật thành công!";
        return "Cập nhật thất bại!";
    }

    public String delete(String ma) {
        if (khoaDAO.delete(ma)) 
            return "Xóa thành công!";
        return "Xóa thất bại (Khoa này có thể đang có Lớp học)!";
    }
}