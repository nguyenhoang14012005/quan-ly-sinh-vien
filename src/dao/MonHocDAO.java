package dao;

import dto.MonHoc;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MonHocDAO {

    // Lấy danh sách môn học (Đã có sẵn)
    public List<MonHoc> getAll() {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM tblMonHoc ORDER BY TenMon";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MonHoc mh = new MonHoc();
                mh.setMaMon(rs.getString("MaMon"));
                mh.setTenMon(rs.getString("TenMon"));
                mh.setKyHoc(rs.getString("KyHoc"));
                mh.setSoTinChi(rs.getInt("SoTinChi"));
                list.add(mh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Thêm môn mới (Đã có sẵn)
    public boolean insert(MonHoc mh) {
        String sql = "INSERT INTO tblMonHoc (MaMon, TenMon, KyHoc, SoTinChi) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mh.getMaMon());
            ps.setString(2, mh.getTenMon());
            ps.setString(3, mh.getKyHoc());
            ps.setInt(4, mh.getSoTinChi());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật thông tin môn học (Đã có sẵn)
    public boolean update(MonHoc mh) {
        String sql = "UPDATE tblMonHoc SET TenMon=?, KyHoc=?, SoTinChi=? WHERE MaMon=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, mh.getTenMon());
            ps.setString(2, mh.getKyHoc());
            ps.setInt(3, mh.getSoTinChi());
            ps.setString(4, mh.getMaMon());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Xóa môn học (Đã có sẵn)
    public boolean delete(String maMon) {
        String sql = "DELETE FROM tblMonHoc WHERE MaMon=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, maMon);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Không thể xóa môn học này vì đã có dữ liệu điểm liên quan.");
        }
        return false;
    }

    // Kiểm tra mã môn học tồn tại (Đã có sẵn)
    public boolean checkExist(String maMon) {
        String sql = "SELECT 1 FROM tblMonHoc WHERE MaMon=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maMon);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Tìm kiếm môn học theo tên hoặc mã (Đã có sẵn)
    public List<MonHoc> search(String keyword) {
        List<MonHoc> list = new ArrayList<>();
        String sql = "SELECT * FROM tblMonHoc WHERE TenMon LIKE ? OR MaMon LIKE ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String query = "%" + keyword + "%";
            ps.setString(1, query);
            ps.setString(2, query);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MonHoc mh = new MonHoc();
                    mh.setMaMon(rs.getString("MaMon"));
                    mh.setTenMon(rs.getString("TenMon"));
                    mh.setKyHoc(rs.getString("KyHoc"));
                    mh.setSoTinChi(rs.getInt("SoTinChi"));
                    list.add(mh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Lấy môn học theo ID (Đã sửa lỗi Unsupported)
    public MonHoc getById(String maMH) {
        String sql = "SELECT * FROM tblMonHoc WHERE MaMon=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, maMH);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MonHoc mh = new MonHoc();
                    mh.setMaMon(rs.getString("MaMon"));
                    mh.setTenMon(rs.getString("TenMon"));
                    mh.setKyHoc(rs.getString("KyHoc"));
                    mh.setSoTinChi(rs.getInt("SoTinChi"));
                    return mh;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Đọc danh sách môn học (Sửa lỗi Unsupported bằng cách gọi getAll)
    public List<MonHoc> readMonHoc() {
        return getAll();
    }
}