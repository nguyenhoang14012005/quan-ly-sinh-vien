package bus;

import dao.MonHocDAO;
import dto.MonHoc;
import java.util.List;

public class MonHocBUS {
    private MonHocDAO mhDAO = new MonHocDAO();

    // Lấy toàn bộ danh sách
    public List<MonHoc> getAll() {
        return mhDAO.getAll();
    }

    // Lấy một môn học theo Mã
    public MonHoc getById(String maMH) {
        // Tìm trong danh sách tất cả để trả về đối tượng khớp mã
        List<MonHoc> list = mhDAO.getAll();
        for (MonHoc mh : list) {
            if (mh.getMaMon().equalsIgnoreCase(maMH)) {
                return mh;
            }
        }
        return null;
    }

    // Thêm môn học (có kiểm tra trùng mã)
    public String addMonHoc(MonHoc mh) {
        if (mhDAO.checkExist(mh.getMaMon())) {
            return "Mã môn học đã tồn tại!";
        }
        if (mhDAO.insert(mh)) {
            return "Thêm môn học thành công!";
        }
        return "Thêm thất bại!";
    }

    // Cập nhật môn học
    public String updateMonHoc(MonHoc mh) {
        if (mhDAO.update(mh)) {
            return "Cập nhật thành công!";
        }
        return "Cập nhật thất bại!";
    }

    // Xóa môn học
    public String deleteMonHoc(String maMH) {
        if (mhDAO.delete(maMH)) {
            return "Xóa môn học thành công!";
        }
        return "Xóa thất bại (Môn học có thể đang có dữ liệu điểm liên quan)!";
    }
}