package dao;

import dto.Khoa;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhoaDAO {
    // Lấy danh sách
    public List<Khoa> getAll() {
        List<Khoa> list = new ArrayList<>();
        String sql = "SELECT * FROM tblKhoa";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Khoa(
                    rs.getString("MaKhoa"), 
                    rs.getString("TenKhoa"), 
                    rs.getString("VanPhong"), 
                    rs.getString("DienThoai"), 
                    rs.getString("TruongKhoa")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // Thêm
    public boolean insert(Khoa k) {
        String sql = "INSERT INTO tblKhoa VALUES(?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, k.getMaKhoa());
            ps.setString(2, k.getTenKhoa());
            ps.setString(3, k.getVanPhong());
            ps.setString(4, k.getDienThoai());
            ps.setString(5, k.getTruongKhoa());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }

    // Sửa
    public boolean update(Khoa k) {
        String sql = "UPDATE tblKhoa SET TenKhoa=?, VanPhong=?, DienThoai=?, TruongKhoa=? WHERE MaKhoa=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, k.getTenKhoa());
            ps.setString(2, k.getVanPhong());
            ps.setString(3, k.getDienThoai());
            ps.setString(4, k.getTruongKhoa());
            ps.setString(5, k.getMaKhoa());
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }

    // Xóa
    public boolean delete(String ma) {
        String sql = "DELETE FROM tblKhoa WHERE MaKhoa=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ma);
            return ps.executeUpdate() > 0;
        } catch (Exception e) { return false; }
    }
}