package helper;

import dto.TaiKhoan;

public class ShareData {
//   lưu thông tin người dùng đăng nhập
    public static TaiKhoan nguoiDangNhap = null;
//    xóa thông tin khi người dùng đăng xuất
    public static void dangXuat() {
        nguoiDangNhap = null;
    }

//   kiểm tra đăng nhập
    public static boolean isLogin() {
        return nguoiDangNhap != null;
    }

    public static String getVaiTro() {
        if (nguoiDangNhap != null) {
            return nguoiDangNhap.getVaiTro();
        }
        return "";
    }
}
