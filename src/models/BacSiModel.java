package models;


public class BacSiModel extends NguoiModel{
    private String maBacSi;
    private String chuyenKhoa;
    private String kinhNgiemLamViec;
    private String hocVan;

    public BacSiModel() {
    }

    public BacSiModel(String maBacSi, String chuyenKhoa, String kinhNgiemLamViec, String hocVan) {
        this.maBacSi = maBacSi;
        this.chuyenKhoa = chuyenKhoa;
        this.kinhNgiemLamViec = kinhNgiemLamViec;
        this.hocVan = hocVan;
    }

    public BacSiModel(String maBacSi, String chuyenKhoa, String kinhNgiemLamViec, String hocVan, String hoVaTen, String soDienThoai, String emai, String gioiTinh, String diaChi, String hinhAnh) {
        super(hoVaTen, soDienThoai, emai, gioiTinh, diaChi, hinhAnh);
        this.maBacSi = maBacSi;
        this.chuyenKhoa = chuyenKhoa;
        this.kinhNgiemLamViec = kinhNgiemLamViec;
        this.hocVan = hocVan;
    }    

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getChuyenKhoa() {
        return chuyenKhoa;
    }

    public void setChuyenKhoa(String chuyenKhoa) {
        this.chuyenKhoa = chuyenKhoa;
    }

    public String getKinhNgiemLamViec() {
        return kinhNgiemLamViec;
    }

    public void setKinhNgiemLamViec(String kinhNgiemLamViec) {
        this.kinhNgiemLamViec = kinhNgiemLamViec;
    }

    public String getHocVan() {
        return hocVan;
    }

    public void setHocVan(String hocVan) {
        this.hocVan = hocVan;
    }
}
