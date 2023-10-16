package models;


public class QuanLyTaiKhoanModel {
    private String hoVaTen;
    private String tenDangNhap;
    private String matKhau;
    private String email;
    private String GioiTinh;
      
    public QuanLyTaiKhoanModel() {
    }

    public QuanLyTaiKhoanModel(String hoVaTen, String tenDangNhap, String matKhau, String email, String GioiTinh) {
        this.hoVaTen = hoVaTen;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.GioiTinh = GioiTinh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    @Override
    public String toString() {
        return "DangKy{" + "hoVaTen=" + hoVaTen + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + ", email=" + email + ", GioiTinh=" + GioiTinh + '}';
    }
}
