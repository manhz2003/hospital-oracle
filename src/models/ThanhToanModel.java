package models;


public class ThanhToanModel {
    private String maThanhToan;
    private String soTaiKhoan;
    private String tenTaiKhoan;
    private String tenNganhang;
    private String thoiGianThanhToan;
    private String tenDangNhap;

    public ThanhToanModel() {
    }

    public ThanhToanModel(String maThanhToan, String soTaiKhoan, String tenTaiKhoan, String tenNganhang, String thoiGianThanhToan, String tenDangNhap) {
        this.maThanhToan = maThanhToan;
        this.soTaiKhoan = soTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.tenNganhang = tenNganhang;
        this.thoiGianThanhToan = thoiGianThanhToan;
        this.tenDangNhap = tenDangNhap;
    }

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getTenNganhang() {
        return tenNganhang;
    }

    public void setTenNganhang(String tenNganhang) {
        this.tenNganhang = tenNganhang;
    }

    public String getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(String thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Override
    public String toString() {
        return "ThanhToanModel{" + "maThanhToan=" + maThanhToan + ", soTaiKhoan=" + soTaiKhoan + ", tenTaiKhoan=" + tenTaiKhoan + ", tenNganhang=" + tenNganhang + ", thoiGianThanhToan=" + thoiGianThanhToan + ", tenDangNhap=" + tenDangNhap + '}';
    }
    
    
}
