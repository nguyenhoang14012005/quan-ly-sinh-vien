package dto;

public class Khoa {
    private String maKhoa;
    private String tenKhoa;
    private String vanPhong;
    private String dienThoai;
    private String truongKhoa;

    public Khoa() {
    }

    public Khoa(String maKhoa, String tenKhoa, String vanPhong, String dienThoai, String truongKhoa) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.vanPhong = vanPhong;
        this.dienThoai = dienThoai;
        this.truongKhoa = truongKhoa;
    }

    public String getMaKhoa() { return maKhoa; }
    public void setMaKhoa(String maKhoa) { this.maKhoa = maKhoa; }
    public String getTenKhoa() { return tenKhoa; }
    public void setTenKhoa(String tenKhoa) { this.tenKhoa = tenKhoa; }
    public String getVanPhong() { return vanPhong; }
    public void setVanPhong(String vanPhong) { this.vanPhong = vanPhong; }
    public String getDienThoai() { return dienThoai; }
    public void setDienThoai(String dienThoai) { this.dienThoai = dienThoai; }
    public String getTruongKhoa() { return truongKhoa; }
    public void setTruongKhoa(String truongKhoa) { this.truongKhoa = truongKhoa; }

    @Override
    public String toString() { return tenKhoa; }
}