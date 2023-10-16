package models;

public class BenhNhanModel extends NguoiModel {

    private String maBenhNhan;
    private String tenTaiKhoan;

    public BenhNhanModel() {
    }

    public BenhNhanModel(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public BenhNhanModel(String maBenhNhan, String tenTaiKhoan) {
        this.maBenhNhan = maBenhNhan;
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public BenhNhanModel(String maBenhNhan, String tenTaiKhoan, String hoVaTen, String soDienThoai, String emai, String gioiTinh, String diaChi, String hinhAnh) {
        super(hoVaTen, soDienThoai, emai, gioiTinh, diaChi, hinhAnh);
        this.maBenhNhan = maBenhNhan;
        this.tenTaiKhoan = tenTaiKhoan;
    }



    public String getTenTaiKhoan() {
        return tenTaiKhoan;
    }

    public void setTenTaiKhoan(String tenTaiKhoan) {
        this.tenTaiKhoan = tenTaiKhoan;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    @Override
    public String toString() {
        return "BenhNhanModel{" + "maBenhNhan=" + maBenhNhan + '}';
    }
}
