package bus;

import dao.LopDAO;
import dto.Lop;
import java.util.List;

public class LopBUS {

    private LopDAO lopDAO = new LopDAO();

    /**
     * Lấy danh sách tất cả các lớp
     * (Đã sửa tên từ getAllLop -> getAll để khớp với SinhVienPanel)
     */
    public List<Lop> getAll() {
        return lopDAO.getAll();
    }

    /**
     * Lấy thông tin chi tiết 1 lớp theo Mã (Dùng để check hoặc hiển thị)
     * (BỔ SUNG THÊM)
     */
    public Lop getById(String maLop) {
        return lopDAO.getById(maLop);
    }

    /**
     * Lấy danh sách lớp theo Khoa
     */
    public List<Lop> getLopByKhoa(String maKhoa) {
        return lopDAO.getByKhoa(maKhoa);
    }
    
    /**
     * Tìm kiếm lớp theo tên (BỔ SUNG CHO TƯƠNG LAI)
     */
    public List<Lop> searchLop(String keyword) {
        return lopDAO.search(keyword);
    }

    /**
     * Thêm lớp mới
     */
    public String addLop(Lop lop) {
        // 1. Validate dữ liệu
        if (lop.getMaLop().isEmpty() || lop.getTenLop().isEmpty()) {
            return "Mã lớp và Tên lớp không được để trống!";
        }

        if (lop.getMaKhoa().isEmpty()) {
            return "Vui lòng chọn Khoa trực thuộc!";
        }

        // 2. Kiểm tra trùng mã
        if (lopDAO.checkExist(lop.getMaLop())) {
            return "Mã lớp " + lop.getMaLop() + " đã tồn tại!";
        }

        // 3. Gọi DAO
        if (lopDAO.insert(lop)) {
            return "Thêm lớp thành công!";
        }
        return "Thêm thất bại!";
    }

    /**
     * Cập nhật thông tin lớp
     */
    public String updateLop(Lop lop) {
        if (lop.getTenLop().isEmpty()) {
            return "Tên lớp không được để trống!";
        }
        
        if (lopDAO.update(lop)) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    /**
     * Xóa lớp
     */
    public String deleteLop(String maLop) {
        // Lưu ý: SQL sẽ chặn xóa nếu lớp đang có sinh viên (Foreign Key)
        if (lopDAO.delete(maLop)) {
            return "Xóa thành công!";
        }
        return "Không thể xóa! (Lớp đang có sinh viên hoặc lỗi hệ thống)";
    }
}