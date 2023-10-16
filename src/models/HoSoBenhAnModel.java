package models;

public class HoSoBenhAnModel {

    private String maHoSo;
    private String maBacSi;
    private String maBenhNhan;
    private String trieuChung;
    private String tienSuBenhAn;
    private String chuanDoan;
    private String ketLuan;

    public HoSoBenhAnModel() {
    }

    public HoSoBenhAnModel(String maHoSo, String maBacSi, String maBenhNhan, String trieuChung, String tienSuBenhAn, String chuanDoan, String ketLuan) {
        this.maHoSo = maHoSo;
        this.maBacSi = maBacSi;
        this.maBenhNhan = maBenhNhan;
        this.trieuChung = trieuChung;
        this.tienSuBenhAn = tienSuBenhAn;
        this.chuanDoan = chuanDoan;
        this.ketLuan = ketLuan;
    }

    public String getMaHoSo() {
        return maHoSo;
    }

    public void setMaHoSo(String maHoSo) {
        this.maHoSo = maHoSo;
    }

    public String getMaBacSi() {
        return maBacSi;
    }

    public void setMaBacSi(String maBacSi) {
        this.maBacSi = maBacSi;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTrieuChung() {
        return trieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        this.trieuChung = trieuChung;
    }

    public String getTienSuBenhAn() {
        return tienSuBenhAn;
    }

    public void setTienSuBenhAn(String tienSuBenhAn) {
        this.tienSuBenhAn = tienSuBenhAn;
    }

    public String getChuanDoan() {
        return chuanDoan;
    }

    public void setChuanDoan(String chuanDoan) {
        this.chuanDoan = chuanDoan;
    }

    public String getKetLuan() {
        return ketLuan;
    }

    public void setKetLuan(String ketLuan) {
        this.ketLuan = ketLuan;
    }

    @Override
    public String toString() {
        return "HoSoBenhAnModel{" + "maHoSo=" + maHoSo + ", maBacSi=" + maBacSi + ", maBenhNhan=" + maBenhNhan + ", trieuChung=" + trieuChung + ", tienSuBenhAn=" + tienSuBenhAn + ", chuanDoan=" + chuanDoan + ", ketLuan=" + ketLuan + '}';
    }

}
