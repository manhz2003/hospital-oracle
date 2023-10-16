package models;

public class DatLichKhamModel {

    private String maDatLich;
    private float giaDichVuKham;
    private String thoiGioiKham;
    private String diaChiKham;
    private String tenDangNhap;
    private String trangThaiThanhToan;
    private String maBacSi;
    private String chuyenKhoa;

    public DatLichKhamModel() {
    }

    public DatLichKhamModel(String maDatLich, float giaDichVuKham, String thoiGioiKham, String diaChiKham, String tenDangNhap, String trangThaiThanhToan, String maBacSi, String chuyenKhoa) {
        this.maDatLich = maDatLich;
        this.giaDichVuKham = giaDichVuKham;
        this.thoiGioiKham = thoiGioiKham;
        this.diaChiKham = diaChiKham;
        this.tenDangNhap = tenDangNhap;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.maBacSi = maBacSi;
        this.chuyenKhoa = chuyenKhoa;
    }



    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getMaDatLich() {
        return maDatLich;
    }

    public void setMaDatLich(String maDatLich) {
        this.maDatLich = maDatLich;
    }

    public float getGiaDichVuKham() {
        return giaDichVuKham;
    }

    public void setGiaDichVuKham(float giaDichVuKham) {
        this.giaDichVuKham = giaDichVuKham;
    }

    public String getThoiGioiKham() {
        return thoiGioiKham;
    }

    public void setThoiGioiKham(String thoiGioiKham) {
        this.thoiGioiKham = thoiGioiKham;
    }

    public String getDiaChiKham() {
        return diaChiKham;
    }

    public void setDiaChiKham(String diaChiKham) {
        this.diaChiKham = diaChiKham;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    @Override
    public String toString() {
        return "DatLichKhamModel{" + "maDatLich=" + maDatLich + ", giaDichVuKham=" + giaDichVuKham + ", thoiGioiKham=" + thoiGioiKham + ", diaChiKham=" + diaChiKham + ", tenDangNhap=" + tenDangNhap + ", maBacSi=" + maBacSi + '}';
    }

}
