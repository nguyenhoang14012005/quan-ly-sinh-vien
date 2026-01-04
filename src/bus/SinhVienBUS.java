package bus;

import dao.SinhVienDAO;
import dto.SinhVien;
import helper.DataValidator;
import java.util.List;

public class SinhVienBUS {

    private SinhVienDAO sinhVienDAO = new SinhVienDAO();

    /**
     * Lấy toàn bộ danh sách sinh viên
     */
    public List<SinhVien> getAllSinhVien() {
        return sinhVienDAO.getAll();
    }
    
    // Giữ hàm này để tương thích nếu UI gọi getAll()
    public List<SinhVien> getAll() {
        return sinhVienDAO.getAll();
    }

    /**
     * Lấy danh sách sinh viên theo Lớp
     */
    public List<SinhVien> getSinhVienByLop(String maLop) {
        return sinhVienDAO.getByLop(maLop);
    }

    /**
     * Tìm kiếm sinh viên
     */
    public List<SinhVien> searchSinhVien(String keyword) {
        return sinhVienDAO.search(keyword);
    }
    
    /**
     * Lấy sinh viên theo ID
     * (Đã sửa lỗi "Not supported yet")
     */
    public SinhVien getById(String maSV) {
        return sinhVienDAO.getById(maSV);
    }

    /**
     * Thêm mới sinh viên
     */
    public String addSinhVien(SinhVien sv) {
        // 1. Kiểm tra các trường bắt buộc
        if (sv.getMaSV().isEmpty()) {
            return "Mã sinh viên không được để trống!";
        }
        
        // Chỉ kiểm tra Tên (bỏ qua Họ vì form không nhập)
        if (sv.getTenSV().isEmpty()) {
            return "Tên sinh viên không được để trống!";
        }
        
        if (sv.getMaLop().isEmpty()) {
            return "Vui lòng nhập Lớp!";
        }

        // 2. Kiểm tra định dạng Email (Nếu có nhập)
        if (sv.getEmail() != null && !sv.getEmail().isEmpty()) {
            if (!DataValidator.isEmailValid(sv.getEmail())) {
                return "Email không đúng định dạng!";
            }
        }

        // 3. Kiểm tra số điện thoại (Nếu có nhập)
        if (sv.getDienThoai() != null && !sv.getDienThoai().isEmpty()) {
            if (!DataValidator.isPhoneValid(sv.getDienThoai())) {
                return "Số điện thoại phải là 10 chữ số!";
            }
        }

        // 4. Kiểm tra trùng mã
        if (sinhVienDAO.existById(sv.getMaSV())) {
            return "Mã sinh viên " + sv.getMaSV() + " đã tồn tại!";
        }

        // 5. Gọi DAO insert
        if (sinhVienDAO.insert(sv)) {
            return "Thêm sinh viên thành công!";
        } else {
            return "Thêm thất bại! Vui lòng kiểm tra lại kết nối.";
        }
    }

    /**
     * Cập nhật thông tin sinh viên
     */
    public String updateSinhVien(SinhVien sv) {
        // Kiểm tra tên
        if (sv.getTenSV().isEmpty()) {
            return "Tên sinh viên không được để trống!";
        }

        // Validate Email
        if (sv.getEmail() != null && !sv.getEmail().isEmpty()) {
            if (!DataValidator.isEmailValid(sv.getEmail())) {
                return "Email không đúng định dạng!";
            }
        }

        // Validate Phone
        if (sv.getDienThoai() != null && !sv.getDienThoai().isEmpty()) {
            if (!DataValidator.isPhoneValid(sv.getDienThoai())) {
                return "Số điện thoại phải là 10 chữ số!";
            }
        }

        if (sinhVienDAO.update(sv)) {
            return "Cập nhật thành công!";
        } else {
            return "Cập nhật thất bại!";
        }
    }

    /**
     * Xóa sinh viên
     */
    public String deleteSinhVien(String maSV) {
        if (sinhVienDAO.delete(maSV)) {
            return "Xóa thành công!";
        } else {
            return "Xóa thất bại! (Có thể sinh viên đang có điểm hoặc dữ liệu liên quan)";
        }
    }
}