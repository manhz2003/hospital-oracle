package models;

public class NguoiModel {

    private String hoVaTen;
    private String soDienThoai;
    private String emai;
    private String gioiTinh;
    private String diaChi;
    private String hinhAnh;

    public NguoiModel() {
    }

    public NguoiModel(String hoVaTen, String soDienThoai, String emai, String gioiTinh, String diaChi, String hinhAnh) {
        this.hoVaTen = hoVaTen;
        this.soDienThoai = soDienThoai;
        this.emai = emai;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmai() {
        return emai;
    }

    public void setEmai(String emai) {
        this.emai = emai;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NguoiModel{" + "hoVaTen=" + hoVaTen + ", soDienThoai=" + soDienThoai + ", emai=" + emai + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + '}';
    }

    
    
}
